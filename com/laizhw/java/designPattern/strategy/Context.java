package designPattern.strategy;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : Context
 */
public class Context {

    private final IStrategy strategy;

    // 构造函数
    public Context(IStrategy strategy){
        this.strategy = strategy;
    }

    public void operate() {
        this.strategy.operate();
    }

}
