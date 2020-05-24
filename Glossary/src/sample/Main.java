package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
private NeoTimer timer;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Glossary");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icon.jpg")));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        timer = NeoTimer.getInstance();
    }

    @Override
    public void stop() throws Exception {
        timer.cancel();
        timer.purge();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
