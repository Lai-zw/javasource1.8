import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : TestThread
 */
public class TestThread {

    @Test
    public void test01() {
        InheritableThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set(6);
        System.out.println("父线程获取数据：" + threadLocal.get());

        new Thread(() -> System.out.println("子线程获取数据：" + threadLocal.get())).start();
    }

    @Test
    public void test02() {
        InheritableThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set(6);
        System.out.println("父线程获取数据：" + threadLocal.get());

        // 线程池线程复用，InheritableThreadLocal 对象中的值不变
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        threadLocal.set(6);
        executorService.submit(() -> System.out.println("第一次从线程池中获取数据：" + threadLocal.get()));

        threadLocal.set(7);
        executorService.submit(() -> System.out.println("第二次从线程池中获取数据：" + threadLocal.get()));
    }

    @Test
    public void test03() {
        TransmittableThreadLocal<Integer> threadLocal = new TransmittableThreadLocal<>();
        threadLocal.set(6);
        System.out.println("父线程获取数据：" + threadLocal.get());

        ExecutorService ttlExecutorService = TtlExecutors.getTtlExecutorService(Executors.newSingleThreadExecutor());

        threadLocal.set(6);
        ttlExecutorService.submit(() -> System.out.println("第一次从线程池中获取数据：" + threadLocal.get()));

        threadLocal.set(7);
        ttlExecutorService.submit(() -> System.out.println("第二次从线程池中获取数据：" + threadLocal.get()));
    }

}
