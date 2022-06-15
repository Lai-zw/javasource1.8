package demo.thread.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class CompletableFutureUseDemo {
    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture<Integer> completableFuture = (CompletableFuture<Integer>) CompletableFuture.supplyAsync(() -> {
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                int result = ThreadLocalRandom.current().nextInt(10);
                if (result > 5) {
                    int i = 10 / 0;
                }
                return result;
            }, threadPool).whenComplete((v, e) -> {
                if (e == null) {
                    System.out.println("v = " + v);
                }
            }).exceptionally((e) -> {
                e.printStackTrace();
                System.out.println("e.getCause() = " + e.getCause());
                return null;
            });
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            System.out.println("completableFuture.get() = " + completableFuture.get());

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            threadPool.shutdown();
        }

    }
}
