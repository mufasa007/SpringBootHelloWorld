package concurrent.ten;

/**
 * @Author 59456
 * @Date 2021/12/26
 * @Descrip
 * @Version 1.0
 */

import java.util.concurrent.TimeUnit;

/***
 * 8锁问题
 * 1,两个synchronized多线程执行
 * 发短信先
 * 2,两个synchronized多线程执行，先调用的延时4s
 * 发短信先,因为有锁的存在
 * synchronized锁的是对象：方法的调用者,谁先拿到谁执行
 * 3,有一个非synchronized的方法,没有锁的影响
 * 你好先
 * 4,2个对象phone1\phone2，不同的锁
 * 打电话先
 */
public class Application {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            phone1.sendMsg();
        },"A").start();

        // 休息1秒钟
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone2.call();
        },"B").start();
    }

}

class Phone{
    //
    public synchronized void sendMsg(){
        // 休息1秒钟
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("你好");
    }
}


