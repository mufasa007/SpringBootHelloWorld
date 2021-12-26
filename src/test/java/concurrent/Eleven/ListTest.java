package concurrent.Eleven;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author 59456
 * @Date 2021/12/26
 * @Descrip ConcurrentModificationException
 * @Version 1.0
 */
/**
 * 1,使用vector解决，本质就是synchronized(jdk1.0)
 */
public class ListTest {


    public static void main(String[] args) throws InterruptedException {
        List<String> stringList = new Vector<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                stringList.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(stringList);
            },String.valueOf(i)).start();
        }
        stringList.forEach(System.out::println);
        TimeUnit.SECONDS.sleep(4);
        stringList.forEach(System.out::println);
    }
}
