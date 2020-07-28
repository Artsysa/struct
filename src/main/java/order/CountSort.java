package order;

/*
 * @breif:计数排序
 * @Author: lyq
 * @Date: 2020/5/4 10:03
 * @Month:05
 */
public class CountSort extends Sort{
    int[] backup;
    public CountSort(){
        super();
        backup=new int[num.length+1];
    }

    public void sort(){
        for(int i=0;i<num.length;i++){
            backup[num[i]]++;
        }
        int index=0;
        for (int i = 0; i <backup.length;i++ ) {
           while(backup[i]-->0){
               num[index++]=i;
           }
        }
    }

    public static void main(String[] args) {
        CountSort countSort = new CountSort();
        countSort.sort();
        countSort.print();
    }
}
