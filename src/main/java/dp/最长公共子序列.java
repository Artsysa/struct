package dp;

/*
 * @breif:https://leetcode-cn.com/problems/longest-common-subsequence/
 * @Author: lyq
 * @Date: 2020/5/13 8:45
 * @Month:05
 */
public class 最长公共子序列 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence1("bl", "yby"));
    }


    /**
     * 优化空间复杂度
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence1(String text1, String text2) {
        if(text1.length()==0||text2.length()==0){
            return 0;
        }

        char[] num1= text1.toCharArray();
        char[] num2= text2.toCharArray();
        if(num1.length<num2.length){
          char[] temp=num1;
          num1=num2;
          num2=temp;
        }
        int cells=num1.length;
        int row=num2.length;
        if(cells<row){
            row=num1.length;
            cells=num2.length;
        }
        int[] dp=new int[row+1];
        int max=0;
        for(int i=1;i<=cells;i++){
            int cur=0;
            for(int j=1;j<=row;j++){
                int lefttop=cur;
                cur=dp[j];
                if(num1[i-1]==num2[j-1]){
                    dp[j]=lefttop+1;
                }
                else{
                    dp[j]=Math.max(dp[j],dp[j-1]);
                }
                max=Math.max(dp[j],max);
            }

        }
        for (int j = 0; j <dp.length ; j++) {

            System.out.print(dp[j]+"\t");
        }
        return max;
    }

    /**
     * dp
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0||text2.length()==0){
            return 0;
        }
        char[] num1= text1.toCharArray();
        char[] num2= text2.toCharArray();
        int[][] dp=new int[num1.length+1][num2.length+1];
        int max=0;
        for(int i=1;i<=num1.length;i++){
            int cur=0;
            for(int j=1;j<=num2.length;j++){

                if(num1[i-1]==num2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                max=Math.max(dp[i][j],max);
            }
        }
        for (int i = 0; i <num1.length+1 ; i++) {
            for (int j=0;j<num2.length+1;j++){
                System.out.print(dp[i][j]+"\t");

            }
            System.out.println();
        }
        return max;
    }
}
