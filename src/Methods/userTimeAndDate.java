package Methods;

import java.time.LocalTime;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


// Gets user current Formatted date and Time.
public class userTimeAndDate {
    public static void timeAndDate() {
        LocalTime timeOfPunch = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        String formattedTime = timeOfPunch.format(formatter);
        SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy");

        System.out.println(ansiColors.BLUE + ansiColors.BLACK_BACKGROUND + "Today is : " + ft.format(new Date()) +
                " and time is : " + formattedTime + ansiColors.RESET);


    }
}