package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/edit-distance/
 * @Author: lyq
 * @Date: 2020/5/25 15:22
 * @Month:05
 */
public class 编辑距离 {

    public static void main(String[] args) {
        System.out.println(minDistance1("horse","ros"));
    }

    public static int minDistance1(String word1, String word2) {
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        int[][] dp=new int[2][ch2.length+1];
        for(int i=0;i<ch2.length+1;i++){
            dp[0][i]=i;
        }
        for(int i=0;i<=ch1.length;i++){
            for(int j=0;j<=ch2.length;j++){
                if(j==0){
                    dp[i&1][0]=i;
                }
                int top=dp[(i-1)&1][j]+1;
                int left=dp[i&1][(j-1)]+1;
                int dm=dp[(i-1)&1][(j-1)];
                if(ch1[i-1]!=ch2[j-1]){
                    dm++;
                }
                dp[i&1][j&1]=Math.min(Math.min(top,left),dm);
            }
        }

        return dp[ch1.length&1][ch2.length];
    }


    public static int minDistance(String word1, String word2) {
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
        for (int i = 0; i <ch1.length+1 ; i++) {
            for (int j=0;j<ch2.length+1;j++){
                System.out.print(dp[i][j]+"\t");

            }
            System.out.println();
        }
        return dp[ch1.length][ch2.length];
    }
}
