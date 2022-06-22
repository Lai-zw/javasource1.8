package demo.thread.lock;


import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo {

    public static void main(String[] args) throws InterruptedException {

        // final Logger log = Logger.getLogger(FutureAPIlDemo.class);
        Stopwatch watch = Stopwatch.createStarted();
        // log.info("--- 测试开始 ---");
        System.out.println("--- 测试开始 ---\n");

        Ticket ticket = new Ticket();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5500; i++) {
                ticket.sale();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5500; i++) {
                ticket.sale();
            }
        }, "t2");

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5500; i++) {
                ticket.sale();
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        watch.stop();
        // log.info("--- 测试结束 --- 用时：" + watch.elapsed(TimeUnit.MILLISECONDS));
        System.out.println("\n--- 测试结束 --- 用时：" + watch.elapsed(TimeUnit.MILLISECONDS) + "\n");

    }

}

class Ticket {
    private int number = 5000;
    ReentrantLock lock = new ReentrantLock(true); // 公平
    // ReentrantLock lock = new ReentrantLock(); // 非公平

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第：\t" + (number--) + "\t 还剩下：" + number);
            }
        } finally {
            lock.unlock();
        }
    }
}