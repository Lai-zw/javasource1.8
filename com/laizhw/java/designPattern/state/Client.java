package designPattern.state;

import designPattern.state.model.ClosingState;
import designPattern.state.model.Context;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : Client
 */
public class Client {
    public static void main(String[] args) {
        // ILift lift = new Lift();
        //
        // lift.setState(ILift.CLOSING_STATE);
        //
        // lift.open();
        // lift.close();
        // lift.run();
        // lift.stop();

        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();

    }
}
