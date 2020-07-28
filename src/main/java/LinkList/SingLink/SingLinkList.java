package LinkList.SingLink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class SingLinkList {


    public Personal head=new Personal(1,"王kkk",20);

    public void addBySort(Personal personal){
    if(isExist(personal)!=null){
        System.out.println("用户已存在");
       return;
    }else {
        int id = personal.getId();
        Personal temp = head;
        while (true) {
            if (temp.next != null) {
                if (id >= temp.getId() && id <= temp.next.getId()) {
                    Personal t = temp.next;
                    temp.next = personal;
                    personal.next = t;
                    break;
                }
                temp = temp.next;
            } else {
                break;
            }
        }
    }
    }

    public int Length(){
        int i=0;
        Personal temp=head;
        while(temp.next!=null){
                   i++;
            temp=temp.next;

        }
        return i;
    }
    public static int  Length(Personal head){
        int i=0;
        Personal temp=head;
        while(temp.next!=null){
            i++;
            temp=temp.next;

        }
        return i;
    }

    public void delete(int id){
        Personal temp=head;
        Personal personal = isExist(id);
        if(personal!=null){
            while(temp.next!=null){
                if(temp.next==personal){
                    temp.next=personal.next;
                    break;
                }
                temp=temp.next;
            }
        }else{
            System.out.println("不存在此人");
        }
    }


    public void addNode(Personal personal){
        Personal temp =  GetPointNow(this.head);
        temp.next=personal;
    }
    public void addNode(List<Personal> personal){
        Personal temp =  GetPointNow(this.head);
        for (Personal per:personal
             ) {
             temp.next=per;
             temp=per;
        }

    }

    /*
    获取倒数第K个节点
     */
    public Personal getReverseIndex(int index){
        int length = Length();
        Personal temp=head;
        for(int i=0;i<length-index;i++){
            temp=temp.next;
        }
        return temp.next;
    }

    /*
    单链表逆序
     */
    /*
    *====================================================第一版=============================
     */
    public Personal ReverseLinkList(Personal reversehead){
        Personal original=this.head.next;
        reversehead.next=original;
        Personal temp=original.next;
        reversehead.next.next=null;
        Personal next=reversehead.next;
        while (temp.next!=null){
           next=reversehead.next;
            reversehead.next=temp;
            temp=temp.next;
            reversehead.next.next=next;

        }
       next=reversehead.next;
       reversehead.next=temp;
       reversehead.next.next=next;
        return reversehead;
    }
    /*
     *====================================================第二版=============================
     */
    public Personal ReverseLinkListUp(Personal reversehead){
        Personal text=this.head.next;


        return reversehead;
    }

    public Stack<Personal> ReverselStackplus(Personal head){
        Stack<Personal> stack=new Stack<Personal>();
        Personal personal=head.next;
        while(personal!=null){
            stack.push(personal);
            personal=personal.next;
        }
        return stack;
    }
    /*
    ===============================================链表逆序输出
     */
    public Personal[] ReverselStack(Personal head){
        Personal temp=head.next;
        Personal[] stack=new Personal[Length()];
        int i=Length();
        while(temp!=null){
            stack[--i]=temp;
            temp=temp.next;
        }
        return stack;
    }


    /*
    ================================两个链表合并并排序
     */
    public Personal CombineAndSort(Personal h1,Personal h2)throws  Exception{

        Personal t1=h1,t2=h2;

        new Thread(()->{
               sort(h1);
               },"A").start();
        new Thread(()->{
               sort(h2);
               },"A").start();

        Personal temp =t1;
        while(temp.next!=null){
            temp=temp.next;
        }
        System.out.println(temp);
        temp.next=t2.next.next;

      //  TimeUnit.SECONDS.sleep(4);
        sort(t1);
          return t1;

    }

    public void sort(Personal head) {
        Personal pre=null,temp1=head.next;
        for(int i=0;i<SingLinkList.Length(head);i++){
            Personal pointer=head.next;
            pre=head;
            System.out.println(SingLinkList.Length(head)+"------------------");
            while(pointer.next!=null){
                Personal next=pointer.next;
                if(pointer.getId()>next.getId()){
                    Personal ex;
                    ex=next.next;
                    pointer.next=ex;
                    next.next=pointer;
                    pre.next=next;
                    pointer=next;
                }
                pre=pointer;
                pointer=pointer.next;
            }
        }

    }
    public Personal getLast(Personal head){
        Personal temp=head;
        while(temp!=null){
            temp=temp.next;
        }
        return temp;
    }

    public void Print(){
        Personal temp=head;
        while(true){

            if(temp.next==null){
                System.out.println(temp.toString());
                break;
            }
            System.out.println(temp.toString());
            temp=temp.next;

        }
    }
    public void Print(Personal temps){
      Personal temp=temps;
        while(true){

            if(temp.next==null){
                System.out.println(temp.toString());
                break;
            }
            System.out.println(temp.toString());
            temp=temp.next;

        }
    }

    public void ReservePrint(Personal head){
        Personal temp=head;
        if (temp!=null){
            ReservePrint(temp.next);
            System.out.println(temp);
        }else{
            return;
        }
    }

    public Personal isExist(Personal personal){
        Personal temp=head;
        while(true) {
            if (temp.next != null) {
                if (personal.getId() == temp.getId()) {
                    return temp;
                }

            }else{
                return null;
            }
            temp = temp.next;
        }

    }
    public Personal isExist(int id){
        Personal temp=head;
        while(true) {
            if (temp.next != null) {
                if (id == temp.getId()) {
                    return temp;
                }

            }else{
                return null;
            }
            temp = temp.next;
        }

    }


    public Personal GetPointNow(Personal head){
        while(true){
            if(this.head.next==null){
                return this.head;
            }
            this.head = this.head.next;
        }
    }
}

