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
        seeHouse();
        sign();
        host.rent();
        fare();
    }

    public void seeHouse(){
        System.out.println("中介带人看房");
    }

    public void sign(){
        System.out.println("中介签合同");
    }

    public void fare(){
        System.out.println("中介收费");
    }
}
