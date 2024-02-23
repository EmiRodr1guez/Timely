package Methods.SessionIDs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class retrieveSessionID {

    public static String getSessionID(Connection connection, String username, String email) {
        String sessionId = null;

        try {
            // Create a SELECT query to retrieve the session ID based on username and email
            String selectQuery = "SELECT iduser FROM user WHERE username = ? AND email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            // If a record is found, retrieve the session ID
            if (resultSet.next()) {
                sessionId = resultSet.getString("iduser");
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sessionId; // Return the retrieved session ID (or null if not found)
    }
}
