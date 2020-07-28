package leetcode;

import java.util.*;

/*
 * @breif:https://leetcode-cn.com/problems/set-matrix-zeroes/
 * @Author: lyq
 * @Date: 2020/6/7 13:54
 * @Month:06
 */
public class 矩阵置零 {

    public static void main(String[] args) {
        矩阵置零 矩阵置零 = new 矩阵置零();
        矩阵置零.setZeroes(new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        });
    }
    public  void setZeroes(int[][] matrix) {
        List<Local> list=new ArrayList<>();
        for (int i = 0; i <matrix.length ; i++) {
            for (int j=0;j<matrix[0].length;j++){
              if(matrix[i][j]==0)
                  list.add(new Local(i,j));
            }
        }
        for(Local local:list){
            Integer y = local.y;
            Integer x = local.x;
            for(int i=0;i<matrix[0].length;i++)
                matrix[x][i]=0;
            for (int i = 0; i < matrix.length; i++)
                matrix[i][y]=0;
        }
    }

    class Local{
        public int x;
        public int y;
        public Local(int x,int y){
            this.x=x;
            this.y=y;
        }

    }
}
