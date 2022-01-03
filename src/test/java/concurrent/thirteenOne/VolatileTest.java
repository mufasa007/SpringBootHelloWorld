package concurrent.thirteenOne;

import java.util.concurrent.TimeUnit;

/**
 * @Author 59456
 * @Date 2022/1/3
 * @Descrip
 * @Version 1.0
 */
public class VolatileTest {
    private static  Integer sum = 0;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                add();
            }).start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println("sum=>"+sum);
    }

    public synchronized static void add(){
        sum += 1;
    }
}
