package Login;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private static final String CONFIG_FILE = "Login/resources/config/config.properties";


    public static String getDatabaseUser() {
        Properties prop = new Properties();
        try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                System.err.println("Unable to find " + CONFIG_FILE);
                return null;
            }
            prop.load(input);
            return prop.getProperty("databaseUser");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getDatabasePassword() {
        Properties prop = new Properties();
        try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                System.err.println("Unable to find " + CONFIG_FILE);
                return null;
            }
            prop.load(input);
            return prop.getProperty("databasePassword");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
