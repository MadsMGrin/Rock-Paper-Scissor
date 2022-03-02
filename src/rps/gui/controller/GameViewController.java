package rps.gui.controller;

// Java imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

// Project imports
import rps.bll.game.*;
import rps.bll.player.*;
/**
 *
 * @author smsj
 */
public class GameViewController implements Initializable {
    @FXML
    private Button pressRock = new Button();
    @FXML
    private Button pressPaper = new Button();
    @FXML
    private Button pressScissor = new Button();
    private String playerName;
    private String botName;
    private IPlayer human = new Player(playerName, PlayerType.Human);
    private IPlayer bot = new Player(botName, PlayerType.AI);
    private GameManager ge = new GameManager(human, bot);
    @FXML
    private ImageView humanPlayerChoose = new ImageView();
    private String theRock = "/rps/gui/Image/therock.jpeg";
    private String paper = "/rps/gui/Image/paper.jpg";
    private String scissor = "/rps/gui/Image/edward.jpg";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setImages();
    }
    public void setImages () {
        pressRock.setGraphic(new ImageView(theRock));
        pressPaper.setGraphic(new ImageView(paper));
        pressScissor.setGraphic(new ImageView(scissor));

    }


    public void pressRock(ActionEvent actionEvent) {
        humanPlayerChoose.setImage(new Image(theRock));
    }

    public void pressPaper(ActionEvent actionEvent) {
        humanPlayerChoose.setImage(new Image(paper));
    }

    public void pressScissor(ActionEvent actionEvent) {
        humanPlayerChoose.setImage(new Image(scissor));
    }
}
