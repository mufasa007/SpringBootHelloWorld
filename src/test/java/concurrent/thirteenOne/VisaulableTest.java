package concurrent.thirteenOne;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 59456
 * @Date 2022/1/3
 * @Descrip
 * @Version 1.0
 */
public class VisaulableTest {
//    private static Integer count = 0;
    private static volatile AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            System.out.println("recursive in! ");
            while (count.get()==0){

            }
            System.out.println("recursive out! ");
        }).start();

        TimeUnit.SECONDS.sleep(1);
            count.set(count.get()+1);
        System.out.println("counting! ");
        System.out.println("main thread =>" + count);
    }
}
