package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/*
 * @breif:一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，
 * 替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。

 * @Author: lyq
 * @Date: 2020/3/24 9:29
 * @Month:03
 */
public class Order1496 {
   static   int[] nums=new int[]{7,2,3,1,4,6,10};


    public static void main(String[] args) {
        System.out.println(recusion(nums, nums.length-1));
        System.out.println(dp(nums));
        HashMap<Integer,Integer> map=new HashMap<>();
        Integer integer = map.get(1);

    }

    
//    public static int recursion(int[] nums,int count){
//        int[] dp=new int[nums.length];
//        dp[0]=nums[0];
//        for (int i = 1; i < nums.length; i++) {
//          dp[i]=dp[i-1]
//
//        }
//    }


    public static int recusion(int[] nums,int n){
       if(n==0){
           return nums[0];
       }
       if(n==1){
           return Math.max(nums[0],nums[1]);
       }
         int a=Math.max(recusion(nums,n-1),recusion(nums,n-2)+nums[n]);
       return a;
    }

    public static int dp(int[] nums){
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }


}
