package leetcode;


/*
 * @breif:https://leetcode-cn.com/problems/palindrome-linked-list/
 * @Author: lyq
 * @Date: 2020/6/3 16:55
 * @Month:06
 */
public class 回文链表 {
    boolean flage=true;
    ListNode temp;
    public boolean isPalindrome(ListNode head) {
        if(head==null)return true;
        temp=head;
        reservation(head);
        return flage;

    }
    public void reservation(ListNode node){
        if(node==null)return ;
        reservation(node.next);
        if(!flage)return;
        flage= temp.val==node.val;
        temp=temp.next;
    }


}
