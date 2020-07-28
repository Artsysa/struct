package bio;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/7/14 17:00
 * @Month:07
 */
public class Server {

    ThreadPoolExecutor threadPoolExecutor;
    public Server(){
        threadPoolExecutor=new ThreadPoolExecutor(4,5,60, TimeUnit.SECONDS
                ,new LinkedBlockingQueue<>());
    }

    public static void main(String[] args) throws IOException {
        Server s = new Server();
        ServerSocket server = new ServerSocket(8888);
        while(true){
            Socket accept = server.accept();
            System.out.println(accept.getLocalAddress()+"连接了");
            s.threadPoolExecutor.execute(()->{
                try {
                    InputStream inputStream = accept.getInputStream();
                    byte[] b=new byte[1024];
                    while(true){
                        int read = inputStream.read(b);
                        if(read!=-1){
                            System.out.println(new java.lang.String(b,0,b.length));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}


class Client{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        OutputStream out = socket.getOutputStream();
        out.write("hhhh".getBytes());
        out.close();
    }
}