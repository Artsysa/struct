package jvm.classstruct;

import java.util.Objects;

/*
 * @describe:
 * @author: lyq
 * @date: 2020/7/29 11:31
 */
public class ClassSynchronizedTest {
    Object object = new Object();
    public static void main(String[] args) {
        ClassSynchronizedTest classSynchronizedTest = new ClassSynchronizedTest();
        new Thread(()->{
            classSynchronizedTest.set();
        }).start();
        new Thread(()->{
            classSynchronizedTest.set1();
        }).start();
    }
    public synchronized void get(){

    }

    public void set1(){
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+":get lock");
        }
    }
    public void set(){
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+":get lock");
         try {
             Thread.sleep(2000);
         } catch (Exception e) {
             e.printStackTrace();
         }
         int i=10/0;
        }
    }
}
