package concurrent.thirteenOne;

import java.util.concurrent.TimeUnit;

/**
 * @Author 59456
 * @Date 2022/1/3
 * @Descrip
 * @Version 1.0
 */
public class VisaulableTest {
//    private static Integer count = 0;
    private static volatile Integer count = 0;
    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            System.out.println("recursive in! ");
            while (count==0){
//                System.out.println(count);
            }
            System.out.println("recursive out! ");
        }).start();

        TimeUnit.SECONDS.sleep(1);
//        for (int i = 0; i < 10; i++) {
            count ++;
//        }
        System.out.println("counting! ");
        System.out.println("main thread =>" + count);
    }
}
