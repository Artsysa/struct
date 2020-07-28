package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @breif:https://leetcode-cn.com/problems/3sum/
 * @Author: lyq
 * @Date: 2020/6/9 18:59
 * @Month:06
 */
public class 三数之和 {

    public static void main(String[] args) {

        三数之和 s = new 三数之和();
        System.out.println(s.threeSum(new int[]{0,0,0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        int end=nums.length-1;
        for (int i = 0; i <= nums.length-3; i++) {
           int cur=i+1;
            end=nums.length-1;
            while(cur<end){
                if((nums[i]+nums[cur]+nums[end])==0){
                    list.add(Arrays.asList(nums[i],nums[cur],nums[end]));
                  while(nums[cur]==nums[cur+1]){
                      if((cur+2)==nums.length)break;
                      cur++;}
                  cur++;
                    end--;
                    continue;
                }
                if((nums[i]+nums[cur]+nums[end])<0){
                    cur++;
                }else{
                    end--;
                }
            }
            while(nums[i]==nums[i+1]){
                if((i+1)>nums.length-3)break;
                i++;}
        }
        return list;
    }
}
