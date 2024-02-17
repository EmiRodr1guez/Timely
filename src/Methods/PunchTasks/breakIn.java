package Methods.PunchTasks;

import java.util.Timer;
import java.util.TimerTask;

public class breakIn {

    private static int seconds_break = 0;
    private static Timer timer_break;

    public static void breakInStart() {
        timer_break = new Timer();
        timer_break.scheduleAtFixedRate(new breakInStart(), 1000, 1000);
    }

    public static void breakInStop() {
        timer_break.cancel();
    }

    static class breakInStart extends TimerTask {
        @Override
        public void run() {
            seconds_break++;
        }
    }

    public static int getSeconds() {
        return seconds_break;
    }
}