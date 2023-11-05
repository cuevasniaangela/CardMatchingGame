package com.example.memorygame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MemoryGameController implements Initializable {
    @FXML private Label correctGuessesLabel;
    @FXML private Label guessesLabel;
    @FXML private FlowPane imagesFlowPane;
    @FXML
    void playAgain(ActionEvent event) {

    }

    /**
     *  This method will initialize our UI by setting the view
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeImageView();
    }

    /**
     * This method will add a number of cards to each ImageView and set the image to the back of the card
     */
    private void initializeImageView(){
        for(int i=0; i<imagesFlowPane.getChildren().size(); i++){   //Scorro tutte le imageView che ci sono dentro al flowPane
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            imageView.setImage(new Image(Card.class.getResourceAsStream("images/back_of_card.png")));
            imageView.setUserData(i);   //The imageView gives i as an information for the user

            //Register a click listener - Something will happen every time i click on the images
            imageView.setOnMouseClicked(event -> {
                System.out.println(imageView.getUserData());
            });
        }
    }
}

