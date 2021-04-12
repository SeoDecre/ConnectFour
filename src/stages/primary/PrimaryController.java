package stages.primary;
import exceptions.InvalidNicknameException;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import static javafx.application.Platform.exit;

public class PrimaryController extends Application {

    // Attributes
    @FXML private Button Btn_Ready;
    @FXML private TextField redTextField;
    @FXML private TextField yellowTextField;
    public static String redNickname;
    public static String yellowNickname;

    // BOH
    @Override
    public void start(Stage stage) { }

    /**
     * Method used to set player's nicknames
     * It manages invalid nicknames by throwing InvalidNicknameException
     */
    @FXML public void submitNicknames() {
        // Invalid nickname characters string
        String invalidCharacters = "^àáâãäåçèéêëìíîïðòóôõöùúûüýÿ!&¿?.<>~\\//*:()[]{}";

        try {
            // Setting up nicknames using inputs
            redNickname = redTextField.getText();
            yellowNickname = yellowTextField.getText();

            // Checking for red nickname empty input
            if (redNickname.equals(""))
                redNickname = "Player 1";
            // Checking for yellow nickname empty input
            if (yellowNickname.equals(""))
                yellowNickname = "Player 2";

            // Checking for equals nicknames
            if (redNickname.equals(yellowNickname)) {
                redTextField.setText("");
                yellowTextField.setText("");
                redTextField.setPromptText("SET DIFFERENT NICKNAMES");
                yellowTextField.setPromptText("SET DIFFERENT NICKNAMES");
                redTextField.setStyle("-fx-prompt-text-fill: #efb078");
                yellowTextField.setStyle("-fx-prompt-text-fill: #efb078");
            }

            // Invalid characters check
            for (char c : invalidCharacters.toCharArray()) {
                // Red check
                if (redNickname.indexOf(c) != -1) {
                    redTextField.setText("");
                    redTextField.setPromptText("INVALID NICKNAME");
                    redTextField.setStyle("-fx-prompt-text-fill: #e78d8e");
                }
                // Yellow check
                if (yellowNickname.indexOf(c) != -1) {
                    yellowTextField.setText("");
                    yellowTextField.setPromptText("INVALID NICKNAME");
                    yellowTextField.setStyle("-fx-prompt-text-fill: #e78d8e");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method used to start the game and switching to the game stage
     * Event activated on Btn_Ready click
     */
    @FXML public void startGame() {
        // Set nicknames on click
        submitNicknames();
        // Switch to game stage

        System.out.println("game started");
    }

    /**
     * Button hover animation
     */
    @FXML public void buttonHoverAnimation() {
        ScaleTransition scale = new ScaleTransition(Duration.millis(100), Btn_Ready);
        scale.setToX(1.1);
        scale.setToY(1.1);
        scale.play();
    }

    /**
     * Button exit animation
     */
    @FXML public void buttonExitAnimation() {
        ScaleTransition scale = new ScaleTransition(Duration.millis(100), Btn_Ready);
        scale.setToX(1.0);
        scale.setToY(1.0);
        scale.play();
    }

    /**
     * Method used to quit from the primary stage
     */
    @FXML public void quit() {
        exit();
    }

}
