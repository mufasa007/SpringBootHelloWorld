package spring.seventeen.pojo;

/**
 * @Author 59456
 * @Date 2022/1/13
 * @Descrip
 * @Version 1.0
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy();
        proxy.setHost(host);
        proxy.rent();
    }
}
