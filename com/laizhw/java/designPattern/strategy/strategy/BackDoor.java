package designPattern.strategy.strategy;

import designPattern.strategy.IStrategy;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : BackDoor
 */
public class BackDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力");
    }
}
