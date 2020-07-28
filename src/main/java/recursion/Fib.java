package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/*
 * @breif:斐波那契及其优化
 * @Author: lyq
 * @Date: 2020/5/6 10:48
 * @Month:05
 */
public class Fib {


    public int fib(int n){
        if(n==1||n==2)return 1;
        try {
            TimeUnit.MICROSECONDS.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fib(n-1)+fib(n-2);
    }
    public int fib1(int n){
      int[] array =new int[n+1];
      array[1]=array[2]=1;
      return fib1(n,array);
    }
    public int fib1(int n,int[] array){
        if(array[n]==0){
            array[n]=fib1(n-1,array)+fib1(n-2,array);
        }
        return array[n];
    }
    public int fib2(int n){
        int[] array =new int[2];
        array[0]=array[1]=1;
        for (int i = 1; i <n ; i++) {
            array[i&1]=array[0]+array[1];
        }
        return array[n&1];
    }

    public static void main(String[] args) {
            Fib fib = new Fib();
            int aim=45;
        long current = System.currentTimeMillis();
        System.out.println(fib.fib1(aim));
        long end = System.currentTimeMillis();
        //mergeSort.print();
        System.out.println("("+((end-current))/1000f+"s)"+(end-current)+"ms");
         current = System.currentTimeMillis();
        System.out.println(fib.fib(aim));
         end = System.currentTimeMillis();
        //mergeSort.print();
        System.out.println("("+((end-current))/1000f+"s)"+(end-current)+"ms");

        current = System.currentTimeMillis();
        System.out.println(fib.fib(aim));
        end = System.currentTimeMillis();
        //mergeSort.print();
        System.out.println("("+((end-current))/1000f+"s)"+(end-current)+"ms");


        List<Integer> list=new ArrayList<>();
        list.stream().mapToInt(e->{return e;}).toArray();
    }
}
