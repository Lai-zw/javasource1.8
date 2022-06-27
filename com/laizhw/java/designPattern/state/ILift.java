package designPattern.state;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : ILift
 * @createTime : 2022/6/27 13:47
 */
public interface ILift {

    // 电梯的四个状态
    public final static int OPENING_STATE = 1; //门敞状态
    public final static int CLOSING_STATE = 2; //门闭状态
    public final static int RUNNING_STATE = 3; //运行状态
    public final static int STOPPING_STATE = 4; //停止状态；

    // 设置电梯的状态
    public void setState(int state);

    void open();
    void close();
    void run();
    void stop();

}
