package rps.gui;

// Java imports
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * JavaFX implementation of the RPS game
 *
 * @author smsj
 */
public class JavaFXApp extends Application {

    public static void launch() {
        Application.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("/rps/gui/view/GameView.fxml"));
        stage.setTitle("Rock-Paper-Scissor");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
