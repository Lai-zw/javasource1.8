import com.google.common.base.Stopwatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * 线程切换测试
 */
public class ConcurrencyTest {

    private static final long count = 1000000000l;
    private static final Logger log = LogManager.getLogger(ConcurrencyTest.class);

    @Test
    public void test() throws InterruptedException {

        Stopwatch watch = Stopwatch.createStarted();
        log.info("--- 测试开始 ---");

        concurrency();
        serial();

        watch.stop();
        log.info("--- 测试结束 --- 用时：" + watch.elapsed(TimeUnit.MILLISECONDS));

    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int a = 0;
            for (long i = 0; i < count; i++) {
                a += 5;
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency: " + time + "ms, b=" + b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial: " + time + "ms, b=" + b + ", a=" + a);
    }
}