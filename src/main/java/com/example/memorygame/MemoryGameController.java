package com.example.memorygame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MemoryGameController implements Initializable {
    @FXML private Label correctGuessesLabel;
    @FXML private Label guessesLabel;
    @FXML private ImageView imageView;
    @FXML private FlowPane imagesFlowPane;
    @FXML
    void playAgain(ActionEvent event) {

    }

    /**
     *  This method will initialize our UI by setting the view
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Card card = new Card ("batons", "king");
        imageView.setImage(card.getImage());
    }
}

