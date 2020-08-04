package leetcode;

/*
 * @describe:https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @author: lyq
 * @date: 2020/7/28 21:38
 */
public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
      int count=0;
      int max=0;
      for(int i=0;i<nums.length;i++){
          count=Math.max(count+nums[i],count);
          max=Math.max(count,max);
      }

      return max;
    }
}
