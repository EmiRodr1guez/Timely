import Methods.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean clockIn;
        Scanner scnr = new Scanner(System.in);

        System.out.println("Would you like to Clock In?");
        clockIn = scnr.nextBoolean();

        if (clockIn) {
            userTimeAndDate.timeAndDate();
            clockInTask.clockIn();
            clockOut.timeAndDateOut();

        } else {
            System.out.println("Closing. See you next Shift.");
            System.exit(0);
        }
    }
}

