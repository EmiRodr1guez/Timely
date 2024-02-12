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

            // Create a prepared statement with parameterized query
            String insertQuery = "INSERT INTO punches (decimal_time_worked) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set the double value as parameter
            preparedStatement.setDouble(1, decimalTimeWorked);

            // Execute the INSERT statement
            int rowsAffected = preparedStatement.executeUpdate();

            // Print the number of rows affected (optional)
            System.out.println("Rows affected: " + rowsAffected);

            // Close the resources
            preparedStatement.close();
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
