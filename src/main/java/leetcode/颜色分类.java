package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/sort-colors/
 * @Author: lyq
 * @Date: 2020/6/6 23:41
 * @Month:06
 */
public class 颜色分类 {

    public static void main(String[] args) {
        sortColors(new int[]{2,2});
    }

    public static void sortColors(int[] nums) {
        if(nums.length==1)return;
        int two=nums.length-1,zero=0;
        int cur=0;
        while(two>=cur){

            if(nums[cur]==0){
                nums[cur]=nums[cur]+nums[zero];
                nums[zero]=nums[cur]-nums[zero];
                nums[cur]=nums[cur]-nums[zero];
                zero++;
                cur++;
            }

            else if(nums[cur]==2&&cur!=two){
                nums[cur]=nums[cur]+nums[two];
                nums[two]=nums[cur]-nums[two];
                nums[cur]=nums[cur]-nums[two];
                two--;
            }else{
                cur++;
            }
        }
    }
}
