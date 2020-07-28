package leetcode;

/*
 * @breif:https://leetcode-cn.com/problems/maximum-subarray/submissions/
 * @Author: lyq
 * @Date: 2020/5/9 9:38
 * @Month:05
 */
public class Order53 {


    public static void main(String[] args) {
        int[] ints = {1, 2};
        Order53 order53 = new Order53();
        System.out.println(order53.maxSubArray(ints));
    }
    public int maxSubArray(int[] nums) {

        return getmax(0,nums.length,nums);
    }

    public int getmax(int begin,int end,int[] num){
        if(end-begin<2)return num[begin];
        int mid=(begin+end)>>1;
        int leftMax=-9999999;
        int max=0;
        int sum=0;
        for(int i=mid-1;i>=0;i--){
            sum+=num[i];
            leftMax=Math.max(leftMax,sum);
        }
        int rightMax=-999999;
        sum=0;
        for(int i=mid;i<end;i++){
            sum+=num[i];
            rightMax=Math.max(rightMax,sum);
        }
        max=leftMax+rightMax;
        return Math.max(max,Math.max(getmax(begin,mid,num),getmax(mid,end,num)));
    }
}
