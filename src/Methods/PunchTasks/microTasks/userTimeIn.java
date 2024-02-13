package Methods.PunchTasks.microTasks;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class userTimeIn {
    String timeOfClockIn;
    public static String timeSQL() {
        LocalTime timeOfPunch = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String sqlTimeIn = timeOfPunch.format(formatter);
return sqlTimeIn;
    }
}
