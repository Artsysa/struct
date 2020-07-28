package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/jump-game/
 * @Author: lyq
 * @Date: 2020/6/4 23:37
 * @Month:06
 */
public class 跳跃游戏 {

    public static void main(String[] args) {
        System.out.println(canJump1(new int[]{2,0,0}));
    }

    public static boolean canJump1(int[] nums) {
        if(nums.length==1)return true;
        int len=nums.length;
        int count=0;
        for(int i=0;i<len-1;i++){
            count--;
            if(count<=0&&nums[i]<=0)
                return false;
            count=Math.max(nums[i],count);
        }
        return true;
    }

    public static boolean canJump(int[] nums) {
        if(nums.length==1)return true;
        int max=0;
        int len=nums.length;
        for(int i=0;i<len;i++){
            max--;
            if(nums[i]==0&&max<=0)
                return false;

            if(max<=nums[i]){
                max=nums[i];
            }
            if((max+i+1)>=len)
                return true;
        }
        return false;
    }
}
