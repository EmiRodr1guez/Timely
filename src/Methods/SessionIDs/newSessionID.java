package Methods.SessionIDs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class newSessionID {

    public static String setSessionID(Connection connection, String salt, String username, String email) {

        try {
            String userId = createSessionId.getSaltString(); // Assuming getSaltString() generates a randomly generated string

            String insertQuery = "INSERT INTO user (iduser, username, email) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();

            // Close the PreparedStatement after use, but keep the connection open as it's passed from outside
            preparedStatement.close();

            return userId; // Return the generated userId
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }
}



