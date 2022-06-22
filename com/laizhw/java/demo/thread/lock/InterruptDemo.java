package demo.thread.lock;

import java.util.concurrent.atomic.AtomicBoolean;

public class InterruptDemo {

    static volatile boolean isStop = false;
    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "\t isInterrupted() 被修改位 true，程序停止");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "\t hello isInterrupted()");
            }
        }, "t1");
        t1.start();

        try { Thread.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(t1::interrupt, "t2").start();

    }

    private static void m2() {
        new Thread(() -> {
            while (true) {
                if (atomicBoolean.get()) {
                    System.out.println(Thread.currentThread().getName() + "\t atomicBoolean 被修改位 true，程序停止");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "\t hello atomicBoolean");
            }
        }, "t1").start();

        try { Thread.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() -> atomicBoolean.set(true), "t2").start();
    }

    private static void m1() {
        new Thread(() -> {
            while (true) {
                if (isStop) {
                    System.out.println(Thread.currentThread().getName() + "\t isStop 被修改位 true，程序停止");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "\t hello volatile");
            }
        }, "t1").start();

        try { Thread.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() -> isStop = true, "t2").start();
    }
}
