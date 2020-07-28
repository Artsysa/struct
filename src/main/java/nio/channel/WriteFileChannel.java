package nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/7/14 20:38
 * @Month:07
 */
public class WriteFileChannel {
    public static void main(String[] args) throws IOException {
        FileOutputStream inputStream = new FileOutputStream("D:\\a.txt");
        FileChannel channel = inputStream.getChannel();
        ByteBuffer b = ByteBuffer.allocate(50);
        b.put("hhhhhhhnihaoya".getBytes());
        b.flip();
        channel.write(b);
        inputStream.close();
    }
}
