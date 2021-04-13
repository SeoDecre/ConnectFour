package stages.game;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import stages.primary.PrimaryController;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Platform.exit;

public class GameController implements Initializable {

    @FXML private Button Btn_GiveUp;
    @FXML private Button Btn_Quit;
    @FXML private Label Lbl_RedPlayerName;
    @FXML private Label Lbl_YellowPlayerName;
    @FXML private Label Lbl_RedPlayerScore;
    @FXML private Label Lbl_YellowPlayerScore;
    @FXML private Label Lbl_GameTime;
    @FXML private Canvas Cnv_Board;

    private static final char COLUMNS = 7;
    private static final char ROWS = 6;
    private static final char DELTA = 4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Cnv_Board.setWidth(500);
        Cnv_Board.setHeight(500);
    }


    /**
     * Button hover animation
     */
    @FXML public void giveUpButtonHoverAnimation() {
        ScaleTransition scale = new ScaleTransition(Duration.millis(100), Btn_GiveUp);
        scale.setToX(1.1);
        scale.setToY(1.1);
        scale.play();
    }

    /**
     * Button exit animation
     */
    @FXML public void giveUpButtonReleasedAnimation() {
        ScaleTransition scale = new ScaleTransition(Duration.millis(100), Btn_GiveUp);
        scale.setToX(1.0);
        scale.setToY(1.0);
        scale.play();
    }

    @FXML public void quit() {
        exit();
    }

}