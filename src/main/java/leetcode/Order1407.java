package leetcode;

import recursion.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @breif:编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * @Author: lyq
 * @Date: 2020/3/25 9:48
 * @Month:03
 */
public class Order1407 {
   static HashSet<Integer> set=new HashSet<>();
    public static Node removeDuplicateNodes(Node head) {
        Node temp=head,pre=temp;
        while(temp!=null){
            if(!set.add(temp.val))
                pre.next=temp.next;

            else
            pre=temp;
            temp=temp.next;

        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node head1 = new Node(2);
        Node head2 = new Node(3);
        Node head3 = new Node(3);
        Node head4 = new Node(2);
        Node head5 = new Node(1);
        head.next=head1;
        head1.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=head5;
        removeDuplicateNodes(head);
    }


}
 class Node {
      int val;
      Node next;
      Node(int x) { val = x; }

     public Node() {
         
     }
 }


 class test{
     public static void main(String[] args) {
         System.out.println(isPerfectSquare(1234231421));
     }

     public static boolean isPerfectSquare(int num) {
         for(int i=1;i<=num/2;i++){
             double s=Math.pow(i,2);
             if(num==s){
                 return true;
             }
         }
         List<Integer> list=new ArrayList<>();

         return false;
     }
 }