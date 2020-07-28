package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/one-away-lcci/
 * @Author: lyq
 * @Date: 2020/6/11 17:48
 * @Month:06
 */
public class 一次编辑 {

    public static void main(String[] args) {
        一次编辑 s = new 一次编辑();
        System.out.println(s.minDistance("teacher","beacher"));
    }

    public int minDistance(String word1, String word2) {
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        int[][] dp=new int[ch1.length+1][ch2.length+1];
        for(int i=0;i<ch1.length+1;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<ch2.length+1;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<=ch1.length;i++){
            for(int j=1;j<=ch2.length;j++){
                int top=dp[i-1][j]+1;
                int left=dp[i][j-1]+1;
                int dm=dp[i-1][j-1];
                if(ch1[i-1]!=ch2[j-1]){
                    dm++;
                }
                dp[i][j]=Math.min(Math.min(top,left),dm);
            }
        }
        for (int i = 0; i <dp.length ; i++) {
            for (int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        return dp[ch1.length][ch2.length];
    }

    public boolean oneEditAway(String first, String second) {
        if(first.length()<2&&second.length()<2)return true;
        char[] ch1=  first.toCharArray();
        char[] ch2=  second.toCharArray();
        int[][] dp=new int[ch1.length+1][ch2.length+1];
        for(int i=1;i<ch2.length+1;i++)
            dp[0][i]=i;
        for(int i=1;i<ch1.length+1;i++)
            dp[i][0]=i;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(ch1[i-1]==ch2[j-1])
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]+1);
            }
        }
        for (int i = 0; i <dp.length ; i++) {
            for (int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        return dp[ch1.length][ch2.length]==1;
    }
}
