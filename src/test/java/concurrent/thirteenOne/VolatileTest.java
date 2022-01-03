package concurrent.thirteenOne;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 59456
 * @Date 2022/1/3
 * @Descrip
 * @Version 1.0
 */
public class VolatileTest {
    private static volatile AtomicInteger sum = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2000; i++) {
            new Thread(()->{
                add();
            }).start();
        }
//        TimeUnit.SECONDS.sleep(1);
        while (Thread.activeCount()>2){
            // 1条GC线程,1条主线程
            Thread.yield();
        }
        System.out.println("sum=>"+sum);
    }

    public static void add(){
        sum.set(sum.get()+1);
    }
}
