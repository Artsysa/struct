package leetcode;

import map.Ar;

import java.util.Arrays;

/*
 * @describe:https://leetcode-cn.com/problems/reducing-dishes/
 * @author: lyq
 * @date: 2020/8/14 14:13
 */
public class 做菜顺序 {
    public static void main(String[] args) {
        maxSatisfaction(new int[]{-1,-8,0,5,-7});
    }
    public static int maxSatisfaction(int[] satisfact) {
        Arrays.sort(satisfact);
        int sum = 0;
        int cur = 1;
        for (int i = satisfact.length - 1; i >= 0 ; i--) {
            int temp = sum + satisfact[i] * cur;
            if (temp > sum) {
                sum = temp;
                cur++;
            }
        }
        return sum;
    }
}
