package concurrent.thirteenEight;

import java.util.concurrent.TimeUnit;

/**
 * @Author 59456
 * @Date 2022/1/7
 * @Descrip
 * @Version 1.0
 */
public class DeadLockTest {
    public static void main(String[] args) {
        String lockA = "A";
        String lockB = "B";
        new Thread(new DemoThread(lockA,lockB)).start();
        new Thread(new DemoThread(lockB,lockA)).start();
    }
}

class DemoThread implements Runnable{
    private String lockA;
    private String lockB;

    public DemoThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized(lockA){
            System.out.println(Thread.currentThread().getName() + "lock:"+lockA+"=>get:"+lockB);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "lock:"+lockB+"=>get:"+lockA);
            }
        }

    }
}