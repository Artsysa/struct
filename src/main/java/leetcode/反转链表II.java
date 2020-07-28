package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @breif:https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @Author: lyq
 * @Date: 2020/6/11 13:21
 * @Month:06
 */
public class 反转链表II {

    public static void main(String[] args) {
        反转链表II a = new 反转链表II();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        a.reverseBetween(head,2,4);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode nhead=new ListNode(0);
        ListNode ntail=nhead;
        List<Integer> list=new ArrayList<>();
        int count=0;
        while(head!=null){
            ListNode node=new ListNode(head.val);
            if(count<m-1){
                ntail.next=node;
                ntail=node;
            }else if(count<=n-1){
                list.add(head.val);
            }else if(count>n-1){
                break;
            }
            count++;
            head=head.next;
        }
        int[] element=list.stream().mapToInt(e->e).toArray();
        ListNode reserv=new ListNode(0);
        ListNode ta=reserv;
        for(int i=element.length-1;i>=0;i--){
            ListNode node=new ListNode(element[i]);
            ta.next=node;
            ta=node;
        }
        ntail.next=reserv.next;
        ta.next=head;
        return nhead.next;
    }
}
