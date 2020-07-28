package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/daily-temperatures/
 * @Author: lyq
 * @Date: 2020/6/9 19:52
 * @Month:06
 */
public class 每日温度 {

    public static void main(String[] args) {
        每日温度 a = new 每日温度();
        System.out.println(a.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
    public int[] dailyTemperatures(int[] T) {
        int[] dp=new int[T.length];
        for(int i=T.length-2;i>=0;i--){
            if(T[i]<T[i+1])
                dp[i]=i+1;
            else{
                int j = dp[i+1];
                while(j>i&&j<T.length){
                    if(T[i]<T[j]){
                        dp[i]=j;
                        break;
                    }
                    j++;
                }

            }
        }
        for (int i = 0; i < dp.length; i++) {
            if(dp[i]!=0){
                dp[i]=dp[i]-i;
            }
        }
        return dp;
    }
}
