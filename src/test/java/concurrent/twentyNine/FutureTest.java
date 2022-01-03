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
/*        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("one");
        });*/

        // 有返回值的 异步回调
        // 成功或者失败
/*        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("one");
            return "second";
        });

        System.out.println("second");

        // 当需要取未来的返回值时，就会阻塞main线程，直到获取到数据
        System.out.println(completableFuture.get());*/

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                int sqrt = 10/0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("one");
            return 1024;
        });

        Integer result = completableFuture.whenComplete((t,u)->{
            System.out.println("t=>" + t); // 正常的返回结果
            System.out.println("u=>" + u); // 错误信息
        }) .exceptionally((e)->{
            e.printStackTrace();
            return 233;
        }).get();

        System.out.println("result:"+result);

    }
}
