package com.laizhw.designPattern.state.model;

import com.laizhw.designPattern.state.LiftState;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : ClosingState
 */
public class OpeningState extends LiftState {
    @Override
    public void open() {
        System.out.println("电梯门开启...");
    }

    @Override
    public void close() {
        super.context.setLiftState(Context.closingState);
        super.context.getLiftState().close();
    }

    @Override
    public void run() {
    }

    @Override
    public void stop() {
    }
}
