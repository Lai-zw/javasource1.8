import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : Test
 */
public class Test00 {
    @Test
    public void test01() {
        Map<String,String> map = new HashMap<String, String>();
        map.put("1", "1");
        map.put("1", "2");
        map.put(null, null);
        System.out.println(map); // {1=2}
    }

    @Test
    public void test02() {
        String s = "φ219.1*8.18 20#";
        s = s.replaceAll("[ ][^\\\\\\/\\^]+", "");
        System.out.println(s);
    }
}
