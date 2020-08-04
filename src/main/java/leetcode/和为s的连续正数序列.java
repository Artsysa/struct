package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @describe:https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * @author: lyq
 * @date: 2020/8/3 17:07
 */
public class 和为s的连续正数序列 {
    public static void main(String[] args) {
        findContinuousSequence(9);
    }
    public static int[][] findContinuousSequence(int target) {
        int start = 1;
        int end = 1;
        int sum = 0;
        List<List<Integer>> list = new ArrayList<>();
        while(start <= (target >> 1)){
            if(sum > target){
                sum -= start++;
            }else if(sum < target){
                sum += end++;
            }else{
                List<Integer> temp = new ArrayList<>();
                for(int i = start; i < end ; i++){
                    temp.add(i);
                }
                list.add(temp);
                sum -= start++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
