package leetcode;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Arrays;

/*
 * @breif:https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * @Author: lyq
 * @Date: 2020/5/18 10:39
 * @Month:05
 */
public class 翻转单词 {

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
    }

    public static String reverseWords(String s) {

        String[] str=s.trim().split(" ");
        String news="";
        for(int i=str.length-1;i>=0;i--){
                news+=str[i];
            if(i>0)
                news+=" ";
        }
        return news;
    }
}
