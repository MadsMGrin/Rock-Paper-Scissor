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


    public void pressRock(ActionEvent actionEvent) {

    }

    public void pressPaper(ActionEvent actionEvent) {
    }

    public void pressScissor(ActionEvent actionEvent) {
    }
}
