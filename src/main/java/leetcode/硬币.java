package leetcode;

import java.util.Arrays;

/*
 * @breif:https://leetcode-cn.com/problems/coin-lcci/
 * @Author: lyq
 * @Date: 2020/6/9 16:23
 * @Month:06
 */
public class 硬币 {

    public static void main(String[] args) {
        硬币 s = new 硬币();
        System.out.println(s.waysToChange(5));
    }

    public int waysToChange(int n) {
        int[] coins={1,5,10,25};
        //dp[1][2]表示只有前1个硬币可以选凑够2块的方法
      int[][] dp=new int[coins.length+1][n+1];
        for (int i = 0; i < n+1; i++) {
            dp[0][i]=1;
        }
        for (int i = 0; i < coins.length+1; i++) {
            dp[i][0]=1;
        }
      for (int i = 1; i <coins.length +1; i++) {
          for (int j=1;j< n+1;j++){
              if(coins[i-1]>j){
                  dp[i][j]=dp[i-1][j];
              }else{
                  dp[i][j]=dp[i-1][j]+dp[i-1][j-coins[i-1]];
              }
          }
      }
        for (int i = 0; i < coins.length+1; i++) {
            for (int j=0;j<n+1;j++){
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
      return dp[coins.length][n];
    }


    public int waysToChanges(int n) {
        int[][] dp=new int[4][n+1];
        int[] coins={1,5,10,25};

        for(int i=0;i<=n;i++)
            dp[0][i]=1;
        for(int i=0;i<4;i++)
            dp[i][0]=1;

        for(int i=1;i<4;i++){
            for(int j=1;j<=n;j++){
                if(j>=coins[i])
                    dp[i][j]=(dp[i-1][j]+dp[i][j-coins[i]])%1000000007;
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        for (int i = 0; i <4 ; i++) {
            for (int j=0;j<n+1;j++){
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        return dp[3][n];
    }

}
