package Login;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "users";
        String databaseUser = "root";
        String databasePassword = "Rodr1guezEmi123..d";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser, databasePassword);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }
}
