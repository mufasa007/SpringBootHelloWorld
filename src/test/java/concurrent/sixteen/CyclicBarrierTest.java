package concurrent.sixteen;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author 59456
 * @Date 2021/12/28
 * @Descrip
 * @Version 1.0
 */
public class CyclicBarrierTest {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("加法计数完成!");
        });
        for (int i = 0; i < 7; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "=>" + cyclicBarrier.getNumberWaiting() + "=>" + cyclicBarrier.getParties());
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "=>" + cyclicBarrier.getNumberWaiting() + "=>" + cyclicBarrier.getParties());
            },String.valueOf(i)).start();
        }

//        System.out.println("before=>"+cyclicBarrier.getNumberWaiting());
//        cyclicBarrier.await();
//        System.out.println("after=>"+cyclicBarrier.getNumberWaiting());

    }

}
