package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @breif:https://leetcode-cn.com/problems/permutations/
 * @Author: lyq
 * @Date: 2020/6/5 11:11
 * @Month:06
 */
public class 全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list =new ArrayList<>();
        boolean[] isuse=new boolean[nums.length];
        int[] temp=new int[nums.length];
        dfs(0,nums,temp,isuse,list);
        return list;
    }
    public void dfs(int index,int[] nums,int[] temp, boolean[] isuse,List<List<Integer>> list){
        if(index==nums.length){
            List<Integer> lists=new ArrayList<>();
            for(int nu:temp)
                lists.add(nu);
            list.add(lists);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(isuse[i])continue;
            temp[index]=nums[i];
            isuse[i]=true;
            dfs(index+1,nums,temp,isuse,list);
            isuse[i]=false;
        }

    }
}
