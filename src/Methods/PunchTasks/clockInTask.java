package Methods.PunchTasks;

import java.util.Timer;
import java.util.TimerTask;
import Methods.Shift;

public class clockInTask {

    private static int seconds = 0;
    private static Timer timer;
    public static Shift shift = new Shift();

    public static void clockIn() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockInTask(), 1000, 1000);
        shift.clockIn();
    }

    public static void clockInStop() {
        shift.clockOut();
        //timer.cancel();
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