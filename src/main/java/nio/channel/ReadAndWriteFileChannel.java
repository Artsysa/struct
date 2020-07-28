package nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/7/15 9:00
 * @Month:07
 */
public class ReadAndWriteFileChannel {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("d:\\a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\b.txt");
        FileChannel read = inputStream.getChannel();
        FileChannel write = fileOutputStream.getChannel();
        ByteBuffer b = ByteBuffer.allocate(60);
        read.read(b);
        b.flip();
        System.out.println(b.toString());
        write.write(b);
        inputStream.close();
        fileOutputStream.close();
    }
}
