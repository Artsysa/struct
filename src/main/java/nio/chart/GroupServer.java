package nio.chart;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/7/15 14:45
 * @Month:07
 */
public class GroupServer {
    private ServerSocketChannel serverSocketChannel;
    private String host="127.0.0.1";
    private int port=9000;
    private Selector selector;

    GroupServer(){
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(host,port));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listen(){
        while(true){
            String ip="";
           try {
               int select = selector.select();
               if(select>0){
                   Set<SelectionKey> selectionKeys = selector.selectedKeys();
                   Iterator<SelectionKey> it = selectionKeys.iterator();
                   while (it.hasNext()){
                       SelectionKey next = it.next();
                       if(next.isAcceptable()){
                           SocketChannel accept = serverSocketChannel.accept();
                           accept.configureBlocking(false);
                           accept.register(selector,SelectionKey.OP_READ);
                           ip=accept.getLocalAddress().toString();
                           System.out.println(accept.getLocalAddress()+"-上线了");
                       }
                       if(next.isReadable()){
                           SocketChannel channel = (SocketChannel) next.channel();
                           ByteBuffer b = ByteBuffer.allocate(1024);
                           channel.read(b);
                           //System.out.println();
                         //  sendInfoToOtherClients(new String(b.array()),channel);
                           dispatch(b,channel);
                       }
                       it.remove();
                   }
               }
           } catch (Exception e) {
               System.out.println(ip+"关闭了客户端");
           }
        }
    }


    /**
     * 分发到其他客户端
     * @param b
     */
    private void dispatch(ByteBuffer b,Channel se){
        for(SelectionKey key:selector.keys()){
            Channel channel=key.channel();
            if (channel instanceof SocketChannel ) {

                //转型
                SocketChannel dest = (SocketChannel) channel;
                //将msg 存储到buffer
                b.flip();
                //ByteBuffer buffer = ByteBuffer.wrap(b.getBytes());
                //将buffer 的数据写入 通道
                try {
                    dest.write(b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
//        //System.out.println("转发信息");
//        Set<SelectionKey> keys = selector.keys();
//       // System.out.println(keys.size());
//        Iterator<SelectionKey> it = keys.iterator();
//       //  int count=0;
//        while(it.hasNext()){
//            SelectionKey next = it.next();
//            SelectableChannel channel1 = next.channel();
//            if(channel1 instanceof SocketChannel&&channel1!=se){
//               // count++;
//                SocketChannel  channel = (SocketChannel) channel1;
//                try {
//                    channel.write(b);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }

    }

    //转发消息给其它客户(通道)
    private void sendInfoToOtherClients(String msg, SocketChannel self ) throws IOException {

        System.out.println("服务器转发消息中...");
        System.out.println("服务器转发数据给客户端线程: " + Thread.currentThread().getName());
        //遍历 所有注册到selector 上的 SocketChannel,并排除 self
        for (SelectionKey key : selector.keys()) {

            //通过 key  取出对应的 SocketChannel
            Channel targetChannel = key.channel();

            //排除自己
            if (targetChannel instanceof SocketChannel && targetChannel != self) {

                //转型
                SocketChannel dest = (SocketChannel) targetChannel;
                //将msg 存储到buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                //将buffer 的数据写入 通道
                dest.write(buffer);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        GroupServer groupServer = new GroupServer();
       new Thread(()->{
           groupServer.listen();
       }).start();

    }
}
