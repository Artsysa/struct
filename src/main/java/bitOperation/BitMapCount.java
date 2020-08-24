package bitOperation;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @describe:位图统计人数以及系统状态
 * @author: lyq
 * @date: 2020/8/14 14:54
 */
public class BitMapCount {
    Integer countCtl = 0;
    final static Integer BIT_COUNT = Integer.SIZE - 3;
    final static Integer STATUS = -1 << BIT_COUNT;
    final static Integer RUN = 1 << BIT_COUNT;
    final static Integer PARSURE = 2 << BIT_COUNT;
    final static Integer STOP = 3 << BIT_COUNT;
    final static ReentrantLock lock = new ReentrantLock();
    public int getCount(int curCtl){
        return curCtl & ~ STATUS;
    }
    public int CtlStatus(int curCtl){
        return curCtl & STATUS;
    }
    public void setCtl(int aimCtl){
        lock.lock();
        try {
            aimCtl &= STATUS;
            int count = getCount(countCtl);
            countCtl = aimCtl | count;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          lock.unlock();
        }
    }
    public  void increase(){
        lock.lock();
        try {
            countCtl++;
            System.out.println(Thread.currentThread().getName() + "--" + getCount(countCtl));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          lock.unlock();
        }
    }
    public void decrease(){
        lock.lock();
        try {
            countCtl--;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Integer(500) == new Integer(500));
        BitMapCount bitMap = new BitMapCount();
//        System.out.println(bitMap.countCtl + "~~~~~" + Integer.toBinaryString(bitMap.countCtl));
//        bitMap.setCtl(STOP);
//        System.out.println(bitMap.countCtl + "~~~~~" + Integer.toBinaryString(bitMap.countCtl));
//        bitMap.increase();
//        bitMap.increase();
//        System.out.println(bitMap.countCtl + "~~~~~" + Integer.toBinaryString(bitMap.countCtl));
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                bitMap.increase();
                countDownLatch.countDown();
            },String.valueOf(i)).start();
//            if( (i & (i - 1)) == 0) {
//                new Thread(()->{
//                    bitMap.setCtl(STOP);
//                },String.valueOf(i)).start();
//            } else {
//                new Thread(()->{
//                    bitMap.setCtl(RUN);
//                },String.valueOf(i)).start();
//            }

        }
        countDownLatch.await();
        System.out.println(bitMap.getCount(bitMap.countCtl) + "~~~~" + Integer.toBinaryString(bitMap.countCtl));
    }
}
