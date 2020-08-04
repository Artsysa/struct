package thread;

import io.netty.util.concurrent.DefaultThreadFactory;
import util.TaskTime;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * @describe:
 * @author: lyq
 * @date: 2020/7/31 17:42
 */
public class TestUseThreadPoolExecutor {

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors()+1,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10),
            new DefaultThreadFactory("def"),
            new ThreadPoolExecutor.DiscardPolicy()
    );

    public static void main(String[] args) {
        TestUseThreadPoolExecutor test = new TestUseThreadPoolExecutor();
        int task=10000;
        int total=10;
        int addCount=task/total;
        new TaskTime(()->{
          //  test.divid(0,task);
        },"total");
        thread.addCount count = new addCount();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        new TaskTime(()->{
            int start=0;
            for (int i = 0; i < 10; i++) {
                test.threadPoolExecutor.execute(()->{
                   // System.out.println(count.start+"==="+count.start+count.addcount);
                    test.divid(start,start+1000);
                    countDownLatch.countDown();
                });
            }
            try {
                countDownLatch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"divid");
    }

    public void divid(int start,int end){
        try {
        Thread.sleep(end-start);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class addCount{
    int start=0;
    int addcount=1000;
}