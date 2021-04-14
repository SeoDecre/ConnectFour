package stages.game;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import stages.primary.PrimaryController;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Platform.exit;

public class GameController implements Initializable {

    @FXML private Label Lbl_GameTime;
    @FXML private Button Btn_GiveUp;
    @FXML private Label Lbl_RedPlayerName;
    @FXML private Label Lbl_YellowPlayerName;
    @FXML private Label Lbl_RedPlayerScore;
    @FXML private Label Lbl_YellowPlayerScore;
    @FXML private Canvas Cnv_Board;

    private int columnWidth;
    private int startX;
    private int startY;

    private static final char COLUMNS = 7;
    private static final char ROWS = 6;
    private static final char DELTA = 4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Lbl_RedPlayerName.setText(PrimaryController.getRedNickname());
        Lbl_YellowPlayerName.setText(PrimaryController.getYellowNickname());
        Cnv_Board.setWidth(500);
        Cnv_Board.setHeight(500);
        drawBoard();
    }

    /**
     * Method used to draw the board
     */
    private void drawBoard() {
        columnWidth = (int) Cnv_Board.getWidth()/COLUMNS;
        int width = (columnWidth-2*DELTA);

        startX = (int) (Cnv_Board.getWidth()-COLUMNS*columnWidth)/2+DELTA;
        startY = (int) (Cnv_Board.getHeight()-ROWS*columnWidth)/2+DELTA;

        GraphicsContext gc = Cnv_Board.getGraphicsContext2D();

        gc.setFill(Paint.valueOf("#7285FF"));
        gc.fillRect(0,0, Cnv_Board.getWidth(), Cnv_Board.getHeight());
        gc.setFill(Color.WHITE);

        int x,y;
        for (int i = 0; i < COLUMNS; i++) {
            for (int j = 0; j < ROWS; j++) {
                x = startX+i*columnWidth;
                y = startY+j*columnWidth;
                gc.fillOval(x, y, width, width);
            }

        }
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

    /**
     * Method called to quit
     */
    @FXML public void quit() {
        exit();
    }

}