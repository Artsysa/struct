package jvm.classstruct;

/*
 * @describe:
 * @author: lyq
 * @date: 2020/7/28 9:11
 */
public class ClassStructTest {
    private volatile int m;
    public int inc(int s,double c){
        return m+1;
    }
    public int inc(int s,double c,String st){
        return m+1;
    }
    public static void main(String[] args) {

    }
    public void testRange(){
        {
            int b=1;
        }
       // b=3;
    }
}
