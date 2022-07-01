package com.laizhw.demo.thread.future;

import java.util.concurrent.*;

public class CompletableFutureAPI3Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        // thenRun Runnable 接口，新起一个线程，不需要上一步返回的结果
        // thenApply Function 类型接口，一个输入，一个输出， 需要上一步的结果，无法处理异常，中断执行
        // handle BiFunction 类型接口，两个输入，一个输出， 需要上一步的结果，可以处理异常， 继续执行
        // thenAccept Consumer 类型接口，无返回值
        try {
            CompletableFuture.supplyAsync(() -> {
                System.out.println("--- first step ---");
                return 1;
            }, threadPool).handle((f, e) -> {
                System.out.println("--- second step ---");
                return f + 2;
            }).thenApply((f) -> {
                System.out.println("--- third step ---");
                return f + 3;
            }).thenAccept(System.out::println);

            System.out.println("--- " + Thread.currentThread().getName() + " ---\n");
        } finally {
            threadPool.shutdown();
        }

        System.out.println(CompletableFuture.supplyAsync(() -> "A").thenRun(() -> {}).join() + "\n");
        System.out.println(CompletableFuture.supplyAsync(() -> "A").thenApply((f) -> f + "-B").join() + "\n");
        System.out.println(CompletableFuture.supplyAsync(() -> "A").thenAccept(System.out::println).join() + "\n");

    }
}
