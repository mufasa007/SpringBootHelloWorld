package spring.three;

import com.example.springboothelloworld.web.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author 59456
 * @Date 2022/1/9
 * @Descrip
 * @Version 1.0
 */
public class IocTest {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        userService.setUserDao(new UserDaoMysqlImpl());
//        userService.getUser();

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-properties/user.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.getUser();
    }
}
