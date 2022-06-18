package demo.thread.future;

import java.util.concurrent.*;

public class CompletableFutureAPI2Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        // thenApply Function 类型接口，一个输入，一个输出， 无法处理异常，中断执行
        // handle BiFunction 类型接口，两个输入，一个输出， 可以处理异常， 继续执行
        try {
            CompletableFuture.supplyAsync(() -> {
                try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println("--- first step ---");
                return 1;
            }, threadPool).handle((f, e) -> {
                System.out.println("--- second step ---");
                return f + 2;
            }).thenApply((f) -> {
                System.out.println("--- third step ---");
                return f + 3;
            }).whenComplete((v, e) -> {
                if (e == null) {
                    System.out.println("--- 计算结果为: " + v);
                }
            }).exceptionally((e) -> {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return null;
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

        System.out.println("--- " + Thread.currentThread().getName() + " ---");

    }
}
