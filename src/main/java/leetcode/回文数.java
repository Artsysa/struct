package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/palindrome-number/
 * @Author: lyq
 * @Date: 2020/5/23 11:46
 * @Month:05
 */
public class 回文数  {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        int temp=x;
        int res=0,i=0;
        while(temp>0){
            res+=temp%10*Math.pow(10,i++);
            temp/=10;
        }
        if(x>0&&x==res)return true;
        else return false;
    }
}
