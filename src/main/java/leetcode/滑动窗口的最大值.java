package leetcode;

import Array.Queue.ArrayQueue;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

/*
 * @describe:https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * @author: lyq
 * @date: 2020/8/4 17:17
 */
public class 滑动窗口的最大值 {

    public static void main(String[] args) {
      //  System.out.println(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        System.out.println(Arrays.asList(maxSlidingWindow(new int[]{7,2,4}, 2)));
    }

    //TODO queue中应该存放索引，用来判断当前队头是否在滑动窗口范围内
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0)return new int[0];
        if(k == 1) return nums;
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(k);
        int length = nums.length - k + 1;
        int[] returnVal = new int[length];
        int j=0;
        for(int i = 0; i < nums.length; i++){
            while(!Objects.isNull(queue.peek())&&(((nums[queue.peek()] <= nums[i]))||
                    ((i-k+1)>queue.peek()))){
                queue.poll();
            }
            queue.offer(i);
            if(i >= k-1){
                returnVal[j++] = nums[queue.peek()];
            }
        }
        return returnVal;
    }
}
