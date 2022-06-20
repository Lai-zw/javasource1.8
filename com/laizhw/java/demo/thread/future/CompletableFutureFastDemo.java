package demo.thread.future;

import java.util.concurrent.*;

public class CompletableFutureFastDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        CompletableFuture<String> playA = CompletableFuture.supplyAsync(() -> {
            System.out.println("A come in");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "play A";
        });
        CompletableFuture<String> playB = CompletableFuture.supplyAsync(() -> {
            System.out.println("B come in");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "play B";
        });

        CompletableFuture<String> result = playA.applyToEither(playB, (f) -> f + " is winner");

        System.out.println(Thread.currentThread().getName() + "\t ---" + result.join());

    }
}
