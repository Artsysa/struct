package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/*
 * @breif:-XX:+PrintStringTableStatistics
 * @Author: lyq
 * @Date: 2020/6/3 22:47
 * @Month:06
 */
public class StringT {
   static String[] n=new String[10000*100];
    public static void main(String[] args) throws InterruptedException {
        Integer p=8;
        System.out.println((2&1)==0);

        int[] num=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        for (int i = 0; i < n.length; i++) {
            n[i]=String.valueOf(num[i&15]);
        }

//        String st1=new String("a")+new String("b");
//        String st2=new String("ab").intern();
//        String str="ab";
//        StringBuilder sb=new StringBuilder("a").append("b");
//        String st3=sb.toString().intern();
//        System.out.println(str==st1);
  //   System.out.println(str==st2);
//        System.out.println(st1==st2);
//        System.out.println(st1==st3);
        String s=new String("a")+new String("b");
        s.intern();
        //String st="ab";
        //System.out.println(s==s2);
        System.out.println(s=="ab");
        TimeUnit.SECONDS.sleep(1000000);

    }
}
