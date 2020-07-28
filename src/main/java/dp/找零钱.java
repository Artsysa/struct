package dp;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @breif:
 * @Author: lyq
 */
public class 找零钱 {
    public static void main(String[] args) {
        找零钱 零钱 = new 找零钱();
        //int[] type=new int[]{5,1,20,25};
        //Arrays.sort(type,(e1,e2)->{return e2-e1;});
       // System.out.println(零钱.需要最少的硬币数量(41));
        int[] dp=new int[42];
       // dp[1]=dp[5]=dp[20]=dp[25]=1;
        System.out.println(零钱.coin1(40, dp));
//        for (int i:dp){
//            System.out.print(i+"\t");
//        }
     
    }

    
    public int coin1(int n,int[] dp){

        for (int i = 1; i <= n; i++) {
            int min=Integer.MAX_VALUE;
          if(i>=1)min=Math.min(min,dp[i-1]);
          if(i>=5)min=Math.min(min,dp[i-5]);
          if(i>=20)min=Math.min(min,dp[i-20]);
          if(i>=25)min=Math.min(min,dp[i-25]);
          dp[i]=min+1;
        }
        return dp[n];
    }
    
    /**
     * 递归+记忆搜索，类似于斐波那契
     * @param n
     * @param dp
     * @return
     */

    public int coin(int n,int[] dp){
        if(n<1) return Integer.MAX_VALUE;
        if(dp[n]==0){
            int min1=Math.min(coin(n-25,dp),coin(n-20,dp));
            int min2=Math.min(coin(n-5,dp),coin(n-1,dp));
            dp[n]=Math.min(min1,min2)+1;
        }
        return dp[n];
    }

    /**
     * 递归
     * @param 数量
     * @return
     */
    public int 需要最少的硬币数量(int 数量){
        if(数量<1) return Integer.MAX_VALUE;
        if(数量==25||数量==20||数量==5||数量==1)return 1;
        int 最小的1=Math.min(需要最少的硬币数量(数量-25),需要最少的硬币数量(数量-20));
        int 最小的2=Math.min(需要最少的硬币数量(数量-5),需要最少的硬币数量(数量-1));
        return Math.min(最小的1,最小的2)+1;
    }
}
