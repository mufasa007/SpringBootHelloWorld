package concurrent.twentySeven;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @Author 59456
 * @Date 2022/1/1
 * @Descrip
 * @Version 1.0
 */

/**
 * 1，ID必须是偶数
 * 2,年龄大于23岁
 * 3,用户名转换为大写
 * 4,用户名倒序
 * 5,只输出1个数据
 */
public class StreamTest {
    public static void main(String[] args) {
        User u1 = new User(1,"a",21);
        User u2 = new User(2,"b",22);
        User u3 = new User(3,"c",23);
        User u4 = new User(4,"d",24);
        User u5 = new User(5,"e",25);
        List<User> userList = Arrays.asList(u1,u2,u3,u4,u5);

//        userList.stream()
//                .filter(u->u.getId()%2==0)
//                .forEach(System.out::println);

//        userList.stream()
//                .filter(u->u.getAge()>23)
//                .forEach(System.out::println);

//        userList.stream()
//                .map(u->{u.setName(u.getName().toUpperCase(Locale.ROOT));
//                    return u;
//                })
//                .forEach(System.out::println);

//        userList.stream()
//                .sorted((uu1,uu2)->uu2.getName().compareTo(uu1.getName()) )
//                .forEach(System.out::println);

        userList.stream()
                .limit(1)
                .forEach(System.out::println);

    }
}
