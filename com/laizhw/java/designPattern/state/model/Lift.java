package designPattern.state.model;

import designPattern.state.ILift;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : Lift
 */
public class Lift implements ILift {


    private int state;

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void open() {
        switch (this.state) {
            case CLOSING_STATE:
            case STOPPING_STATE:
                this.openWithoutLogic();
                this.setState(OPENING_STATE);
                break;
            case OPENING_STATE:
            case RUNNING_STATE:
                break;
        }
    }

    @Override
    public void close() {

        switch (this.state) {
            case OPENING_STATE:
                this.closeWithoutLogic();
                this.setState(CLOSING_STATE);
                break;
            case CLOSING_STATE:
            case STOPPING_STATE:
            case RUNNING_STATE:
                break;
        }
    }

    @Override
    public void run() {
        switch (this.state) {
            case OPENING_STATE:
            case RUNNING_STATE:
                break;
            case CLOSING_STATE:
            case STOPPING_STATE:
                this.runWithoutLogic();
                this.setState(RUNNING_STATE);
                break;
        }
    }

    @Override
    public void stop() {
        switch (this.state) {
            case OPENING_STATE:
            case STOPPING_STATE:
                break;
            case CLOSING_STATE:
            case RUNNING_STATE:
                this.stopWithoutLogic();
                this.setState(CLOSING_STATE);
                break;
        }
    }


    private void closeWithoutLogic() {
        System.out.println("电梯门关闭...");
    }

    private void openWithoutLogic() {
        System.out.println("电梯门开启...");
    }

    private void runWithoutLogic() {
        System.out.println("电梯上下跑起来...");
    }

    private void stopWithoutLogic() {
        System.out.println("电梯停止了...");
    }
}
