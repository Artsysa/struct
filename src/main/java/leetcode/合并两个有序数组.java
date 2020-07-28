package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @breif:https://leetcode-cn.com/problems/merge-sorted-array/
 * @Author: lyq
 * @Date: 2020/6/5 22:23
 * @Month:06
 */
public class 合并两个有序数组 {

    public static void main(String[] args) {
        int[] num1=new int[]{2,0};
        int[] num2=new int[]{1};
        merge(num1,1,num2,1);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length==1&&m==0){nums1[0]=nums2[0]; return;}
        int p1=m-1,p2=n-1,cur=nums1.length-1;
        while(p2>=0){
            if(p1>=0&&nums1[p1]>nums2[p2]){
                nums1[cur]=nums1[p1];
                p1--;
            }else{
                nums1[cur]=nums2[p2];
                p2--;
            }
            cur--;
        }
    }
}
