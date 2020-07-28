package dp;

/*
 * @breif:https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @Author: lyq
 * @Date: 2020/5/10 11:05
 * @Month:05
 */
public class 最长上升子序列 {


    public static void main(String[] args) {
        int[] num=new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(num));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int max=dp[0]=1;
        for(int i=0;i<dp.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]<=nums[j]) continue;
                dp[i]=Math.max(dp[j]+1,dp[i]);
            }
            max=Math.max(max,dp[i]);
        }
        return max;

    }
}
