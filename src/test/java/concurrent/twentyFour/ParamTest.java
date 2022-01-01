package concurrent.twentyFour;

/**
 * @Author 59456
 * @Date 2021/12/30
 * @Descrip
 * @Version 1.0
 */
public class ParamTest {
    public static void main(String[] args) {

        /***
         * cpu密集型：几核心cpu，就是几核,例如本机就是8核心
         *      int i = Runtime.getRuntime().availableProcessors();
         * IO密集型：判断程序中十分耗IO的线程,一般设置为2倍（防止阻塞）
         *      例如需要15个线程处理数据，尽量设置30个线程池个数
         */
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }

}
