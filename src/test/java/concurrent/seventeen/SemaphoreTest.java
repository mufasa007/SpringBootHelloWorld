package concurrent.seventeen;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author 59456
 * @Date 2021/12/29
 * @Descrip
 * @Version 1.0
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"=>"+"抢到车位! ");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
                System.out.println(Thread.currentThread().getName()+"=>"+"释放车位! ");
            },String.valueOf(i)).start();
        }

    }

}
