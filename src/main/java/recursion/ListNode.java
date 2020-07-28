package recursion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/3/18 12:11
 * @Month:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {
      int id;
      ListNode next;
      ListNode(int x) { id = x; }
  }

  class test{
     static ListNode l=null;
     static int  current=0,goal=0;
      public static void main(String[] args) {
          ListNode head = new ListNode();
          head.id=1;
          ListNode body=null,temp=head;
          for (int i = 2; i <= 5; i++) {
              body= new ListNode();
              body.id=i;
              temp.next=body;
              temp=body;
          }

          print(head);
          System.out.println(kthToLast(head, 4));
          ArrayList<Object> lis = new ArrayList<>();

      }
//public static void main(String[] args) {
//    int[] start=new int[]{4,2,4,8,2};
//    int[] end=new int[]{5,5,5,10,8};
//    int[] profit=new int[]{1,2,8,10,4};
//    System.out.println(jobScheduling(start, end, profit));
//}

      public  static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
          int[] pro=new int[startTime.length];
          pro[0]=profit[0];
          for(int i=1;i<profit.length;i++){
              int star=startTime[i],end=endTime[i],extren=0,pres=0;
              for(int j=0;j<i;j++){
                  if(startTime[i]>=endTime[j]){
                      if(startTime[j]>=pres){
                          extren+=profit[j];
                          pres=endTime[j];
                      }

                  }
              }
              pro[i]=profit[i]+extren;
          }
         return Arrays.stream(pro).sorted().toArray()[profit.length-1];

      }

      /*
      * @function：动态规划
      * @author lyq
      * @progress
      * @date 2020/3/19
      * @param
      * @return
      */
      public static int minimumTotal(List<List<Integer>> triangle) {
          int row=triangle.size(),column=triangle.get(triangle.size()-1).size();
          int[][] dp=new int[row][column];
          dp[0][0]=triangle.get(0).get(0);
          for(int i=1;i<row;i++){

              for(int p=0;p<triangle.get(i).size();p++){
                 if(p==0){
                     dp[i][p]=triangle.get(i).get(p)+dp[i-1][p];
                 }else  if(p==triangle.get(i).size()-1){
                     dp[i][p]=triangle.get(i).get(p)+dp[i-1][p-1];
                 }else{
                     dp[i][p]=triangle.get(i).get(p)+Math.min(dp[i-1][p-1],dp[i-1][p]);
                 }
              }
          }

          int[] ints = Arrays.stream(dp[row - 1]).sorted().toArray();
          return ints[0];
      }

      public static int minimumTotals(List<List<Integer>> triangle) {
          // 特判
          if (triangle == null || triangle.size() == 0) {
              return 0;
          }

          int row = triangle.size();
          int column = triangle.get(row - 1).size();

          int[][] dp = new int[row][column];
          dp[0][0] = triangle.get(0).get(0);
          int res = Integer.MAX_VALUE;

          for (int i = 1; i < row; i++) {
              //对每一行的元素进行推导
              for (int j = 0; j <= i; j++) {
                  if (j == 0) {
                      // 最左端特殊处理
                      dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                  } else if (j == i) {
                      // 最右端特殊处理
                      dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                  } else {
                      dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                  }
              }
          }

          // dp最后一行记录了最小路径
          for (int i = 0; i < column; i++) {
              res = Math.min(res, dp[row - 1][i]);
          }
          return res;
      }


      public static int kthToLast(ListNode head, int k) {
          if(head==null){
              return 0;
          }
          int i=kthToLast(head.next,k);
          current++;
          if(current==k){
              goal=head.id;
              return goal;
          }else{
              return goal;
          }
      }//1235

      public static  ListNode reverseList(ListNode head) {

          if(head.next==null){
              l=head;
              return head;
          }
          ListNode node=reverseList(head.next);
          node.next=head;
          head.next=null;
          return head;
      }


      public static void print(ListNode node){
          if(node==null){
              return;
          }
          System.out.println(node);
          print(node.next);
      }
      public static ListNode removeElements(ListNode head, int val) {
          ListNode temp=head,pre=null;

          while(temp.next!=null){
              if(temp.id==val){
                  pre.next=temp.next;
              }
              pre=temp;
              temp=temp.next;
          }
          return head;

      }
  }