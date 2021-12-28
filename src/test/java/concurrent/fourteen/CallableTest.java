package concurrent.fourteen;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author 59456
 * @Date 2021/12/28
 * @Descrip
 * @Version 1.0
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

/*        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }, "A").start();*/

/*        new Thread(new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        })).start();*/

//        new Thread(()->{},"A").start();

        MyThread myThread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myThread);
        new Thread(futureTask,"A").start();

        System.out.println(futureTask.get());

    }



}

class MyThread implements Callable<Integer>{

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        System.out.println("调用成功！");
        TimeUnit.SECONDS.sleep(5);
        return 10;
    }
}
