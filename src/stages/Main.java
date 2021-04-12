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
        Parent root = FXMLLoader.load(getClass().getResource("primary/primaryScene.fxml"));

        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("../assets/images/Connect-four-logo.png")));
        primaryStage.setTitle("Connect 4");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 600, 400));
        // primaryStage.setScene(new Scene(root, 1440, 800));

        primaryStage.show();
    }

}