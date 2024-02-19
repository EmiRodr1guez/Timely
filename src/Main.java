import javafx.stage.StageStyle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application{

    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        launch(args);
      /*  boolean clockIn;
        boolean savePunch;
        String sessionId = null;
        Scanner scnr = new Scanner(System.in);
        Connection connection = null; // Initialize the connection variable outside the try-catch block

        try {
            // Establish the database connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/savepunch", // JDBC URL
                    "root", // Database username
                    "Rodr1guezEmi123..d" // Database password
            );

            // Placeholder for user input
            System.out.println("What is your e-mail and username?");
            System.out.print("Email: ");
            String email = scnr.nextLine();
            System.out.print("Username: ");
            String username = scnr.nextLine();

            user user = new user(username, email, sessionId);

            // Retrieve session ID if exists
            sessionId = retrieveSessionID.getSessionID(connection, username, email);

            // Check if the user has a session ID
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
                    sessionId = generatedSessionId;
                    user currentUser = new user(username, email, sessionId);
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

        // Clock in sequence
        if (clockIn) {
            // Retrieve current time and date
            userTimeAndDate.timeAndDate();
            // Perform clock in task
            String timeWorked = clockOut.handleClockOut();
            // Capture punch out time
            String punchOutTime = clockOut.timeAndDateOut();
            // Ask user if they want to save the punch
            System.out.println(ansiColors.GREEN + ansiColors.BLACK_BACKGROUND + "Want to save this punch?" + ansiColors.RESET);
            savePunch = scnr.nextBoolean();
            if (savePunch) {
                // Save the punch to the database
                SaveUserPunches.savePunches(sessionId, punchOutTime, punchOutTime, userDate.sqlDate(), true, Double.parseDouble(timeWorked));
            }
        } else {
            System.out.println("Closing. See you next Shift.");
            System.exit(0);

        }
        */
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loginPage.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
}
