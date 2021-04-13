package stages.primary;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
import stages.Main;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import static javafx.application.Platform.exit;

/**
 * Primary controller class, used to manage players nicknames
 */
public class PrimaryController {

    // Attributes
    @FXML private Button Btn_Ready;
    @FXML private TextField redTextField;
    @FXML private TextField yellowTextField;
    public static String redNickname;
    public static String yellowNickname;

    /**
     * Method used to start the game and switching to the game stage
     * Event activated on Btn_Ready click
     */
    @FXML public void startGame(ActionEvent event) throws IOException {
        // Set nicknames on click
        if (submitNicknames()) {
            // Switch to game stage
            switchToGameScene(event);
            System.out.println("game started");
        }
    }

    /**
     * Method used to set player's nicknames
     * It manages invalid nicknames by throwing InvalidNicknameException
     * @return true if the submitted nicknames are valid, false if they are not
     */
    @FXML public boolean submitNicknames() {
        // Invalid nickname characters string
        String invalidCharacters = "^àáâãäåçèéêëìíîïðòóôõöùúûüýÿ!&¿?.<>~\\/%$£!=*:°§()[]{}";

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
                return false;
            }

            // Invalid characters check
            for (char c : invalidCharacters.toCharArray()) {
                // Red check
                if (redNickname.indexOf(c) != -1) {
                    redTextField.setText("");
                    redTextField.setPromptText("INVALID NICKNAME");
                    redTextField.setStyle("-fx-prompt-text-fill: #e78d8e");
                    return false;
                }
                // Yellow check
                if (yellowNickname.indexOf(c) != -1) {
                    yellowTextField.setText("");
                    yellowTextField.setPromptText("INVALID NICKNAME");
                    yellowTextField.setStyle("-fx-prompt-text-fill: #e78d8e");
                    return false;
                }
            }

        } catch (StringIndexOutOfBoundsException e) {
            throw new StringIndexOutOfBoundsException("Nickname is too long");
        }

        // Nicknames are ok
        return true;
    }

    /**
     * Method used to switch to game scene
     * @param event when Btn_Ready is pressed
     * @throws IOException is game scene loading fails
     */
    @FXML public void switchToGameScene(ActionEvent event) throws IOException {

        /* ----------------- Game stage ----------------- */
        Stage gameStage = new Stage();
        Parent gameRoot = FXMLLoader.load(getClass().getResource("../game/game.fxml")); // Game scene FXML loader
        gameStage.getIcons().add(new Image(Main.class.getResourceAsStream("../assets/images/connect-four-logo.png")));
        gameStage.setTitle("Connect 4");
        gameStage.initStyle(StageStyle.UNDECORATED);
        gameStage.setResizable(false);
        gameStage.centerOnScreen();
        gameStage.setScene(new Scene(gameRoot, 1440, 800));
        ((Node)(event.getSource())).getScene().getWindow().hide(); // Close the primary stage
        gameStage.show(); // Open the game stage

    }

    /**
     * Button hover animation
     */
    @FXML public void readyButtonHoverAnimation() {
        ScaleTransition scale = new ScaleTransition(Duration.millis(100), Btn_Ready);
        scale.setToX(1.1);
        scale.setToY(1.1);
        scale.play();
    }

    /**
     * Button exit animation
     */
    @FXML public void readyButtonReleasedAnimation() {
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
