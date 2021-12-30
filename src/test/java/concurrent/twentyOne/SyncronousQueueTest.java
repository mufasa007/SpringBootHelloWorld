package concurrent.twentyOne;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author 59456
 * @Date 2021/12/30
 * @Descrip
 * @Version 1.0
 */
public class SyncronousQueueTest {
    public static void main(String[] args) {
        SynchronousQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + "put1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "put2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "put3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "take" +blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "take" + blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "take" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();

        new Thread(()->{},"T2").start();
    }

}

/**
 * 同步队列是没有容量的
 */


