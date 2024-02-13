import java.sql.*;
import java.util.Scanner;

import Methods.PunchTasks.SaveUserPunches;
import Methods.PunchTasks.clockInTask;
import Methods.PunchTasks.clockOut;
import Methods.PunchTasks.microTasks.*;
import Methods.PunchTasks.userTimeAndDate;
import Methods.SessionIDs.createSessionId;
import Methods.SessionIDs.newSessionID;
import Methods.SessionIDs.retrieveSessionID;
import userConstructor.user;
import userConstructor.ansiColors;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        boolean clockIn;
        boolean savePunch;
        boolean userRegistered;
        String sessionId = null;
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

        System.out.println("Do you have an account with us?");
        userRegistered = scnr.nextBoolean();

        Connection connection = null; // Initialize the connection variable outside the try-catch block

        try {
            // Establish the database connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/savepunch", // JDBC URL
                    "root", // Database username
                    "Rodr1guezEmi123..d" // Database password
            );

            //placeholder
            String username = "exampleUser";
            String email = "example@example.com";

            sessionId = retrieveSessionID.getSessionID(connection, username, email);

            // Check if the user has a session ID
            sessionId = retrieveSessionID.getSessionID(connection, username, email);
            if (sessionId != null) {
                System.out.println("You are already logged in. Your session ID is: " + sessionId);
                // Create a user object with the retrieved session ID
                user currentUser = new user(username, email, sessionId);
                // Proceed with other actions, such as logging the user in or continuing with the application flow
            } else {
                System.out.println("You are not logged in. Creating a new session ID for you.");

                // Generate a new session ID and insert it into the database
                String generatedSessionId = newSessionID.setSessionID(connection, createSessionId.getSaltString(), username, email);
                if (!generatedSessionId.isEmpty()) {
                    System.out.println("New session ID generated and assigned to you: " + generatedSessionId);
                    user currentUser = new user(username, email, generatedSessionId);
                    // Proceed with other actions, such as logging the user in or continuing with the application flow
                } else {
                    System.out.println("Failed to generate a new session ID. Please try again later.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(ansiColors.GREEN + ansiColors.BLACK_BACKGROUND + "Would you like to Clock In?" + ansiColors.RESET);
        System.out.println("");
        clockIn = scnr.nextBoolean();

        //Clock in sequence
        if (clockIn) {
            // Retrieve current time and date
            userTimeAndDate.timeAndDate();
            // Perform clock in task
            double decimalTimeWorked = clockInTask.clockIn();
            System.out.println("");
            // Capture punch out time
            String punchOutTime = clockOut.timeAndDateOut();
            // Ask user if they want to save the punch
            System.out.println(ansiColors.GREEN + ansiColors.BLACK_BACKGROUND + "Want to save this punch?" + ansiColors.RESET);
            savePunch = scnr.nextBoolean();
            if (savePunch) {
                // Save the punch to the database
                SaveUserPunches.savePunches(sessionId, punchOutTime, punchOutTime, userDate.sqlDate(), true, decimalTimeWorked);
            }
        } else {
            System.out.println("Closing. See you next Shift.");
            System.exit(0);
        }
    }
}