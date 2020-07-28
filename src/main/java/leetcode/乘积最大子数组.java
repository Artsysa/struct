package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/maximum-product-subarray/
 * @Author: lyq
 * @Date: 2020/6/8 19:07
 * @Month:06
 */
public class 乘积最大子数组 {

    public static void main(String[] args) {
        乘积最大子数组 s = new 乘积最大子数组();
        System.out.println(s.maxProduct(new int[]{0, 2}));
    }
    public int maxProduct(int[] nums) {
        if(nums.length==1)return nums[0];
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=-9999;
        for(int i=1;i<dp.length;i++){
            if((nums[i]<0&&dp[i-1]<0)||(nums[i]>0&&dp[i-1]>0))
                dp[i]=dp[i-1]*nums[i];
            else
                dp[i]=nums[i];
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
