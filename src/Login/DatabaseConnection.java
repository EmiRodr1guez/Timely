package Login;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;


public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseUser = DatabaseConfig.getDatabaseUser();
        String databasePassword = DatabaseConfig.getDatabasePassword();
        String url = "jdbc:mysql://18.223.158.247:3306/Timely";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }
}
