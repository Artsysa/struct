package leetcode;

/*
 * @author: lyq
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @date: 2020/7/22 17:38
 */
public class 旋转数组的最小数字 {

    public int minArray(int[] numbers) {
     int min=numbers[0];
        for (int i = 1; i < numbers.length; i++) {
           if(numbers[i]>min){
             return numbers[i];
           }else{
               min=numbers[i];
           }
        }
        return -1;
    }
}
