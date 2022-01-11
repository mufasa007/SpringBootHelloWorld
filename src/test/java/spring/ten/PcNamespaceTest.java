package spring.ten;

import com.example.springboothelloworld.bean.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author 59456
 * @Date 2022/1/11
 * @Descrip
 * @Version 1.0
 */
public class PcNamespaceTest {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-properties/student-p.xml");
//        Student student = (Student) context.getBean("student-p");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-properties/student-c.xml");
        Student student = (Student) context.getBean("student-c");
        System.out.println(student);
    }
}
