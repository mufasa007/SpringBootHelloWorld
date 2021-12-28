package concurrent.fifteen;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author 59456
 * @Date 2021/12/28
 * @Descrip
 * @Version 1.0
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(countDownLatch.getCount()+"=>"+Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println(countDownLatch.getCount()+"=>"+Thread.currentThread().getName());
            },String.valueOf(i)).start();
        }

        try {
            System.out.println("before"+countDownLatch.getCount());
            countDownLatch.await();
            System.out.println("after"+countDownLatch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
