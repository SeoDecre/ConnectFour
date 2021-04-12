package stages.game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Platform.exit;

public class GameController implements Initializable {

    private int width;
    private int height;
    private int startX;
    private int startY;

    @FXML private Button Btn_PlayAgain;
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
        drawBoard();
    }

    private void drawBoard() {
        height = (int) Cnv_Board.getWidth() / COLUMNS;
        width = (height - 2 * DELTA);

        startX = (int) (Cnv_Board.getWidth() - COLUMNS * height) / 2 + DELTA;
        startY = (int) (Cnv_Board.getHeight() - ROWS * width) / 2 + DELTA;

        GraphicsContext gc = Cnv_Board.getGraphicsContext2D();
        gc.setFill(Color.RED);
        int x, y;

        for (int i = 0; i < COLUMNS; i++) {
            for (int j = 0; j < ROWS; j++) {
                x = startX + i * width;
                y = startY + j * width;
                gc.fillOval(x, y, width, width);
            }
        }
    }

    @FXML public void makeMove(MouseEvent event) {
        Lbl_RedPlayerName.setText(String.valueOf((int)event.getX()));
        Lbl_YellowPlayerName.setText(String.valueOf(xToColumn(event.getX())));
    }
    private int xToColumn(double x) {
        return ((int)x-startX)/height;
    }

    @FXML public void quit(ActionEvent e) {
        exit();
    }

}