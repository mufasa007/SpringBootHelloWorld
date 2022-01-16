package spring.seventeen.pojo;

/**
 * @Author 59456
 * @Date 2022/1/13
 * @Descrip
 * @Version 1.0
 */
public class StaticProxyTest {
    public static void main(String[] args) {
//        Host host = new Host();
//        ProxyPre proxyPre = new ProxyPre();
//        proxyPre.setHost(host);
//        proxyPre.rent();

        Host host = new Host();
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setObject(host);
        Rent proxy = (Rent) proxyInvocationHandler.getProxy();
        proxy.rent();
    }
}
