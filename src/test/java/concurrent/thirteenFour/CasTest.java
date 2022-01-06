package concurrent.thirteenFour;

import ch.qos.logback.core.util.TimeUtil;
import concurrent.twentySeven.User;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author 59456
 * @Date 2022/1/5
 * @Descrip
 * @Version 1.0
 */
public class CasTest {

    public static void main(String[] args) throws Exception {
        // AtomicStampedReference 如果泛型是一个包装类，注意对象的引用问题【阿里巴巴编码规范中也有该描述】
        // 正常的业务操作，这里比较的都是一个个对象
//        AtomicStampedReference<User> atomicStampedReference = new AtomicStampedReference(new User(1,"",1),1);
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100,1);

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"=stamp>"+stamp+";value=>"+atomicStampedReference.get(new int[]{stamp}));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"=>"+atomicStampedReference.compareAndSet(
                    100,
                    101,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp()+1));
            System.out.println(Thread.currentThread().getName()+"=stamp>"+atomicStampedReference.getStamp()+";value=>"+atomicStampedReference.get(new int[]{stamp}));
        },"a").start();

        // 与乐观锁的原理相同
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"=stamp>"+stamp+";value=>"+atomicStampedReference.get(new int[]{stamp}));
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"=>"+atomicStampedReference.compareAndSet(
                    101,
                    102,
                    stamp,
                    stamp+1));
            System.out.println(Thread.currentThread().getName()+
                    "=stamp>"+atomicStampedReference.getStamp()+
                    ";value=>"+atomicStampedReference.get(new int[]{stamp}));
        },"b").start();
    }
/*    a=stamp>1;value=>100
    b=stamp>1;value=>100
    a=>true
    a=stamp>2;value=>101
    b=>true
    b=stamp>3;value=>102*/
}

