package concurrent.thirteenFour;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 59456
 * @Date 2022/1/5
 * @Descrip
 * @Version 1.0
 */
public class CasTest {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(2021);
        System.out.println(Thread.currentThread().getName()+"=>"+atomicInteger.get());

        // 期望=>更新 CAS是CPU的并发原语
        atomicInteger.compareAndSet(2021,2022);
        System.out.println(Thread.currentThread().getName()+"=>"+atomicInteger.get());

        new Thread(()->{
            atomicInteger.compareAndSet(2022, 2021);
            System.out.println(Thread.currentThread().getName()+"=>"+atomicInteger.get());
        }).start();

        // 与期望值不符合=>不更新
        TimeUnit.SECONDS.sleep(1);
        atomicInteger.compareAndSet(2021,2022);
        System.out.println(Thread.currentThread().getName()+"=>"+atomicInteger.get());
    }

}
