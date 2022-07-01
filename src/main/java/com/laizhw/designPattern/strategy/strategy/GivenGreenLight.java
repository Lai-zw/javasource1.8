package com.laizhw.designPattern.strategy.strategy;

import com.laizhw.designPattern.strategy.IStrategy;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : BackDoor
 */
public class GivenGreenLight implements IStrategy {
    @Override
    public void operate() {

        System.out.println("求吴国太开个绿灯,放行！");
    }
}
