package Methods.PunchTasks.microTasks;

import userConstructor.ansiColors;
import java.time.LocalTime;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


// Gets userConstructor.user current Formatted date and Time.
public class userTimeOut {
    public static String sqlTimeOut() {
        LocalTime timeOfPunch = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String sqlTimeOut = timeOfPunch.format(formatter);

        return sqlTimeOut;
    }
}

