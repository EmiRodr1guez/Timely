package Methods;

import java.util.Timer;
import java.util.TimerTask;

public class clockInTask {

    private static int seconds = 0;
    public static double clockIn() {
        Timer timer = new Timer();

        // Figure out how to reduce memory usage by allowing back-end loading.
        timer.scheduleAtFixedRate(new ClockInTask(), 1000, 1000);

        // Allow the timer to run until the user decides to exit. Also displays warning
        System.out.println(ansiColors.BLUE + ansiColors.BLACK_BACKGROUND + "Clocked In. Press Enter to exit. Minimize this screen to ensure " +
                "you do not accidentally stop." + ansiColors.RESET);
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

        double decimalTimeWorked = hours + (minutes / 60.0) + (remainingSeconds / 60.0);


        System.out.printf( ansiColors.GREEN + ansiColors.BLACK_BACKGROUND + "Had a good shift? You were at work for: %d hours " +
                "and %d minutes%n", hours, minutes);
        System.out.print(ansiColors.RESET);



return decimalTimeWorked;
    }

    // Second counter
    static class ClockInTask extends TimerTask {
        @Override
        public void run() {
            seconds++;
        }
    }
}
