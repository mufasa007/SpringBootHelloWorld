package concurrent.thirteenOne;

/**
 * @Author 59456
 * @Date 2022/1/3
 * @Descrip
 * @Version 1.0
 */
public class VolatileTest {
    private static Integer sum = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                add();
            }).start();
        }
        System.out.println("sum=>"+sum);
    }

    public static void add(){
        sum += 1;
    }
}
