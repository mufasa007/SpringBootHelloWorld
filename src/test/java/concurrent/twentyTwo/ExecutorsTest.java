package concurrent.twentyTwo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 59456
 * @Date 2021/12/30
 * @Descrip 工具类
 * @Version 1.0
 */

/***
 * 3大方法
 */
public class ExecutorsTest {
    public static void main(String[] args) {


        //  * 3大方法
        ExecutorService threadPool = Executors.newSingleThreadExecutor();// 单个线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(3);//固定线程大小
//        ExecutorService threadPool = Executors.newCachedThreadPool();//可伸缩的

        try {
            for (int i = 0; i < 50; i++) {
                int finalI = i;
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"=>"+ finalI);
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }




    }

}

/**
 *
 */
