package Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import org.mindrot.jbcrypt.BCrypt;
import java.sql.Statement;
import java.util.Objects;


public class LOGIN_CONTROLLER {

    @FXML
    private Button cancelButton;

    @FXML
    private Button registerButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


    public void registerButtonOnAction(ActionEvent e) throws IOException {
        Stage stage = (Stage) registerButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registerPage.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void loginButtonAction(ActionEvent e) throws IOException {
        if (usernameTextField.getText().length() != 0 && passwordPasswordField.getText().length() != 0) {
            loginMessageLabel.setText("Logging in... ⏳");
            boolean validated = validateLogin();
            System.out.println("Validate? " + validated);
            if (validated) {
                Parent root = FXMLLoader.load(getClass().getResource("../app.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        } else {
            loginMessageLabel.setText("Rats! One or more of the fields are missing. 😔");
        }
    }
    

    public boolean validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        boolean loginSuccessful = false; 
    
        String username = usernameTextField.getText();
        String enteredPassword = passwordPasswordField.getText();
    
        String getPasswordQuery = "SELECT password FROM useraccounts WHERE username = '" + username + "'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(getPasswordQuery);
    
            if (queryResult.next()) {
                String hashedPasswordFromDB = queryResult.getString("password");
                if (BCrypt.checkpw(enteredPassword, hashedPasswordFromDB)) {
                    loginMessageLabel.setText("Login successful! 😊");
                    loginSuccessful = true; 
                } else {
                    loginMessageLabel.setText("Invalid login. Please try again. 😔");
                    System.out.println("UNVERIFIED BUT USER FOUND");
                }
            } else {
                loginMessageLabel.setText("Invalid login. Please try again. 😔");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connectDB != null) {
                    connectDB.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return loginSuccessful; 
    }
    



}