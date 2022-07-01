package com.laizhw.demo.thread.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class CompletableFutureAPIDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });
        // 会抛出异常
        // System.out.println(completableFuture.get());
        // 超时抛出异常
        // System.out.println(completableFuture.get(400, TimeUnit.MILLISECONDS));
        // 不会抛出异常
        // System.out.println(completableFuture.join());

        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 计算完返回计算值，没有计算完返回给定值
        // System.out.println(completableFuture.getNow("xxx"));
        // 计算完成返回 false 和 计算值，计算没有完成返回 true 和 给定值
        System.out.println(completableFuture.complete("completeValue") + "\t" + completableFuture.join());


    }
}
