import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXML;

public class Controller {
    @FXML
    private Button btn_home;

    @FXML
    private Label timelyLabel; // Inject the timelyLabel from FXML

    @FXML
    public void handleHomeButtonClick() {
        System.out.println("Clicked and working");
    }
}
