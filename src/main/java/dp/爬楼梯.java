package dp;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/5/11 11:09
 * @Month:05
 */
public class 爬楼梯 {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));

    }


    public  static int climbStairs(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        int first=1,second=1;
        for(int i=2;i<=n;i++){
            first=first+second;
            second=first-second;
        }
        return first;
    }

    public  static int climbStairs1(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[(i-2)]+dp[(i-1)];
        }
        return dp[n];
    }

    public  static int climbStairs2(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        int[] dp=new int[2];
        dp[0]=1;
        dp[1]=2;
        for(int i=3;i<=n;i++){
            dp[(i+1)&1]=dp[0]+dp[1];
        }
        return dp[(n+1)&1];
    }
}
