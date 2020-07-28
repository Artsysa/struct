package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @breif:https://leetcode-cn.com/problems/the-masseuse-lcci/
 * @Author: lyq
 * @Date: 2020/5/22 19:40
 * @Month:05
 */
public class 理发师 {

    public static void main(String[] args) {
     //   System.out.println(massage1(new int[]{1,2}));
        System.out.println(missingNumber(new int[]{1, 2}));
        List<Integer> list= new ArrayList<>();

    }


    public static int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;

        return res;
    }


    public static int massage1(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int[] dp=new int[2];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        int max=dp[1];
        for(int i=2;i<nums.length;i++){
            dp[i&1]=Math.max(nums[i]+dp[(i-2)&1],dp[(i-1)&1]);
            max=Math.max(max,dp[i&1]);
        }
        return max;
    }

    public static int massage(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int[] dp=new int[nums.length+1];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        int max=dp[1];
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
