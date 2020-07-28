package nio.chart;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/7/15 15:03
 * @Month:07
 */
public class GroupClient {
    private String host="127.0.0.1";
    private int port=9000;
    private Selector selector;
    private SocketChannel socketChannel;
    GroupClient(){
      try {
          selector=Selector.open();
          socketChannel=SocketChannel.open();
         if(!socketChannel.connect(new InetSocketAddress(host,port))){
             while(!socketChannel.finishConnect()){
             }
         }
          socketChannel.configureBlocking(false);
          socketChannel.register(selector, SelectionKey.OP_READ);
      } catch (Exception e) {
          e.printStackTrace();
      }
    }
    private void send(String msg){
        ByteBuffer wrap = ByteBuffer.wrap(msg.getBytes());
     try {
         socketChannel.write(wrap);
     } catch (Exception e) {
         e.printStackTrace();
     }
    }
    private void read(){
       try {
           int mm = selector.select();
           if(mm>0){
               Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
               while(iterator.hasNext()){
                   SelectionKey next = iterator.next();
                   if(next.isReadable()){
                       SocketChannel channel = (SocketChannel) next.channel();
                       ByteBuffer b = ByteBuffer.allocate(1024);
                       channel.read(b);
                       System.out.println(new String(b.array()));

                   }
                   iterator.remove();
               }
           }
       } catch (Exception e) {
        //   e.printStackTrace();
       }
    }

    //读取从服务器端回复的消息
    public void readInfo() {

        try {

            int readChannels = selector.select();
            if(readChannels > 0) {//有可以用的通道

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {

                    SelectionKey key = iterator.next();
                    if(key.isReadable()) {
                        //得到相关的通道
                        SocketChannel sc = (SocketChannel) key.channel();
                        //得到一个Buffer
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        //读取
                        sc.read(buffer);
                        //把读到的缓冲区的数据转成字符串
                        String msg = new String(buffer.array());
                        System.out.println(msg.trim());
                    }
                }
                iterator.remove(); //删除当前的selectionKey, 防止重复操作
            } else {
                //System.out.println("没有可以用的通道...");

            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GroupClient groupClient = new GroupClient();
        System.out.println("success connect");
        new Thread(()->{
          while(true){
              groupClient.read();
          }
        }).start();

        while(true){
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
          //  System.out.println("aa");
            groupClient.send(s);
        }


    }
}
