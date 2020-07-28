package leetcode;

import java.util.*;

/*
 * @breif:https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @Author: lyq
 * @Date: 2020/5/25 17:20
 * @Month:05
 */
public class 最长回文子串 {

    public  static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
        Stack stack=new Stack<>();
    }

    public static String longestPalindrome(String s) {
        if( s.isEmpty())return "";
        char[] ch1 = s.toCharArray();
        boolean[][] dp=new boolean[ch1.length][ch1.length];
        int start=0,max=Integer.MIN_VALUE;
        for(int i=ch1.length-1;i>=0;i--){
            for(int j=i;j<ch1.length;j++){
                int step=j-i+1;
                if(step<=2)dp[i][j]=ch1[i]==ch1[j];
                else if(ch1[i]==ch1[j]&&dp[i+1][j-1]){
                    dp[i][j]=true;
                }else
                    dp[i][j]=false;
                if(step>=max&&dp[i][j]){
                    start=i;
                    max=step;
                }
            }
        }
        for (int i = 0; i <ch1.length ; i++) {
            for (int j=0;j<ch1.length;j++){
                System.out.print(dp[i][j]==true?"T"+"\t":"F"+"\t");

            }
            System.out.println();
        }
        System.out.println("max="+max+" start="+start);
        return new String(ch1,start,max);
    }
}
