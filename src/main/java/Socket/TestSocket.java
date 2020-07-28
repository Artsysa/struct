package Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/7/2 22:57
 * @Month:07
 */
public class TestSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(9000);
        new Thread(()->{
          try {
              Socket accept = server.accept();
              InputStream inputStream = accept.getInputStream();
              byte[] b=new byte[1024];
              inputStream.read(b);
              System.out.println(new String(b));
          } catch (Exception e) {
              e.printStackTrace();
          }
        }).start();
        new Thread(()->{
            try {
                Socket accept = server.accept();
                InputStream inputStream = accept.getInputStream();
                byte[] b=new byte[1024];
                inputStream.read(b);
                System.out.println(new String(b));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }
}
class client{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",9000);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());
    }
}
