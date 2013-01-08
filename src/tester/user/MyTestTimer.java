package tester.user;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 09.01.13
 * Time: 1:03
 * To change this template use File | Settings | File Templates.
 */
public class MyTestTimer implements TestTimer{

    private int testTimeSeconds;
    private long testTimeSecondsLeft;

    @Override
    public long update(String currTime, String totalTime) {
        return 0;
    }

    @Override
    public void stopTest(UIController controller) {
        controller.stopTest();
    }

    public long getCurrTime() {
        return System.currentTimeMillis();
    }

    public void setTestTimeSeconds(int seconds) {
        this.testTimeSeconds = seconds;
    }

    public long getTestTimeSecondsLeft() {
        return testTimeSecondsLeft;
    }

    public void startCounting() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                testTimeSecondsLeft--;
            }
        }, testTimeSeconds *1000);
    }
}
