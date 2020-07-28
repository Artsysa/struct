package dp;

/*
 * @breif:https://leetcode-cn.com/problems/maximum-subarray/
 * @Author: lyq
 * @Date: 2020/5/10 10:07
 */
public class 最长子序列 {

    public static void main(String[] args) {
        最长子序列 a = new 最长子序列();
        int[] nums=new int[]{-1,-2};
        System.out.println(a.maxSubArray(nums));
        String str;

    }


    /**
     * 优化空间复杂度去掉dp数组
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int dp=nums[0];
        int max=dp;
        for(int i=1;i<nums.length;i++){
            if(dp<=0){
                dp=nums[i];
            }else{
                dp=dp+nums[i];
            }
            max=Math.max(max,dp);
        }
        return max;

    }


    public int maxSubArray(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int[] dp=new int[nums.length];
        int max=nums[0];
        dp[0]=nums[0];
        for(int i=1;i<dp.length;i++){
            if(dp[i-1]<=0){
                dp[i]=nums[i];
            }else{
                dp[i]=dp[i-1]+nums[i];
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

}
