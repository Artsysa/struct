package test;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/7/7 8:27
 * @Month:07
 */
public class DeathThread {
    volatile static Integer a=0;
    static Integer b=1;

    public static void main(String[] args) {
        new Thread(()->{
            synchronized(a){
                System.out.println(Thread.currentThread().getName()+"抢占到a");
                Thread.yield();
                synchronized (b){
                    System.out.println(Thread.currentThread().getName()+"抢占到b");
                }
            }
        }).start();
        new Thread(()->{
            synchronized(b){
                System.out.println(Thread.currentThread().getName()+"抢占到b");
                synchronized (a){
                    System.out.println(Thread.currentThread().getName()+"抢占到a");
                }
            }
        }).start();
    }
}
