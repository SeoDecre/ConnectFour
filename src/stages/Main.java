package stages;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        /* ----------------- Primary stage ----------------- */
        Parent root = FXMLLoader.load(getClass().getResource("primary/primary.fxml")); // Primary scene FXML loader
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("../assets/images/Connect-four-logo.png")));
        primaryStage.setTitle("Connect 4");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        /* ----------------- Primary stage ----------------- */
        Stage gameStage = new Stage();
        Parent gameRoot = FXMLLoader.load(getClass().getResource("game/game.fxml")); // Game scene FXML loader
        gameStage.getIcons().add(new Image(Main.class.getResourceAsStream("../assets/images/Connect-four-logo.png")));
        gameStage.setTitle("Connect 4");
        gameStage.initStyle(StageStyle.UNDECORATED);
        gameStage.setResizable(false);
        gameStage.centerOnScreen();
        gameStage.setScene(new Scene(gameRoot, 1440, 800));
    }

}