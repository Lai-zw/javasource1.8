package com.laizhw.designPattern.observer;

import com.laizhw.designPattern.observer.model.LiSi;
import com.laizhw.designPattern.observer.model.LiuSi;
import com.laizhw.designPattern.observer.model.WangSi;

import java.util.Observer;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : Client
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        // LiSi liSi = new LiSi();
        // HanFeiZi hanFeiZi = new HanFeiZi();
        //
        // Watch watchBreakfast = new Watch(hanFeiZi, liSi, "breakfast");
        // watchBreakfast.start();
        //
        // Watch watchFun = new Watch(hanFeiZi, liSi, "fun");
        // watchFun.start();
        //
        // Thread.sleep(1000);
        // //主线程等待1秒后后再往下执行
        // hanFeiZi.haveBreakfast();
        // //韩非子娱乐了
        // Thread.sleep(1000);
        // hanFeiZi.haveFun();

        HanFeiZi hanFeiZi = new HanFeiZi();

        //三个观察者产生出来
        Observer liSi = new LiSi();
        Observer wangSi = new WangSi();
        Observer liuSi = new LiuSi();

        //我们后人根据历史，描述这个场景，有三个人在观察韩非子
        hanFeiZi.addObserver(liSi);
        hanFeiZi.addObserver(wangSi);
        hanFeiZi.addObserver(liuSi);

        hanFeiZi.haveBreakfast();
        hanFeiZi.haveFun();
    }
}
