package leetcode;

import java.util.Arrays;

/*
 * @breif:https://leetcode-cn.com/problems/house-robber/
 * @Author: lyq
 * @Date: 2020/6/6 12:47
 * @Month:06
 */
public class 打家劫舍 {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,1,1,2}));
    }

    public static int rob(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        int max=Math.max(dp[0],dp[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            max=Math.max(max,dp[i]);
        }
        Arrays.stream(dp).forEach(System.out::println);
        return max;
    }
}
