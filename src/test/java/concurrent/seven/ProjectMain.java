package concurrent.seven;

/**
 * @Author 59456
 * @Date 2021/12/23
 * @Descrip 判断等待、业务、通知
 * @Version 1.0
 */
public class ProjectMain{
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

//        new Thread(()->{
//            for (int i = 0; i < 100; i++) {
//                try {
//                    data.increment();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"C").start();
//
//
//        new Thread(()->{
//            for (int i = 0; i < 100; i++) {
//                try {
//                    data.decrement();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"D").start();
    }
}

 class Data {
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        if(number!=0){
            // 等待
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        // 通知其他线程,+1完成
        this.notify();
    }

    public synchronized void decrement() throws InterruptedException {
        if(number==0){
            // 等待
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        // 通知其他线程,-1完成
        this.notify();
    }
}
