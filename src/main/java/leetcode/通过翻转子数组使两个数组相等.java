package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @breif:https://leetcode-cn.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 * @Author: lyq
 * @Date: 2020/6/7 22:55
 * @Month:06
 */
public class 通过翻转子数组使两个数组相等 {

    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:target){
            Integer count = map.get(i);
            if(count!=null)
                map.put(i,count+1);
            else
                map.put(i,1);
        }
        for(int i:arr){
            Integer count = map.get(i);
            if(count==null||count<=0)
                return false;
            else{
                map.put(i,count-1);
            }
        }
        return true;
    }
}
