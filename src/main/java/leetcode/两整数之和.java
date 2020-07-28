package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/sum-of-two-integers/
 * @Author: lyq
 * @Date: 2020/6/7 13:47
 * @Month:06
 */
public class 两整数之和 {

    public static void main(String[] args) {
        getSum(8,55);
    }
    public  static int getSum(int a, int b) {
        String as = Integer.toBinaryString(a);
        String bs = Integer.toBinaryString(b);
        char[] ch1 = as.toCharArray();
        char[] ch2 = bs.toCharArray();
        int cur1=ch1.length-1,cur2=ch2.length-1;
        while(cur1>=0||cur2>=0){

        }
        System.out.println(ch1);
        System.out.println(ch2);
        return 0;
    }
}
