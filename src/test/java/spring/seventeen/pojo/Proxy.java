package spring.seventeen.pojo;

/**
 * @Author 59456
 * @Date 2022/1/13
 * @Descrip
 * @Version 1.0
 */
public class Proxy {

    private Host host;

    public void setHost(Host host) {
        this.host = host;
    }

    public void rent(){
        fare();
        host.rent();
    }

    public void fare(){
        System.out.println("中介收费");
    }
}
