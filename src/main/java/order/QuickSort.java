package order;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/5/3 16:37
 * @Month:05
 */
public class QuickSort extends Sort {
    QuickSort(){
        super();
    }

    public void sort(){
        sort(0,num.length-1);
    }

    public void sort(int begin, int end) {
        if(end-begin<2) return;
        int point = point(begin, end);
        sort(begin,point);
        sort(point+1,end);
    }

    public int point(int begin,int end){
        int now=num[begin];

        while(begin<end){
          while(begin<end){
              if(num[end]>now){
                  num[begin]=num[end];
                  begin++;
                  break;
              }else{
                  end--;
              }
          }
            while(begin<end){
                if(num[begin]>now){
                    end--;
                }else{
                    num[end]=num[begin];
                    begin++;
                    break;
                }
            }
        }

        num[begin]=now;
        return begin;
    }
}
