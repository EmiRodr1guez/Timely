package Login;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
import java.util.Objects;


public class REGISTER_CONTROLLER {
    @FXML
    private Label registrationMethodLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Button cancelButton;
    @FXML
    private Label confirmPasswordLabel;

    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }


    public void registerButtonOnAction(ActionEvent e) throws IOException {
        if (passwordPasswordField.getText().equals(confirmPasswordField.getText())) {
            registerUser(e);
        } else {
            confirmPasswordLabel.setText("Passwords do not match. 👎");
        }
    }

    public void registerUser(ActionEvent event) throws IOException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();

        String insertFields = "INSERT INTO useraccounts (username, password) VALUES ('";
        String insertValues = username + "','" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            registrationMethodLabel.setText("Successfully Registered! 🎉");
            Parent root = FXMLLoader.load(getClass().getResource("../app.fxml"));

            // Create a new scene with root and set the stage
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }





    }

