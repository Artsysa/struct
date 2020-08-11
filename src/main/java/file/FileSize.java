package file;

import java.io.File;

/*
 * @describe:
 * @author: lyq
 * @date: 2020/8/11 11:48
 */
public class FileSize {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\MECHREV\\AppData");
        String[] list = file.list();
    }
}
