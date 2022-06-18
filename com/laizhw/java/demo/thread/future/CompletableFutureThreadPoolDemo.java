package demo.thread.future;

import java.util.concurrent.*;

public class CompletableFutureThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        try {
            CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
                try { Thread.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println("1号任务 " + Thread.currentThread().getName());
                return 1;
            }, threadPool).thenRunAsync(() -> {
                try { Thread.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println("2号任务 " + Thread.currentThread().getName());
            },threadPool).thenRunAsync(() -> {
                try { Thread.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println("3号任务 " + Thread.currentThread().getName());
            },threadPool).thenRunAsync(() -> {
                try { Thread.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println("4号任务 " + Thread.currentThread().getName());
            },threadPool);
            System.out.println(completableFuture.get(1, TimeUnit.SECONDS));
            System.out.println("--- " + Thread.currentThread().getName() + " ---\n");
        } finally {
            threadPool.shutdown();
        }
        
    }
}
