package spring.three;

import com.example.springboothelloworld.web.service.UserService;
import com.example.springboothelloworld.web.service.impl.UserServiceImpl;

/**
 * @Author 59456
 * @Date 2022/1/9
 * @Descrip
 * @Version 1.0
 */
public class IocTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.getUser();
    }
}
