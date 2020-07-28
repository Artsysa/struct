package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * @breif:https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @Author: lyq
 * @Date: 2020/6/9 21:18
 * @Month:06
 */
public class 寻找重复数 {
    public int findDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            if(!set.add(i))
                return i;
        }
        return -1;
    }

}
