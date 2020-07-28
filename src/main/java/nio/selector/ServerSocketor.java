package nio.selector;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/7/15 10:43
 * @Month:07
 */
public class ServerSocketor {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        Selector select = Selector.open();
        server.socket().bind(new InetSocketAddress(9000));
        server.configureBlocking(false);
        server.register(select,SelectionKey.OP_ACCEPT);
        while(true){
            int current = select.select(1000);
            if(current == 0){
                continue;
            }
          //  System.out.println("entry");
            Set<SelectionKey> selectionKeys = select.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()){
                SelectionKey i = iterator.next();
                if(i.isAcceptable()){
                    SocketChannel socket = server.accept();
                    socket.configureBlocking(false);
                    socket.register(select,SelectionKey.OP_READ,ByteBuffer.allocate(1024));
                }
                if(i.isReadable()){
                    ByteBuffer b = (ByteBuffer) i.attachment();
                    SocketChannel channel = (SocketChannel) i.channel();
                    channel.read(b);
                    System.out.println(new String(b.array()));
                  //  b.clear();
                }
                iterator.remove();
            }
        }
    }
}


class Client{
    public static void main(String[] args) throws IOException {
        SocketChannel socket = SocketChannel.open();
        socket.configureBlocking(false);
        InetSocketAddress ip = new InetSocketAddress("127.0.0.1", 9000);
        if(!socket.connect(ip)){
            while(!socket.finishConnect()){
            }
        }
        ByteBuffer b = ByteBuffer.allocate(1024);
        b.put("helllllll".getBytes());
        socket.write(b);
        socket.close();
    }
}