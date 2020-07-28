package leetcode;

import java.util.*;

/*
 * @breif:https://leetcode-cn.com/problems/subsets/
 * @Author: lyq
 * @Date: 2020/6/6 22:55
 * @Month:06
 */
public class 子集 {


    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
        Map<String,Integer> map=new HashMap<>();
        map.put("22",3);
        Integer integer = map.get("2");
        System.out.println(Objects.isNull(integer));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private static void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
