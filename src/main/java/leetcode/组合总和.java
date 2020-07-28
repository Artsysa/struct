package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @breif:https://leetcode-cn.com/problems/combination-sum/
 * @Author: lyq
 * @Date: 2020/6/12 10:25
 * @Month:06
 */
public class 组合总和 {

    public static void main(String[] args) {
        组合总和 a = new 组合总和();
        System.out.println(a.combinationSum(new int[]{2,3,6,7},7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,list,new ArrayList<>(),0);
        return list;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> list,List<Integer> tmp,int start) {
        if(target<0)return;
        if(target==0){
            list.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            tmp.add(candidates[i]);
            dfs(candidates,target-candidates[i],list,tmp,i);
            tmp.remove(tmp.size()-1);

        }
    }
}
