import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : TestThread
 */
public class TestCollections {

    private static final Logger log = Logger.getLogger(TestCollections.class);
    StopWatch watch = new StopWatch();

    @BeforeEach
    public void testBefore() {
        watch.start();
        log.info("--- 测试开始 ---");
    }

    @Test
    public void test() {

    }


    @AfterEach
    public void testAfter() {
        watch.stop();
        log.info("--- 测试结束 --- 用时：" + watch.getTime(TimeUnit.MILLISECONDS));
    }

}
