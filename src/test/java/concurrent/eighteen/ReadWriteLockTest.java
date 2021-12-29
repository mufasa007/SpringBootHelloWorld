package concurrent.eighteen;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author 59456
 * @Date 2021/12/29
 * @Descrip
 * @Version 1.0
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.put(finalI+"",finalI);
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println("读取完成"+finalI+":" + myCache.get(finalI+"") );
            }, String.valueOf(i)).start();
        }
    }
}

class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock reentrantReadWriteLock= new ReentrantReadWriteLock();


    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "=>写入");
        try {
            reentrantReadWriteLock.writeLock().lock();
            TimeUnit.SECONDS.sleep(1);
            this.map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "=>写入完成！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public Object get(String key) {
        Object value = null;
        try {
            System.out.println(Thread.currentThread().getName()+"=>读取");
            reentrantReadWriteLock.readLock().lock();
            value =  map.get(key);
            System.out.println(Thread.currentThread().getName()+"=>读取完成！");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }

        return value;
    }


}
