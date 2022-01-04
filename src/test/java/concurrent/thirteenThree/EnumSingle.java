package concurrent.thirteenThree;

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


    public static void main(String[] args) {
        EnumSingle instance0 = EnumSingle.INSTANCE;
        EnumSingle instance1 = EnumSingle.INSTANCE;

        System.out.println(instance0);
        System.out.println(instance1);
    }
}
