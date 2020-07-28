package leetcode;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/5/25 16:35
 * @Month:05
 */
public class 礼物的最大价值 {
    public static void main(String[] args) {
        System.out.println(maxValue1(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }

    public static int maxValue1(int[][] grid) {
        if(grid.length==0||grid[0].length==0)return 0;
        int[] dp=new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            dp[0]=dp[0]+grid[i][0];
            for(int j=1;j<grid[0].length;j++){
                dp[j]=Math.max(dp[j],dp[j-1])+grid[i][j];
            }
        }
        return dp[grid[0].length-1];
    }

    public static int maxValue(int[][] grid) {
        if(grid.length==0||grid[0].length==0)return 0;
        int[][] dp=new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for(int i=1;i<grid.length;i++)
            dp[i][0]=grid[i][0]+dp[i-1][0];
        for(int i=1;i<grid[0].length;i++)
            dp[0][i]=grid[0][i]+dp[0][i-1];
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
