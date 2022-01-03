package concurrent.thirteenThree;

/**
 * @Author 59456
 * @Date 2022/1/3
 * @Descrip 静态内部类实现单例
 * @Version 1.0
 */
public class Holder {
    private Holder() {
    }

    public Holder getInstance(){
        return InnerClass.holder;
    }

    public static class InnerClass{
        private static final Holder holder = new Holder();
    }
}
