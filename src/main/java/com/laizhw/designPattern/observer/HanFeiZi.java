package com.laizhw.designPattern.observer;

import java.util.Observable;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : HanFeiZi
 */
public class HanFeiZi extends Observable {

    public void haveBreakfast() {
        System.out.println("韩非子:开始吃饭了...");
        super.setChanged();
        this.notifyObservers("韩非子在吃饭");
    }

    //韩非子开始娱乐了,古代人没啥娱乐，你能想到的就那么多
    public void haveFun() {
        System.out.println("韩非子:开始娱乐了...");
        super.setChanged();
        this.notifyObservers("韩非子在娱乐");
    }

}
