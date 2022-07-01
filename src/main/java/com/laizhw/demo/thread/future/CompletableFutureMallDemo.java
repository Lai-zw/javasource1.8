package com.laizhw.demo.thread.future;

import com.google.common.base.Stopwatch;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CompletableFutureMallDemo {

    static List<NetMall> list = Arrays.asList(
            new NetMall("京东"),
            new NetMall("当当"),
            new NetMall("淘宝"),
            new NetMall("拼多多"),
            new NetMall("天猫")
    );

    /**
     * 挨个获取价格
     *
     * @param list        商店列表
     * @param productName 商品名称
     * @return 价格列表
     */
    public static List<String> getPrice(List<NetMall> list, String productName) {
        return list.stream()
                .map(netMall -> String.format(productName + " in %s price is %.2f ", netMall.getNetMallName(), netMall.calcPrice(productName)))
                .collect(Collectors.toList());

    }

    public static List<String> getPriceByCompletableFuture(List<NetMall> list, String productName) {
        return list.stream()
                .map(netMall ->
                        CompletableFuture.supplyAsync(() ->
                                String.format(productName + " in %s price is %.2f ", netMall.getNetMallName(), netMall.calcPrice(productName))))
                .collect(Collectors.toList())
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {

        Stopwatch watch = Stopwatch.createStarted();
        System.out.println("--- 测试开始 ---\n");

        List<String> priceList = getPrice(list, "mysql");
        for (String price : priceList) {
            System.out.println(price);
        }

        // watch.stop();
        System.out.println("\n--- 测试结束 --- 用时：" + watch.elapsed(TimeUnit.MILLISECONDS) + "\n");

        watch.reset();
        watch.start();

        System.out.println("--- 测试开始 ---\n");

        List<String> priceList1 = getPriceByCompletableFuture(list, "mysql");
        for (String price : priceList1) {
            System.out.println(price);
        }

        System.out.println("\n--- 测试结束 --- 用时：" + watch.elapsed(TimeUnit.MILLISECONDS) + "\n");
        watch.stop();
    }

}

class NetMall {
    @Getter
    private final String netMallName;

    public NetMall(String netMallName) {
        this.netMallName = netMallName;
    }

    public Double calcPrice(String productName) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }
}
