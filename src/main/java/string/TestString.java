package string;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/*
 * @describe:
 * @author: lyq
 * @date: 2020/7/27 13:24
 */
public class TestString {

    public static void main(String[] args) {
        String str = new String("ccc")+new String("bbb");
        String str1 = str.intern();
        String str2="aaa"+"bbb";
        String str22 = str2.intern();
        String str3=new String("ccccc");
        String str33 = str3.intern();
        System.out.println(str3==str33);
        System.out.println(str2==str22);
        System.out.println("cccbbb"==str1);
        System.out.println(str1==str);
    }
    private void test(){
        System.out.println("fff");
    }
}

class AAA{
    String str = "sss";

    public static void main(String[] args) {
        AAA aaa = new AAA();
        aaa.test(aaa.str);
        System.out.println(aaa.str);
    }

    public void test(String str){
        str="gggg";
    }
}