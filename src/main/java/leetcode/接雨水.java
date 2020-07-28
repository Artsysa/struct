package leetcode;

import java.util.HashMap;
import java.util.Objects;

/*
 * @breif:https://leetcode-cn.com/problems/trapping-rain-water/
 * @Author: lyq
 * @Date: 2020/6/8 20:40
 * @Month:06
 */
public class 接雨水 {

    public static void main(String[] args) {
        接雨水 a = new 接雨水();
        HashMap<Integer,Integer> map =new HashMap<>();

        System.out.println(a.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public int trap1(int[] height) {
        int[] leftmax=new int[height.length];
        int[] rightmax=new int[height.length];
        for(int i=1;i<leftmax.length-1;i++)
            leftmax[i]=Math.max(leftmax[i-1],height[i-1]);
        for(int i=leftmax.length-2;i>0;i--)
            rightmax[i]=Math.max(rightmax[i+1],height[i+1]);
        int count=0;
        for(int i=1;i<height.length-1;i++){
            int dir=Math.max(leftmax[i],rightmax[i])-height[i];
            if(dir>=0)
                count+=dir;
        }
        for (int i = 0; i < leftmax.length; i++) {
            System.out.print(leftmax[i]+"\t");
        }
        System.out.println();
        for (int i = 0; i < rightmax.length; i++) {
            System.out.print(rightmax[i]+"\t");
        }
        System.out.println();
        return count;
    }


    public int trap(int[] height) {
        int[] leftmax=new int[height.length];
        int[] rightmax=new int[height.length];
        for(int i=1;i<leftmax.length-1;i++)
            leftmax[i]=Math.max(leftmax[i-1],height[i-1]);
        for(int i=rightmax.length-2;i>0;i--)
            rightmax[i]=Math.max(rightmax[i+1],height[i+1]);
        int count=0;
        for(int i=1;i<height.length-1;i++){
            int var=Math.min(leftmax[i],rightmax[i]);
            int water=var-height[i]<0?0:var-height[i];
            count=count+water;
        }
        for (int i = 0; i < leftmax.length; i++) {
            System.out.print(leftmax[i]+"\t");
        }
        System.out.println();
        for (int i = 0; i < rightmax.length; i++) {
            System.out.print(rightmax[i]+"\t");
        }
        System.out.println();
        return count;
    }
}
