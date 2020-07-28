package order;

/*
 * @breif:归并排序
 * @author: lyq
 * @Date: 2020/5/2 17:57
 * @Month:05
 */
public class MergeSort extends  Sort {

    int[] backup=new int[num.length>>1];

    MergeSort(){

        super();
    }
    public void sort(){
            sort(0,num.length-1);
    }

    public void sort(int begin,int end){
        if(end-begin<2) return;
        int mid=(begin+end)>>1;
        sort(begin,mid);
        sort(mid,end);
        merge(begin,mid,end);
    }

    public void merge(int begin ,int mid,int end){
      int li=0,ri=mid,mi=begin;
      int le=mid-begin,re=end;
      int i=li;
      while(i<le)
      {
          backup[i]=num[begin+i];
          i++;
      }
      while(li<le){
          if(ri<=re&&backup[li]<=num[ri]){
              num[mi++]=num[ri++];
          }else{//<=
              num[mi++]=backup[li++];
          }
      }
    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        Sort sort = new Sort();
        sort.num=mergeSort.num;
        long current = System.currentTimeMillis();
        mergeSort.sort();
        long end = System.currentTimeMillis();
        //mergeSort.print();
        System.out.println("("+((end-current))/1000f+"s)"+(end-current)+"ms");

         current = System.currentTimeMillis();
        sort.charu2();
         end = System.currentTimeMillis();
        //mergeSort.print();
        System.out.println("("+((end-current))/1000f+"s)"+(end-current)+"ms");

//        current = System.currentTimeMillis();
     //   quickSort.sort();
//        end = System.currentTimeMillis();
//        mergeSort.print();
//        System.out.println("("+((end-current))/1000f+"s)"+(end-current)+"ms");

    }

}
