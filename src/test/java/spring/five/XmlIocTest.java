package spring.five;

import com.example.springboothelloworld.bean.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author 59456
 * @Date 2022/1/9
 * @Descrip
 * @Version 1.0
 */
public class XmlIocTest {
    public static void main(String  [] args) {
        // 获取spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-properties/beans.xml");
        // 我们的对象现在都在Spring中管理了，使用的时候直接取出即可
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello);
    }
}
