import Methods.*;
import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";


    public static void main(String[] args) {
        boolean clockIn;
        boolean savePunch;
        Scanner scnr = new Scanner(System.in);
        System.out.println(ansiColors.BLACK_BACKGROUND + ansiColors.CYAN + "                                ___           ___                               \n" +
                "                               /\\  \\         /\\__\\                              \n" +
                "      ___         ___         |::\\  \\       /:/ _/_                       ___   \n" +
                "     /\\__\\       /\\__\\        |:|:\\  \\     /:/ /\\__\\                     /|  |  \n" +
                "    /:/  /      /:/__/      __|:|\\:\\  \\   /:/ /:/ _/_   ___     ___     |:|  |  \n" +
                "   /:/__/      /::\\  \\     /::::|_\\:\\__\\ /:/_/:/ /\\__\\ /\\  \\   /\\__\\    |:|  |  \n" +
                "  /::\\  \\      \\/\\:\\  \\__  \\:\\~~\\  \\/__/ \\:\\/:/ /:/  / \\:\\  \\ /:/  /  __|:|__|  \n" +
                " /:/\\:\\  \\      ~~\\:\\/\\__\\  \\:\\  \\        \\::/_/:/  /   \\:\\  /:/  /  /::::\\  \\  \n" +
                " \\/__\\:\\  \\        \\::/  /   \\:\\  \\        \\:\\/:/  /     \\:\\/:/  /   ~~~~\\:\\  \\ \n" +
                "      \\:\\__\\       /:/  /     \\:\\__\\        \\::/  /       \\::/  /         \\:\\__\\\n" +
                "       \\/__/       \\/__/       \\/__/         \\/__/         \\/__/           \\/__/");


        System.out.println(ansiColors.GREEN + ansiColors.BLACK_BACKGROUND + "Would you like to Clock In?" + ansiColors.RESET);
        System.out.println("");
        clockIn = scnr.nextBoolean();

        if (clockIn) {
            userTimeAndDate.timeAndDate();
            System.out.println("");
            double decimalTimeWorked = clockInTask.clockIn();
            System.out.println("");
            String punchOutTime = clockOut.timeAndDateOut(); // Capture punch out time

            System.out.println(ansiColors.GREEN + ansiColors.BLACK_BACKGROUND + "Want to save this punch?" + ansiColors.RESET);
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
