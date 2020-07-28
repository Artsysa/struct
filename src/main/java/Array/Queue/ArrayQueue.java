package Array.Queue;

import java.lang.reflect.Method;
import java.util.Scanner;

public class ArrayQueue {

    int MaxCapacity;
    int queue[];
    int head,tail;

    public ArrayQueue(int maxCapacity) {
        MaxCapacity = maxCapacity;
        queue =new int[maxCapacity];
        head=0;
        tail=0;
    }

    public void print(){
        for (int number:queue
             ) {
            System.out.print(number+"\t");
        }
        System.out.println();
    }

    public boolean enter(int data){
        if(!iffull()){
            queue[tail++]=data;
            return true;
        }
        return false;
    }

    public boolean out(){
        if(!ifnull()){
           for(int i=0;i<MaxCapacity-1;i++){
               queue[i]=queue[i+1];
           }
           queue[MaxCapacity-1]=0;
           tail--;
            return true;
        }
        return false;
    }

    public boolean ifnull(){
        if(head==tail){
            return true;
        }
        return false;
    }

    public boolean iffull(){
        if(tail==MaxCapacity){
            return true;
        }
        return false;
    }
}

class Queue{
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        while (true){
           if(queue.enter(Integer.parseInt(new Scanner(System.in).nextLine()))){
               queue.print();
           }else{
               break;
           }

             }
       while (true){
           if(queue.out()){
               queue.print();
           }else{
               System.out.println("faile");
               break;
           }
       }


    }
}