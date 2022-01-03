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
     * @return
     */
    public static LazyMan getInstance(){
        if(lazyMan==null){
            lazyMan = new LazyMan();
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
