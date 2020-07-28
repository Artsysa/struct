package util;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/6/17 18:10
 * @Month:06
 */
public  class RandomIntegerArray {
    public static int[] getArray(int n,int start,int end){
        int[] num=new int[n];
        for(int i=0;i<n;i++){
            num[i] = (int)(start+Math.random() * (end - start + 1));
        }
        return num;
    }
}
