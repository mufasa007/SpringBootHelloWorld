package concurrent.twentyThree;

import java.util.concurrent.*;

/**
 * @Author 59456
 * @Date 2021/12/30
 * @Descrip
 * @Version 1.0
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            // 最大承载：deque+max
            for (int i = 0; i < 6; i++) {
                int finalI = i;
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"=>" + finalI);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
