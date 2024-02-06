package Methods;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class clockInTask {

    private static int seconds = 0;
    public static void clockIn() {
        Timer timer = new Timer();

        // Figure out how to reduce memory usage by allowing back-end loading.
        timer.scheduleAtFixedRate(new ClockInTask(), 1000, 1000);

        // Allow the timer to run until the user decides to exit. Also displays warning
        System.out.println("Clocked In. Press Enter to exit. Minimize this screen to ensure " +
                "you do not accidentally stop.");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Punch out sequence (TODO: Make it so it also prints in Decimal format.)
        timer.cancel();
        int hours = seconds / 3600;
        int remainingSeconds = seconds % 3600;
        int minutes = remainingSeconds / 60;


        System.out.printf("Had a good shift? You were at work for: %d hours " +
                "and %d minutes%n", hours, minutes);


    }

    // Second counter
    static class ClockInTask extends TimerTask {
        @Override
        public void run() {
            seconds++;
        }
    }
}
