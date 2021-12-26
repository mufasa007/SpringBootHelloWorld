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
 */
public class Application {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendMsg();
        },"A").start();

        // 休息1秒钟
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        },"B").start();
    }

}

class Phone{
    public synchronized void sendMsg(){
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }
}


