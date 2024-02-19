package Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.sql.Connection;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;


public class LOGIN_CONTROLLER {

    @FXML
    private Button cancelButton;

    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button registerButton;

    public void registerButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    public void loginButtonAction(ActionEvent e) throws IOException {
        if (!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {
            loginMessageLabel.setText("Logging in... ⏳");
            validateLogin();
            Parent root = FXMLLoader.load(getClass().getResource("../app.fxml"));

        } else {
            loginMessageLabel.setText("Rats! One or more of the fields are missing. 😔");
        }

    }

    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM UserAccounts WHERE username = '" + usernameTextField + "' AND password = '" + passwordPasswordField + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    loginMessageLabel.setText("Login successful! 😊");
                } else {
                    loginMessageLabel.setText("Invalid login. Please try again. 😔");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}