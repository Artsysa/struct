package leetcode;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/5/11 11:50
 * @Month:05
 */
public class 位1的个数 {

    public static void main(String[] args) {
        System.out.println(Long.parseLong("11111111111111111111111111111101",2));
      //  hammingWeight(11111111111111111111111111111101);
    }

    public static int hammingWeight(long n) {
        int count=0;
        while(n>0){
            if((n&1)==1)
                count++;
            n=n>>1;
        }
        return count;
    }
}
