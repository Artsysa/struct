package order;


import util.RandomIntegerArray;
import util.TaskTime;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/6/17 17:52
 * @Month:06
 */
public class TenSort {
    public static void main(String[] args) {
        TenSort sort = new TenSort();
        int[] array = RandomIntegerArray.getArray(10000000, 0, 30000000);
        int[] array1=Arrays.copyOf(array,array.length);
        int[] array2=Arrays.copyOf(array,array.length);
        int[] array3=Arrays.copyOf(array,array.length);
        int[] array4=Arrays.copyOf(array,array.length);
        int[] array5=Arrays.copyOf(array,array.length);
        int[] array6=Arrays.copyOf(array,array.length);
//        new TaskTime(()->{
//            int[] num=new int[]{1,2,4,3,7};
//            sort.print(num);
//            int target=new Scanner(System.in).nextInt();
//            System.out.println(sort.binSearch(num, target));
//        },"二分查找");
        new TaskTime(()->{
            Arrays.sort(array3);
        },"系统自带的排序");
        new TaskTime(()->{
            sort.quickSort(array6);
           // sort.print(array6);
        },"快速排序");
        new TaskTime(()->{
            sort.meregeSort(array5);
         //   sort.print(array5);
        },"归并排序");
        new TaskTime(()->{
            sort.insert1(array4);
           //  sort.print(array4);
        },"插入排序-二分搜索");
        new TaskTime(()->{
            sort.insert(array2);
            // sort.print(array2);
        },"插入排序");
        new TaskTime(()->{
            sort.select(array1);
         //   sort.print(array);
        },"选择排序");
        new TaskTime(()->{
            sort.maopao(array);
            //   sort.print(array);
        },"冒泡排序");

    }


    /**
     * 冒泡排序
     * @param num
     */
    public void maopao(int[] num){
        for (int i = 0; i <num.length; i++) {
            for (int j=1;j<num.length-i;j++){
                if(num[j-1]>num[j])
                    swap(num,j,j-1);
            }
        }
    }

    /**
     * 选择排序
     * @param num
     */
    public void select(int[] num){
      for(int i=0;i<num.length-1;i++){
          int index=i;
          for(int j=i+1;j<num.length;j++){
              if(num[index]>num[j])
                  index=j;
          }
          if(index!=i)
              swap(num,index,i);
      }
    }

    /***
     * 插入排序
     * @param num
     */
    public void insert(int[] num){
        for (int i = 1; i <num.length ; i++) {
            int tmp=num[i],cur=i;
            while(cur>0&&tmp<num[cur-1]){
                num[cur]=num[cur---1];
            }
            num[cur]=tmp;
        }
    }
    /***
     * 插入排序升级 通过二分查找找到位置
     * @param num
     */
    public void insert1(int[] num){
        for (int i = 1; i <num.length ; i++) {
            int tmp=num[i];
            int cur=binSearch(num,0,i,tmp);
            int point=i;
            while(point!=cur&&cur!=i){
                num[point]=num[point---1];
            }
            num[cur]=tmp;
        }
    }

    /**
     * 归并排序
     * @param num
     */
    public void meregeSort(int[] num){
        meregeSort(num,0,num.length,new int[num.length>>1]);
    }

    /**
     * 归并排序
     * @param num
     * @param begin
     * @param end
     * @param temp
     */
    public void meregeSort(int[] num,int begin,int end,int[] temp){
        if((end-begin)<2)return;
        int mid=(begin+end)>>1;
        meregeSort(num,begin,mid,temp);
        meregeSort(num,mid,end,temp);
        merege(num,begin,mid,end,temp);
    }

    /**
     * 归并排序
     * @param num
     * @param begin
     * @param mid
     * @param end
     * @param temp
     */
    private void merege(int[] num, int begin, int mid, int end, int[] temp) {
       int cur=begin,l=0,r=mid;
       for(int i=l;i<(mid-begin);i++)
           temp[i]=num[i+begin];
       while(l<(mid-begin)){
           if(r<end&&temp[l]>=num[r]){
               num[cur++]=num[r++];
           }else{
               num[cur++]=temp[l++];
           }
       }
    }

    /**
     * 快速排序
     * @param num
     */
    public void quickSort(int[] num){
        quickSort(num,0,num.length);
    }

    /**
     * 快速排序
     * @param num
     * @param begin
     * @param end
     */
    public void quickSort(int[] num,int begin,int end){
                if((end-begin)<2)return;
                int axis=getaxis(num,begin,end);
                quickSort(num,begin,axis);
                quickSort(num,axis+1,end);
    }

    /**
     * 快速排序
     * @param num
     * @param begin
     * @param end
     * @return
     */
    private int getaxis(int[] num, int begin, int end) {
        int tmp=num[begin];
        end--;
        while(begin<end){
            while(begin<end){
               if(num[end]>tmp){
                   end--;
               }else{
                   num[begin++]=num[end];
                   break;
               }
            }
            while(begin<end){
                if(num[begin]<tmp){
                    begin++;
                }else{
                    num[end--]=num[begin];
                    break;
                }
            }
        }
        num[begin]=tmp;
        return begin;
    }

    /**
     * 二分查找
     * @param num
     * @param target
     * @return
     */
    public int binSearch(int[] num,int begin,int end,int target){
      while(begin<end){
          int mid=(begin+end)>>1;
          if(target<num[mid]){
              end=mid;
          }else if(target>num[mid]){
              begin=mid+1;
          }else{
              return mid;
          }
      }
      return begin;
    }

    public void print(int[] num){
        for (Integer integer : num) {
            System.out.print(integer+"_");
        }
        System.out.println();
    }

    public void swap(int[] num,int i,int j){
        num[i]=num[i]+num[j];
        num[j]=num[i]-num[j];
        num[i]=num[i]-num[j];
    }
}
