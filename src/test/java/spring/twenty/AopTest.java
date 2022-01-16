package spring.twenty;

import com.example.springboothelloworld.web.service.UserAopService;
import com.example.springboothelloworld.web.service.impl.UserAopServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author 59456
 * @Date 2022/1/16
 * @Descrip
 * @Version 1.0
 */
public class AopTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-properties/AopSpring.xml");
        UserAopService userAopService = (UserAopService) context.getBean("userAopService");
        userAopService.add();
        userAopService.query();
    }
}
