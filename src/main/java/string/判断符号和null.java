package string;

import java.util.ArrayList;
import java.util.Objects;

/*
 * @describe:
 * @author: lyq
 * @date: 2020/8/8 8:47
 */
public class 判断符号和null {
    public static void main(String[] args) {
        String str = null;
        String str1 = "";
        boolean isEqual =  (str1 == null || str1 == "") && (str == null || str == "");
        System.out.println(  !Objects.equals(str, str1) && !isEqual);
    }
}

