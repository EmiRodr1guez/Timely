package Methods;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class clockOut {
    public static void timeAndDateOut() {
        LocalTime timeOfPunch = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        String formattedTime = timeOfPunch.format(formatter);
        SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy");

        System.out.println("You have clocked out at : " + formattedTime);
    }
}
