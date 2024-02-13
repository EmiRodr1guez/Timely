package Methods.PunchTasks;
import java.sql.*;


public class SaveUserPunches {
    public static void savePunchesToDB(String iduser, String sqlTimeIn, String sqlTimeOut, String sqlDate, double decimalTimeWorked){
        try {
            // Establish connection to the database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/savepunch", // JDBC URL
                    "root", // Database username
                    "Rodr1guezEmi123..d" // Database password
            );

            // Create a prepared statement with parameterized query
            String insertQuery = "INSERT INTO punches (iduser, sqlTimeIn, sqlTimeOut, sqlDate, decimal_time_worked) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            //          preparedStatement.setString(1, sessionId); // Set the value for iduser
            preparedStatement.setDouble(2, decimalTimeWorked); // Set the value for decimal_time_worked

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

    public static boolean savePunches(String iduser, String sqlTimeIn, String sqlTimeOut, String sqlDate, boolean savePunch, double decimalTimeWorked) {
        if (savePunch) {
            SaveUserPunches.savePunchesToDB(iduser, sqlTimeIn, sqlTimeOut, sqlDate, decimalTimeWorked);
            return true;
        } else {
            return false;
        }
    }
}
