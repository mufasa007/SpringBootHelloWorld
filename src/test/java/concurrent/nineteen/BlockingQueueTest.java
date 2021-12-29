package concurrent.nineteen;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author 59456
 * @Date 2021/12/29
 * @Descrip A-B 多线程并发处理,线程池
 * @Version 1.0
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
//         new BlockingQueue()
//        test1();
//        test2();
//        test3();
        test4();
    }

    /**
     * 抛出异常的方式
     */
    public static void  test1(){
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.peek());
        System.out.println("----------------");
//        System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
    }

    /**
     * 有返回值
     */
    public static void  test2(){
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.peek());
        System.out.println("----------------");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }


    /**
     * 阻塞等待
     */
    public static void  test3() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//        blockingQueue.put("d");

        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.peek());
        System.out.println("----------------");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
    }


    /**
     * 阻塞等待超时退出
     */
    public static void  test4() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.offer("a",1, TimeUnit.SECONDS);
        blockingQueue.offer("b",1, TimeUnit.SECONDS);
        blockingQueue.offer("c",1, TimeUnit.SECONDS);
        blockingQueue.offer("d",1, TimeUnit.SECONDS);
//        blockingQueue.put("d");

        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.peek());
        System.out.println("----------------");

        System.out.println(blockingQueue.poll(1,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(1,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(1,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(1,TimeUnit.SECONDS));
    }
}

