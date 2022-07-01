package com.laizhw.designPattern.strategy.strategy;

import com.laizhw.designPattern.strategy.IStrategy;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : BackDoor
 */
public class BlockEnemy implements IStrategy {
    @Override
    public void operate() {

        System.out.println("孙夫人断后，挡住追兵");
    }
}
