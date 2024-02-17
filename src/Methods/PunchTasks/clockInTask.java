// clockInTask.java
package Methods.PunchTasks;

import java.util.Timer;
import java.util.TimerTask;

public class clockInTask {

    private static int seconds = 0;
    public static void clockIn() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new ClockInTask(), 1000, 1000);
    }

    static class ClockInTask extends TimerTask {
        @Override
        public void run() {
            seconds++;
        }
    }

    public static int getSeconds() {
        return seconds;
    }
}