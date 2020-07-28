package sign;

/*
 * @describe:测试中断
 * @author: lyq
 * @date: 2020/7/24 16:48
 */
public class TestInterrupt {
    volatile int interrupt=0;

    public void interrupt(){
        interrupt=1;
    }

    public void test(){
        while(true){
        try {
            Thread.sleep(3000);
            if(interrupt==1){
                throw new Exception("error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("exit");
            break;
        }
        }
    }

    public static void main(String[] args) {
        TestInterrupt testInterrupt = new TestInterrupt();
        new Thread(()->{
            testInterrupt.test();
        }).start();
        System.out.println("interrupt");
        testInterrupt.interrupt();
    }
}
