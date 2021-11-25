import java.util.HashMap;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap();
        map.put("A", "a");
        System.out.println(map);

        // 接收一个泛型对象或可变成泛型集合，构造一个 Stream 对象。
        Stream<String> stringStream = Stream.of("a", "b", "c");
        // 连接两个 Stream ，不改变其中任何一个 Steam 对象，返回一个新的 Stream 对象
        Stream<String> a = Stream.of("a","b","c");
        Stream<String> b = Stream.of("d","e");
        Stream<String> c = Stream.concat(a,b);

        Stream<Integer> integerStream = Stream.of(1, 2, 10, 12);
        Integer integer = integerStream.max(Integer::compareTo).get();
//        System.out.println(integer);
    }

}
