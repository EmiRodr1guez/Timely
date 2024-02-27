package Methods.PunchTasks;


import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class clockOut {
    public static String handleClockOut() {
        clockInTask.clockInStop();


        int seconds = clockInTask.getSeconds();
        int hours = seconds / 3600;
        int remainingSeconds = seconds % 3600;
        int minutes = remainingSeconds / 60;

        //double decimalTimeWorked = hours + (minutes / 60.0) + (remainingSeconds / 60.0); //Commented out.

        String timeWorked = String.format("%02d:%02d", hours, minutes);
        return timeWorked;
    }

    public static String timeAndDateOut() {
        LocalTime timeOfPunch = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        String formattedTime = timeOfPunch.format(formatter);
        SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy");
        return formattedTime;
    }

    public static String totalTimeWorked() {
        int totalSecondsWorked = clockInTask.getSeconds();
        int totalSecondsBreak = breakIn.getSeconds();
        int actualSecondsWorked = totalSecondsWorked - totalSecondsBreak;

        int hours = actualSecondsWorked / 3600;
        int remainingSeconds = actualSecondsWorked % 3600;
        int minutes = remainingSeconds / 60;

        String totalTimeWorked = String.format("%02d:%02d", hours, minutes);
        return totalTimeWorked;
    }
}
