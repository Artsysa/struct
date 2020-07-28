package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @Author: lyq
 * @Date: 2020/6/8 18:15
 * @Month:06
 */
public class 合并K个排序链表 {

    public static void main(String[] args) {
        合并K个排序链表 合并K个排序链表 = new 合并K个排序链表();
        ListNode h1=new ListNode(1);
        h1.next=new ListNode(4);
        h1.next.next=new ListNode(5);
        ListNode h2=new ListNode(1);
        h2.next=new ListNode(3);
        h2.next.next=new ListNode(4);
        ListNode h3=new ListNode(2);
        h3.next=new ListNode(6);
        ListNode[] list=new ListNode[]{h1,h2,h3};
        合并K个排序链表.mergeKLists(list);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode nhead=new ListNode(0);
        ListNode[] ohead=new ListNode[lists.length];
        ListNode headcur=nhead;
        boolean isexit=true;
        for(int i=0;i<ohead.length;i++)
            ohead[i]=lists[i];
        while(isexit){
            int min=9999,cur=0,count=0;
            ListNode temp,node;
            for(int i=0;i<ohead.length;i++){
                if(ohead[i]==null){
                    count++;
                    if(count==ohead.length)
                        return nhead.next;
                    continue;
                }
                if(ohead[i].val<min)
                {
                    min=ohead[i].val;
                    temp=ohead[i];
                    cur=i;
                    isexit=true;
                }
            }
            node=new ListNode(min);
            headcur.next=node;
            headcur=node;
            ohead[cur]=ohead[cur]==null?null:ohead[cur].next;
        }
        return nhead.next;


    }
}

