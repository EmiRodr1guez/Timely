import Methods.PunchTasks.breakEnd;
import Methods.PunchTasks.breakIn;
import Methods.PunchTasks.clockInTask;
import Methods.PunchTasks.clockOut;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;

public class Controller {

    private double xOffset = 0;
    private double yOffset = 0;

    // Menu Panel ----------------------------------------------------------------
    @FXML
    private Button btn_home;

    @FXML
    private Button cancelButton;

    // Menu Panel End ------------------------------------------------------------

    //============================================================================
    //============================================================================

    // Clock In Functionality ----------------------------------------------------
    private Button clockInButton;

    @FXML
    public void handleClockInButtonClicked() {
        clockInTask.clockIn();
        System.out.println("Clicked and working");
    }

    @FXML
    public void handleClockOutButtonClicked() {
        clockOut.handleClockOut();
        clockOut.timeAndDateOut();

        handlePushTodaysPunch();

        System.out.println("Clicked and working");
    }

    @FXML
    private Label todayspunch;

    @FXML
    public void handlePushTodaysPunch() {
        String timeWorked = String.valueOf(clockOut.totalTimeWorked());
        todayspunch.setText(timeWorked);
        System.out.println("I got here!");
    }

    @FXML
    public void handleStartBreakButton() {
        breakIn.breakInStart();
        System.out.println("Clicked and working");
    }

    @FXML
    public void handleEndBreakButton() {
        breakIn.breakInStop();
        System.out.println("Clicked and working");
        handlebreakLengthLabel();
    }

    @FXML
    private Label breaklength;

    @FXML
    public void handlebreakLengthLabel() {
        String todaysBreak = String.valueOf(breakEnd.breakEndExecute());
        breaklength.setText(todaysBreak);
        System.out.println("I got here!");
    }
    // Clock In Functionality End ------------------------------------------------

    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    @FXML
    public void handleHomeButtonClick() {
        System.out.println("Clicked and working");
    }

    @FXML
    public void handleMousePressed(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    @FXML
    public void handleMouseDragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);
    }
}