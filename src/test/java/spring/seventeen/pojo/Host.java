package spring.seventeen.pojo;

/**
 * @Author 59456
 * @Date 2022/1/13
 * @Descrip
 * @Version 1.0
 */
public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房东出租房子");
    }
}
