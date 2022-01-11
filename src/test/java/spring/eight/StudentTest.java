package spring.eight;

import com.example.springboothelloworld.bean.pojo.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author 59456
 * @Date 2022/1/10
 * @Descrip
 * @Version 1.0
 */
public class StudentTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-properties/student.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }
}
