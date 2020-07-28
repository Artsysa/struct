package order;

import lombok.Data;
import lombok.experimental.Accessors;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/*
 * @breif:
 * @Author: ArDaBao
 * @Date: 2020/3/17 11:08
 * @Month:03
 */
public class Sort {
   public int[] num;
   int capacity=10;

    Sort(){
       num= new int[capacity];
        for(int i=0;i<capacity;i++){
       num[i]=(int)(Math.random()*10+1);
        }
    }

    public void print(){
        for (int i = 0; i < capacity; i++) {
            System.out.print(num[i]+"\t");
        }
        System.out.println();
    }

    /**
     * 冒泡
     */
    public void maopao(){
        for (int i = 0; i < capacity; i++) {
            for (int j=i;j<capacity;j++){
                if(num[i]<num[j]){
                    num[i]=num[i]+num[j];
                    num[j]=num[i]-num[j];
                    num[i]=num[i]-num[j];
                }
            }
        }
    }


    /*
    * @function：选择排序:先找出最大的，让后和当前索引交换，来来回回进行8轮
    * @author daobao
    * @date 2020/3/17
    * @param
    * @return
    */
    public void xuanze(){
             for (int i = 0; i <capacity-1 ; i++) {
                 int max=num[i],index=i;
                         for (int j=i+1;j<capacity;j++){
                    if(num[j]>max){
                        max=num[j];
                        index=j;
                    }
                         }
                         if(index!=i){
                             num[i]=num[i]+num[index];
                             num[index]=num[i]-num[index];
                             num[i]=num[i]-num[index];

                         }


                     }
    }


    /*
    * @function：插入排序
    *  根据已有序列，将后面的数字按照规则选出最大或最小插入当前序列
    * @author daobao
    * @date 2020/3/17
    * @param
    * @return
    */
    public void charu(){
            for (int i = 0; i <capacity-1 ; i++) {
                int index=i;

                for (int j=i+1;j>0;j--){

                  if(num[index]>num[j]){
                      break;
                  }
                    num[j]=num[j]+num[j-1];
                    num[j-1]=num[j]-num[j-1];
                    num[j]=num[j]-num[j-1];
                    index--;
                }
            }
    }
    /*
     * @function：插入排序升级版
     *  不在逐个比较，通过先找到要插入的索引，让后经过挪动，在交换，不用挨个进行交换
     * @author daobao
     * @date 2020/3/17
     * @param
     * @return
     */
    public void charu1(){
        for (int i = 1; i <capacity ; i++) {
            int j=i;
            int now=num[i];
            while(j>0&&now>num[j-1]){
                num[j]=num[j-1];
                j--;
            }
            num[j]=now;
        }
    }
    /*
     * @function：插入排序升级版
     *  不在逐个比较，通过先找到要插入的索引，让后经过挪动，在交换，不用挨个进行交换
     *  通过二叉查找
     * @author daobao
     * @date 2020/3/17
     * @param
     * @return
     */
    public void charu2(){
        for (int i = 1; i <capacity ; i++) {
            int index = binarySearch1(i);
            int now=num[i],j=i;
            while(j!=index&&index!=i){
                num[j]=num[j-1];
                j--;
            }
            num[index]=now;

        }
    }

    /**
     * 二分查找
     * @param num
     * @return
     */
    public int binarySearch(int target){
        int begin=0;
        int end=num.length;
        while(begin<end){
            int mid=(begin+end)>>1;
            if(target<num[mid]){
                begin=mid+1;
            }else if(target>num[mid]){
                end=mid;
            }else{
                return begin;
            }
        }
        return -1;
    }
    /**
     * 二分查找改造 为插入排序
     * @param num
     * @return
     */
    public int binarySearch1(int index){
        int begin=0;
        int end=index;
        while(begin<end){
            int mid=(begin+end)>>1;
            if(num[index]<num[mid]){
                begin=mid+1;
            }else{
                end=mid;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        //sort.maopao();
        //sort.xuanze();
       // sort.print();
        sort.print();
        sort.charu2();
        //sort.print();
       // sort.print();

//        int[][] x=new int[][]{{1,3,4,5},{6,7,8,9}};
//        System.out.println(x.length);
//      String p="as";
//      List<Integer> list=new ArrayList<>();
//      list.stream().mapToInt(Integer::valueOf).toArray();


    }
}

@Data
@Accessors(chain = true)
class Qsort<E extends Comparable> implements Runnable{
    E e;
    int cmpable;
    Qsort(int cmpable){
        this.cmpable=cmpable;
    }
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(cmpable);
            System.out.print(cmpable+"\t");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        int[] num=new int[]{5,4,6,14,4,7,1,10,4};
        for (int i = 0; i < num.length; i++) {
            new Thread(new Qsort(num[i])).start();
        }
    }
}