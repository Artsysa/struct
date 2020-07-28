package LinkList.SingLink;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class RingLink {

    public int createRingLink(CopyOnWriteArrayList<Node> node,Node head){
        Node temp=head;
        for (Node n:node
             ) {
            temp.next=n;
            temp=temp.next;
        }
        temp.next=head;
        return node.size()+1;
    }

    public void print(Node head,int length){
        Node temp=head;
        int i=0;
        while(i++<length){
            System.out.print(temp.id+"-->");
            temp=temp.next;
        }
        System.out.println();
    }

    public void deteleNode(Node head,int length,int interval){
        int gap=interval;
        Node temp=head;
        while(head.next!=head){
            Node pro=null;
            for(int i=0;i<interval;i++){
                pro=temp;
                temp=temp.next;
            }
            pro.next=temp.next;
            print(head,length);
        }
    }


    public static void main(String[] args) {
        RingLink ringLink = new RingLink();
        int length=0;
        CopyOnWriteArrayList<Node> data=new CopyOnWriteArrayList<>();
        Node head=new Node(1);
        for (int i = 2; i <=6 ; i++) {
            data.add(new Node(i));
        }
        length = ringLink.createRingLink(data, head);
        ringLink.print(head,length);
        ringLink.deteleNode(head,length,2);
    }
}


@Data
@NoArgsConstructor
@AllArgsConstructor
class Node{
    int id;
    Node next;

    Node(Integer id){
        this.id=id;
        this.next=null;
    }
}