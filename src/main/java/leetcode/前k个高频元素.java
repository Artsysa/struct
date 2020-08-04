package leetcode;

import java.util.*;

/*
 * @describe:https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @author: lyq
 * @date: 2020/7/29 17:07
 */
public class 前k个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:nums){
            Integer num = map.get(i);
            if(Objects.isNull(num)){
                map.put(i,1);
            }else{
                map.put(i,num+1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
        int[] returnValue = new int[k];
        List<Integer> list = new ArrayList<>();
        while(iter.hasNext()){
            Map.Entry<Integer, Integer> next = iter.next();
            list.add(next.getValue());
        }
      return null;
    }
}
