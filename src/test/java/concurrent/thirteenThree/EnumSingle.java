package concurrent.thirteenThree;

import java.lang.reflect.Constructor;
import java.util.ResourceBundle;

/**
 * @Author 59456
 * @Date 2022/1/3
 * @Descrip
 * @Version 1.0
 */
public enum EnumSingle {

    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        EnumSingle instance0 = EnumSingle.INSTANCE;

        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
//        Exception in thread "main" java.lang.NoSuchMethodException: concurrent.thirteenThree.EnumSingle.<init>()
        EnumSingle instance1 = declaredConstructor.newInstance(null);

        System.out.println(instance0);
        System.out.println(instance1);
    }
}
