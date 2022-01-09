package concurrent.five;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author 59456
 * @Date 2022/1/8
 * @Descrip
 * @Version 1.0
 */
public class LockTest {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(Tiket::getOne, String.valueOf(i)).start();
        }
    }
}

class Tiket{
    private static Integer sum = 10;
    private static Lock lock = new ReentrantLock();
    public static void getOne() {
        lock.lock();
        try {

            if(sum>0){
                sum --;
                System.out.println(Thread.currentThread().getName()+"=>"+sum);
            }else {
                System.out.println(Thread.currentThread().getName()+"=>未买到车票");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
