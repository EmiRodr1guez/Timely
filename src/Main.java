import Methods.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean clockIn;
        boolean savePunch;
        Scanner scnr = new Scanner(System.in);

        System.out.println("Would you like to Clock In?");
        clockIn = scnr.nextBoolean();

        if (clockIn) {
            userTimeAndDate.timeAndDate();
            double decimalTimeWorked = clockInTask.clockIn();
            String punchOutTime = clockOut.timeAndDateOut(); // Capture punch out time

            System.out.println("Want to save this punch?");
            savePunch = scnr.nextBoolean();
            if (savePunch) {
                SaveUserPunches.savePunches(savePunch, decimalTimeWorked); // Pass both parameters to savePunches
            }
        } else {
            System.out.println("Closing. See you next Shift.");
            System.exit(0);
        }
    }
}
