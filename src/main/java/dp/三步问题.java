package dp;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/5/13 10:41
 * @Month:05
 */
public class 三步问题 {
    public static void main(String[] args) {
        System.out.println(waysToStep(5));

    }
    public static int waysToStep(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}
