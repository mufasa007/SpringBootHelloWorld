package concurrent.thirteenSix;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author 59456
 * @Date 2022/1/7
 * @Descrip
 * @Version 1.0
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        new Thread(phone::sms,"A").start();
        new Thread(phone::sms,"B").start();
    }
}

class Phone2{
    Lock lock = new ReentrantLock();
    public void sms(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"=>"+"发短信");
            call();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void call(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"=>"+"打电话");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class Phone{
    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName()+"=>"+"发短信");
        call();
    }

    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"=>"+"打电话");
    }
}