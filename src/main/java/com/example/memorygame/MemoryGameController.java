package com.example.memorygame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.ResourceBundle;

public class MemoryGameController implements Initializable {
    @FXML private Label correctGuessesLabel;
    @FXML private Label guessesLabel;
    @FXML private FlowPane imagesFlowPane;

    private ArrayList<MemoryCard> cardsInGame;
    private int nGuesses;
    private int nMatches;
    @FXML
    void playAgain() {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        cardsInGame = new ArrayList<>();

        for(int i = 0; i<imagesFlowPane.getChildren().size()/2; i++){
            Card cardDealt = deck.dealTopCard();

            //Added a pair of cards on the game in order
            cardsInGame.add(new MemoryCard(cardDealt.getSeed(), cardDealt.getFaceName()));
            cardsInGame.add(new MemoryCard(cardDealt.getSeed(), cardDealt.getFaceName()));
        }

        Collections.shuffle(cardsInGame);   //Shuffles the cards in the game
        System.out.println(cardsInGame);
    }

    /**
     *  This method will initialize our UI by setting the view
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeImageView();
        playAgain();
    }

    /**
     * This method will add a number of cards to each ImageView and set the image to the back of the card
     */
    private void initializeImageView(){
        for(int i=0; i<imagesFlowPane.getChildren().size(); i++){   //Scorro tutte le imageView che ci sono dentro al flowPane
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            imageView.setImage(new Image(Objects.requireNonNull(Card.class.getResourceAsStream("back_of_card.png"))));
            imageView.setUserData(i);   //The imageView gives i as an information for the user

            //Register a click listener - Something will happen every time i click on the images
            imageView.setOnMouseClicked(event -> {
                //System.out.println(imageView.getUserData());
                flipCard((int)imageView.getUserData());
            });
        }
    }

    private void flipCard(int indexOfCard){
        ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(indexOfCard);
        imageView.setImage(cardsInGame.get(indexOfCard).getImage());
    }
}

