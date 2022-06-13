package demo.future;

import com.google.common.base.Stopwatch;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureAPIlDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final Logger log = Logger.getLogger(FutureAPIlDemo.class);
        Stopwatch watch = Stopwatch.createStarted();

        log.info("--- 测试开始 ---");

        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "\t--- come in ---");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "futureTask1 over";
        });
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();

        System.out.println(Thread.currentThread().getName() + "\t---main over---");

        // futureTask.get() 会阻塞进程，抛出异常
        while (true) {
            if (futureTask.isDone()) {
                System.out.println(futureTask.get());
                break;
            } else {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("正在处理中");
            }
        }

        watch.stop();
        log.info("--- 测试结束 --- 用时：" + watch.elapsed(TimeUnit.MILLISECONDS));

    }
}
