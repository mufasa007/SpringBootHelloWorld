package concurrent.thirteenThree;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author 59456
 * @Date 2022/1/3
 * @Descrip 静态内部类实现单例
 * @Version 1.0
 */
public class Holder {
    private Holder() {
    }

    public static Holder getInstance(){
        return InnerClass.holder;
    }

    public static class InnerClass{
        private static final Holder holder = new Holder();
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Holder holder0 = getInstance();
        Constructor<Holder> constructor = Holder.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        Holder holder1 = constructor.newInstance();

        System.out.println(holder0);
        System.out.println(holder1);
    }
}
