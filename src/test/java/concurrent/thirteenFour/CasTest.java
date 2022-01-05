package concurrent.thirteenFour;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 59456
 * @Date 2022/1/5
 * @Descrip
 * @Version 1.0
 */
public class CasTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2021);
        System.out.println(atomicInteger.get());

        // 期望=>更新 CAS是CPU的并发原语
        atomicInteger.compareAndSet(2021,2022);
        System.out.println(atomicInteger.get());

        // 与期望值不符合=>不更新
        atomicInteger.compareAndSet(2021,2022);
        System.out.println(atomicInteger.get());
    }

}
