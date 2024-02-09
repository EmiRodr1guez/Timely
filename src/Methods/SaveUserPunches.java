package Methods;
import java.sql.*;


public class SaveUserPunches {
    public static void savePunchesToDB(double decimalTimeWorked){
        try {
            // Establish connection to the database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/savepunch", // JDBC URL
                    "root", // Database username
                    "Rodr1guezEmi123..d" // Database password
            );

            // Create a statement
            Statement statement = connection.createStatement();

            // Construct an INSERT statement to save punch data
            String insertQuery = String.format(
                    "INSERT INTO punches (decimal_time_worked) VALUES (%f)", decimalTimeWorked
            );

            // Execute the INSERT statement
            int rowsAffected = statement.executeUpdate(insertQuery);

            // Print the number of rows affected (optional)
            System.out.println("Rows affected: " + rowsAffected);

            // Close the resources
            statement.close();
            connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean savePunches(boolean savePunch, double decimalTimeWorked) {
        if (savePunch) {
            SaveUserPunches.savePunchesToDB(decimalTimeWorked);
            return true;
        } else {
            return false;
        }
    }
}
