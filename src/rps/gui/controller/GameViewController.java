package rps.gui.controller;

// Java imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private ImageView botPlayerChoose;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setImages();
    }
    public void setImages () {
        pressRock.setGraphic(new ImageView("/rps/gui/Image/therock.jpeg"));
        pressPaper.setGraphic(new ImageView("/rps/gui/Image/paper.jpg"));
        pressScissor.setGraphic(new ImageView("/rps/gui/Image/edward.jpg"));

    }

    @FXML
    private void pressRock(ActionEvent actionEvent) {
        ge.playRound(Move.Rock);
        humanPlayerChoose.setImage(new Image("/rps/gui/Image/therock.jpeg"));
    }
    @FXML
    private void pressPaper(ActionEvent actionEvent) {
        ge.playRound(Move.Paper);
        humanPlayerChoose.setImage(new Image("/rps/gui/Image/paper.jpg"));
    }
    @FXML
    private void pressScissor(ActionEvent actionEvent) {
        ge.playRound(Move.Scissor);
        humanPlayerChoose.setImage(new Image("/rps/gui/Image/edward.jpg"));

    }
    @FXML
    private void getAIMove(){
        
    }
}
