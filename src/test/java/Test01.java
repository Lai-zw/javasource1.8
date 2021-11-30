import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.HashMap;
import java.util.stream.Stream;


public class Test01 {

    @TestFactory
    @Test
    public void test01() {

        HashMap<String, String> map = new HashMap();
        map.put("A", "a");
        System.out.println(map);

        Stream<Integer> integerStream = Stream.of(1, 2, 10, 12);
        Integer integer = integerStream.max(Integer::compareTo).get();
        System.out.println(integer);

    }

}
