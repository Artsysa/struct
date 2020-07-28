package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @Author: lyq
 * @Date: 2020/5/17 16:25
 * @Month:05
 */
public class 买股票 {


    public static void main(String[] args) {
        int[] nums=new int[]{1,2};
        System.out.println(maxProfit1(nums));
    }


    public  static int maxProfit1(int[] prices) {
        int min=prices[0];
        int max=Integer.MIN_VALUE;
        for(int i=1;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            max=Math.max(prices[i]-min,max);
        }
        return max;
    }

    public  static int maxProfit(int[] prices) {
        int max=-9999;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                max=Math.max(prices[j]-prices[i],max);
            }
        }
        return max;
    }
}
