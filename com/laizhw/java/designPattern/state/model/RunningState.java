package designPattern.state.model;

import designPattern.state.LiftState;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : ClosingState
 */
public class RunningState extends LiftState {
    @Override
    public void open() {
    }

    @Override
    public void close() {
    }

    @Override
    public void run() {
        System.out.println("电梯上下跑...");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.getLiftState().stop();
    }
}
