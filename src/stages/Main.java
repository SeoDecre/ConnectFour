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
        Parent primaryRoot = FXMLLoader.load(getClass().getResource("primary/primary.fxml")); // Primary scene FXML loader
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("../assets/images/connect-four-logo.png")));
        primaryStage.setTitle("Connect 4");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(primaryRoot, 600, 400));
        primaryStage.show();

    }

}