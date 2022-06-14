package demo.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureBuildDemo {
    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            // 无返回值
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            }, threadPool);
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            System.out.println("completableFuture.get() = " + completableFuture.get());

            // 有返回值
            CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                return "hello supplyAsync";
            }, threadPool);
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            System.out.println("completableFuture.get() = " + completableFuture1.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
