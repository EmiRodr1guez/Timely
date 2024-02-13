package Methods.PunchTasks;

import userConstructor.ansiColors;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class clockOut {
    public static String timeAndDateOut() {
        LocalTime timeOfPunch = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        String formattedTime = timeOfPunch.format(formatter);
        SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy");

        System.out.println(ansiColors.RED + ansiColors.BLACK_BACKGROUND + "You have clocked out at: " + formattedTime +
                ansiColors.RESET);
        System.out.println("");
        return formattedTime;
    }
}
