package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * @Author: lyq
 * @Date: 2020/5/22 22:00
 * @Month:05
 */
public class 最长重复子数组 {
//
    public static void main(String[] args) {
        //
        System.out.println(findLength3(new int[]{1,0,1,0,1},new int[]{0,1,1,1,1}));
    }

    public static int findLength3(int[] A, int[] B) {
        int[][] dp=new int[A.length+1][B.length+1];
        int max=Integer.MIN_VALUE;
        for (int i = 1; i <=A.length ; i++) {
            for (int j=1;j<=B.length;j++){
                if(A[i-1]==B[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=0;
                max=Math.max(max,dp[i][j]);

            }
        }
        for (int i = 0; i <dp.length ; i++) {
            for (int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        return max;
    }




    public static int findLength(int[] A, int[] B) {
        int[][] dp=new int[A.length][B.length];
        int max=-999;
        dp[0][0]=A[0]==B[0]?1:0;
        for(int i=1;i<B.length;i++){
            if(A[0]==B[i])
                dp[0][i]=1;
            else
                dp[0][i]=dp[0][i-1];
        }
        for(int i=1;i<A.length;i++){
            if(A[i]==B[0])
                dp[i][0]=1;
            else
                dp[i][0]=dp[i-1][0];
        }
        for(int i=1;i<A.length;i++){
            for(int j=1;j<B.length;j++){
                if(A[i]==B[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                max=Math.max(max,dp[i][j]);
            }

        }
        for (int i = 0; i <A.length; i++) {
            for (int j=0;j<B.length;j++){
                System.out.print(dp[i][j]+"\t");

            }
            System.out.println();
        }
        return max;
    }


    public static int findLength1(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                }
                for (int k = 0; k<A.length; k++) {
                    for (int x=0;x<B.length;x++){
                        System.out.print(memo[k][x]+"\t");

                    }
                    System.out.println();
                }
                System.out.println("---------------------");
            }

        }

        return ans;
    }


}
