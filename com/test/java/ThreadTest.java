import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : TestThread
 */
public class ThreadTest {

    class MyThread implements Runnable {
        // 对象中的数据由线程共享
        private int counter_v = 0;
        private final AtomicInteger counter = new AtomicInteger(0);
        ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            // 最后输出的数据不一定为 20000
            try {
                lock.lock();
                for (int i = 0; i < 10000; i++) {
                    counter_v++;
                    counter.incrementAndGet();
                }
                // System.out.println(Thread.currentThread().getName() + "-" + "counter = " + counter);
                // System.out.println(Thread.currentThread().getName() + "-" + "counter_v = " + counter_v);

                System.out.println("counter = " + counter);
                System.out.println("counter_v = " + counter_v);

            } finally {
                lock.unlock();
            }
        }
    }

    @Test
    public void test08() throws InterruptedException {

        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                threadLocal.set((int) (Math.random() * 100D));
                System.out.println(Thread.currentThread().getName() + threadLocal.get());
            }, "Thread-").start();
        }
    }

    @Test
    public void test07() throws InterruptedException {
        MyThread t = new MyThread();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
    }

    @Test
    public void test06() throws InterruptedException {
        Thread t = new Thread(() -> {
            synchronized (ThreadTest.class) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "2");
            }
        });
        t.start();
        System.out.println(Thread.currentThread().getName() + "1");
        // 子线程结束后才被唤醒
        t.join(500);
        // 设置中断标志为 true
        t.interrupt();
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "3");
    }

    @Test
    public void test05() throws ExecutionException, InterruptedException {
        class Counter {
            //重入锁
            private final Lock lock = new ReentrantLock();
            private int count;

            public void incr() {
                // 访问count时，需要加锁
                lock.lock();
                try {
                    count++;
                } finally {
                    lock.unlock();
                }
            }

            public int getCount() {
                // 读取数据也需要加锁，才能保证数据的可见性
                lock.lock();
                try {
                    return count;
                } finally {
                    lock.unlock();
                }
            }
        }
        Counter counter = new Counter();
        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            Future<Integer> futureTask = executorService.submit(() -> {
                counter.incr();
                // System.out.println("当前线程:" + Thread.currentThread().getName());
                return counter.getCount();
            });
            list.add(futureTask);
        }
        for (Future<Integer> futureTask : list) {
            System.out.println("futureTask.get() = " + futureTask.get());
        }
    }

    @Test
    public void test04() throws ExecutionException, InterruptedException {
        int taskSize = 10;
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            // 执行任务并获取 Future 对象
            Future<String> f = new FutureTask<>(() -> {
                Thread.sleep(500);
                System.out.println("当前线程:" + Thread.currentThread().getName());
                return "hello world";
            });
            list.add(f);
        }
        for (Future<String> futureTask : list) {
            System.out.println("开始时间戳为:" + System.currentTimeMillis());
            pool.submit((Runnable) futureTask);
            String result = futureTask.get();
            System.out.println("结束时间戳为:" + System.currentTimeMillis() + "，result = " + result);
        }
        // 关闭线程池
        pool.shutdown();
    }

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
