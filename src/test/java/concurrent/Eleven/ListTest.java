package concurrent.Eleven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 59456
 * @Date 2021/12/26
 * @Descrip
 * @Version 1.0
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("1", "2", "3");
        stringList.forEach(System.out::println);
    }
}
