package demo.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        long startTime = System.currentTimeMillis();

        FutureTask<String> futureTask1 = new FutureTask<>(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "futureTask1 over";
        });
        threadPool.submit(futureTask1);

        FutureTask<String> futureTask2 = new FutureTask<>(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "futureTask1 over";
        });
        threadPool.submit(futureTask2);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " - 返回值位：" + futureTask1.get());
        System.out.println(Thread.currentThread().getName() + " - 返回值位：" + futureTask2.get());

        long endTime = System.currentTimeMillis();
        System.out.println("程序结束，用时为: " + (endTime - startTime) + "毫秒");

        threadPool.shutdown();
    }

    private static void m1() {
        long startTime = System.currentTimeMillis();


        long endTime = System.currentTimeMillis();
        System.out.println("--- costTime: " + (endTime - startTime) + "毫秒");
    }
}
