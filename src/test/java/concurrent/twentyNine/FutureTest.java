package concurrent.twentyNine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author 59456
 * @Date 2022/1/3
 * @Descrip
 * @Version 1.0
 */
public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("one");
        });

        System.out.println("second");

        // 当需要取未来的返回值时，就会阻塞main线程，直到获取到数据
        System.out.println(completableFuture.get());
    }
}
