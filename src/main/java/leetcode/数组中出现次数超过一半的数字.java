package leetcode;

/*
 * @describe:https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 摩尔投票
 * @author: lyq
 * @date: 2020/7/28 17:07
 */
public class 数组中出现次数超过一半的数字 {











    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
    public static int majorityElement(int[] nums) {
      int count=0;
      int cur=0;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0)
                cur = nums[i];
            if(nums[i] != cur){
                count-=1;
            }else{
                count+=1;
            }
        }
        return cur;
    }
}
