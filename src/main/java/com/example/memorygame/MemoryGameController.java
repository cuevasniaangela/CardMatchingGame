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
    private MemoryCard card1, card2;
    private int nGuesses;
    private int nMatches;
    @FXML
    void restart() {
        card1 = null;
        card2 = null;

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

        flipAllCards();
        correctGuessesLabel.setText(Integer.toString(0));
        guessesLabel.setText(Integer.toString(0));
        nMatches = 0;
        nGuesses = 0;
    }

    /**
     *  This method will initialize our UI by setting the view
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeImageView();
        restart();
    }

    /**
     * This method will add a number of cards to each ImageView and set the image to the back of the card
     */
    private void initializeImageView(){
        for(int i=0; i<imagesFlowPane.getChildren().size(); i++){   //Scorro tutte le imageView che ci sono dentro al flowPane
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            imageView.setImage(new Image("com/example/memorygame/back_of_card.png"));
            imageView.setUserData(i);   //The imageView gives i as an information for the user

            //Register a click listener - Something will happen every time I click on the images
            imageView.setOnMouseClicked(event -> {
                flipCard((int)imageView.getUserData());
            });
        }
    }

    private void flipCard(int indexOfCard){
        if(card1 == null && card2 == null){
            flipAllCards();
        }

        ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(indexOfCard);

        if(card1 == null){
            card1 = cardsInGame.get(indexOfCard);
            imageView.setImage(card1.getImage());
        }else if(card2 == null){
            nGuesses++;

            card2= cardsInGame.get(indexOfCard);
            imageView.setImage(card2.getImage());

            checkForMatch();
            updateLabels();
        }
    }

    private void updateLabels(){
        correctGuessesLabel.setText(Integer.toString(nMatches));
        guessesLabel.setText(Integer.toString(nGuesses));
    }

    /**
     * This method will show the back of all cards that are not matched
     */
    private void flipAllCards(){
        for(int i=0; i < imagesFlowPane.getChildren().size(); i++){
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);

            MemoryCard card = cardsInGame.get(i);
            if(card.isMatched()){
                imageView.setImage(cardsInGame.get(i).getImage());
            }else{
                imageView.setImage(cardsInGame.get(i).getBackOfCardImage());
            }
        }
    }

    private void checkForMatch(){
        if(card1.isSameCard(card2)){
            nMatches++;

            card1.setMatched(true);
            card2.setMatched(true);
        }

        card1 = null;
        card2 = null;
    }
}

