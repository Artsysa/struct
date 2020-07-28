package test;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/7/6 18:37
 * @Month:07
 */
public class TestThread {
    static int x=0;
    static int y=0;
    public static void main(String[] args) {
        new Thread(()->{
            x=1;
            int R1=y;
            System.out.println(R1);
        }).start();
        new Thread(()->{
            y=1;
            int R2=x;
            System.out.println(R2);
        }).start();
        TestThread testThread = new TestThread();
        testThread.te();
    }

    public void te(){
        tee();
    }
    public static void tee(){

    }
}

class A{
    static {
        System.out.println("a");
    }
    A(){
        System.out.println("b");
    }
}
class B extends A{
    static {
        System.out.println("c");
    }

    B(){
        System.out.println("d");
    }

    public static void main(String[] args) {
        A b = new B();
        B d=new B();
        
        long as=11;
        double ss=3.4;
        as=(long)ss;
        float ssd=1.1f;
        byte bbb=111;
        char[] ch=new char[]{'啊'};
        int ct=1;

        System.out.println((long)Math.pow(2, 32));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(ch.length);
        Integer sa=3;
        Math.sqrt(222);
        Math.sqrt(222.2);
        Math.sqrt(bbb);
    }

}

class Threa{
    public static void main(String[] args) {
       new Thread(()->{
           for (int i = 0; i < 20000; i++) {

           }
           try {
               Thread.sleep(99999999);
           } catch (Exception e) {
               e.printStackTrace();
           }
       },"TestSleep").start();
    }
}
class sta{
    static class OOO{

    }
}
class Tttt{
    public static void main(String[] args) {
        sta.OOO ooo = new sta.OOO();
    }
}