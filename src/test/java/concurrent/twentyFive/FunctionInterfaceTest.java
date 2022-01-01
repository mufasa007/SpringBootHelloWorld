package concurrent.twentyFive;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author 59456
 * @Date 2022/1/1
 * @Descrip
 * @Version 1.0
 */
public class FunctionInterfaceTest {

    public static void main(String[] args) {

        // 普通Function
//        Function<String, String> function = new Function<String, String>() {
//            /**
//             * Applies this function to the given argument.
//             *
//             * @param o the function argument
//             * @return the function result
//             */
//            @Override
//            public String apply(String o) {
//                return "==>" +o  ;
//            }
//        };

//        // 函数式Function
//        Function<String, String> function = e->"==>" + e;
//        System.out.println(function.apply("123456"));
//        System.out.println(function.apply("123"));

//        // 断定型接口Predicate
////        Predicate<String> predicate = e->"hello".equals(e);
//        Predicate<String> predicate = "hello"::equals;
//        System.out.println(predicate.test("hello"));
//        System.out.println(predicate.test("12345"));

//        // 消费者接口consumer
////        Predicate<String> predicate = e->"hello".equals(e);
//        Consumer<String> consumer = System.out::println;
//        consumer.accept("hello");
//        consumer.accept("12345");

        // 生产型接口Supplier
        Supplier<String> stringSupplier = ()->"hello";
        System.out.println(stringSupplier.get());
    }

}