class Link{
    public static void main(String[] args) {
        SingLinkList link = new SingLinkList();
        SingLinkList link1 = new SingLinkList();
      //  link.addNode(new Personal(2,"李四",20));
        List<Personal> list=new ArrayList<Personal>();
        list.add(new Personal(5,"李四",245450));
        list.add(new Personal(7,"1234",240));
        list.add(new Personal(3,"李2134四",230));
        list.add(new Personal(2,"证明",22130));
        list.add(new Personal(20,"李534534四",2021));
        link.addNode(list);
        //link.addBySort(new Personal(6,"qwersadf",2021));
        //link.delete(2);
        link.Print();

        System.out.println("===================================");
        link.ReservePrint(link.head);
//        List<Personal> listq=new ArrayList<Personal>();
//        listq.add(new Personal(16,"李123",245450));
//        listq.add(new Personal(4,"1234",240));
//        listq.add(new Personal(12,"李2134四",230));
//        listq.add(new Personal(13,"证明",22130));
//        listq.add(new Personal(7,"李534534四",2021));
//        link1.addNode(listq);
//         Personal temps=link.head;
//         while(temps.next!=null){
//             temps= temps.next;
//         }
//         temps.next=link1.head.next;
//         link.sort(link.head);
//         link.Print(link.head);
       try {
         //  Personal combine = link.CombineAndSort(link.head, link1.head);
          // link1.Print(combine);
       } catch (Exception e) {
           e.printStackTrace();
       }


        //System.out.println(link.getReverseIndex(5));
       // Personal reverse = link.ReverseLinkList(new Personal(1, "王kkkreverse", 20));
       // link.Print(reverse);
       // Personal[] reversel = link.ReverselStack(link.head);
        //System.out.println(Arrays.asList(reversel));
        //Stack<Personal> personalstack = link.ReverselStackplus(link.head);
        //System.out.println(Arrays.asList(personalstack.toArray()));

    }
}

class Personal{
    int id;
    String name;
    int age;
    Personal next;

    @Override
    public String toString() {
        return "Personal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", next="  +
                '}';
    }

    public Personal(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Personal getNext() {
        return next;
    }

    public void setNext(Personal next) {
        this.next = next;
    }
}