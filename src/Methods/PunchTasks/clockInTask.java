package Methods.PunchTasks;

import java.util.Timer;
import java.util.TimerTask;

public class clockInTask {

    private static int seconds = 0;
    private static Timer timer;

    public static void clockIn() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockInTask(), 1000, 1000);
    }

    public static void clockInStop() {
        timer.cancel();
    }

    public static int getSeconds() {
        return seconds;
    }

    static class ClockInTask extends TimerTask {
        @Override
        public void run() {
            seconds++;
        }
    }
}