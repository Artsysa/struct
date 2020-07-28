package recursion;

/*
 * @breif:
 * @Author: ArDaBao
 * @Date: 2020/3/17 9:54
 * @Month:03
 */
public class PrintDemo {

    public static void main(String[] args) {
        PrintDemo printDemo = new PrintDemo();
      //  printDemo.print(6);
        System.out.println(printDemo.mult(7));
    }

    public void print(int n){
        if(n>1){
            print(n-1);
        }
            System.out.println("n="+n);

    }

    public int mult(int n){
        if(n==1){
            return 1;
        }
        return mult(n-1)*n;
    }
}
