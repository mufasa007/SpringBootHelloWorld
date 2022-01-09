package concurrent.thirteenSeven;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author 59456
 * @Date 2022/1/7
 * @Descrip
 * @Version 1.0
 */
public class SpinLockTest {
    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        new Thread(()->{
            spinLock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"=>业务逻辑块开始执行");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                spinLock.unlock();
            }
        },"A").start();


        new Thread(()->{
            spinLock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"=>业务逻辑块开始执行");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                spinLock.unlock();
            }
        },"B").start();

    }
}

class SpinLock{
    AtomicReference<Thread> atomicReference = new AtomicReference();
    public void lock(){
        Thread thread = Thread.currentThread();
        long timeStart = System.currentTimeMillis();
        System.out.println(thread.getName()+"=>lock自旋开始，尝试获取锁!");
        while (!atomicReference.compareAndSet(null, thread)) {
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println(thread.getName()+"=>lock=>自旋结束,获取到锁! 耗时=>"+ (timeEnd-timeStart));
    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"=>unlock完成!");
        atomicReference.compareAndSet(thread,null);
    }
}