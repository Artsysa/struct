package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @Author: lyq
 * @Date: 2020/6/7 19:07
 * @Month:06
 */
public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
    public static int removeDuplicates(int[] nums) {
        int slow=0,count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[slow]){
                count++;
                for(int j=i;j<nums.length-1;j++)
                    nums[j]=nums[j+1];
                slow++;
            }
        }
        return count;
    }
}



