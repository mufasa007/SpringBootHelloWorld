package concurrent.thirteenThree;

/**
 * @Author 59456
 * @Date 2022/1/3
 * @Descrip
 * @Version 1.0
 */
public class Hungry {
    private Hungry() {
    }

    /**
     * 系统启动后,就直接初始化对象（static）
     * 缺点：这个单例有可能系统并没有使用！浪费内存
     */
    private final Hungry hungry = new Hungry();

    public Hungry getInstance() {
        return hungry;
    }
}
