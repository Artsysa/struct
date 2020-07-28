package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @Author: lyq
 * @Date: 2020/6/9 21:48
 * @Month:06
 */
public class 买卖股票的最佳时机II {

    public static void main(String[] args) {
        买卖股票的最佳时机II s = new 买卖股票的最佳时机II();
        System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int res=0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1])
                res+=prices[i]-prices[i-1];
        }
        return res;
    }
}
