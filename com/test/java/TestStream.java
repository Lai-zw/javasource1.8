import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {

    @Test
    public void test01() {
        // 创建流
        String[] strings = {"a", "b", "c"};
        Stream<String> stringStream1 = Arrays.stream(strings);

        // 接收一个泛型对象或可变成泛型集合，构造一个 Stream 对象。
        Stream<String> stringStream = Stream.of("a", "b", "c");

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
        list.add("fff");
        list.parallelStream().map(TestStream::convertElement).forEach(System.out::println);

        // 连接两个 Stream ，不改变其中任何一个 Steam 对象，返回一个新的 Stream 对象
        Stream<String> a = Stream.of("a", "b", "c");
        Stream<String> b = Stream.of("d", "e");
        Stream<String> c = Stream.concat(a, b);
    }


    @Test
    public void test02() {

        HashMap<String, String> map = new HashMap<>();
        map.put("A", "a");
        System.out.println(map);

        Stream<Integer> integerStream = Stream.of(1, 2, 10, 12);
        Integer integer = integerStream.max(Integer::compareTo).orElse(0);
        System.out.println(integer);

    }

    private static String convertElement(String element) {
        return element + "abc";
    }
}
