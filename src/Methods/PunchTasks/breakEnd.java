package Methods.PunchTasks;

import userConstructor.ansiColors;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class breakEnd {
    public static String breakEndExecute() {
        breakIn.breakInStop();


        int seconds_break = breakIn.getSeconds();
        int hours_break = seconds_break / 3600;
        int remainingSeconds_break = seconds_break % 3600;
        int minutes_break = remainingSeconds_break / 60;

        String totalBreakTime = String.format("%02d:%02d", hours_break, minutes_break);
        return totalBreakTime;
    }
}
