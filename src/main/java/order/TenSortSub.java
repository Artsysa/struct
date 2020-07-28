package order;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/7/8 22:54
 * @Month:07
 */
public class TenSortSub {
    public void swap(int[] num,int i,int j){
        num[i]=num[i]+num[j];
        num[j]=num[i]-num[j];
        num[i]=num[i]-num[j];
    }
}
