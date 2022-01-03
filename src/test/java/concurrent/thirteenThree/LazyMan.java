package concurrent.thirteenThree;

/**
 * @Author 59456
 * @Date 2022/1/3
 * @Descrip
 * @Version 1.0
 */
public class LazyMan {
    private LazyMan() {
        System.out.println(Thread.currentThread().getName() + "ok");
    }

    private static LazyMan lazyMan;

    /**
     * 单线程下，没有问题，但是高并发时GG
     * DCL懒汉模式可以在高并发时没有并发问题，但是原子性无法保证
     * @return
     */
    public static LazyMan getInstance(){
        if(lazyMan==null){
            synchronized (LazyMan.class){
                if(lazyMan==null){
                    lazyMan = new LazyMan();// 不是原子性操作

                    /**
                     * 1，分配内存空间
                     * 2，执行构造方法，初始化对象
                     * 3，把这个对象指向这个空间
                     */
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                LazyMan.getInstance();
            },String.valueOf(i)).start();

        }
    }
}
