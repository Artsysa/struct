package leetcode;

/*
 * @describe:里用异或的性质，如果有偶数个相同的元素，则异或后对应的二进制位为0，
 * 剩下的二进制位为1的即为最终结果
 * @author: lyq
 * @date: 2020/8/13 11:54
 */
public class 找出数组中唯一不重复的元素 {
    public static void main(String[] args) {
        System.out.println(getSignal(new int[]{1,3,1,4,4,3,10,2,10}));
    }
    public static int  getSignal(int[] nums){
        int signal = 0;
        for (int i = 0 ;i < nums.length ; i++) {
            signal ^= nums[i];
        }
        return signal;
    }
}
