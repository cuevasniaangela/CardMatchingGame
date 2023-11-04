package com.example.memorygame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private final ArrayList<Card> deck;

    public DeckOfCards(){
        this.deck = new ArrayList<>();

        //Crete the deck of cards
        List<String> seeds = Card.getValidSeeds();
        List<String> faceNames = Card.getValidFaceNames();

        for(String seed: seeds){
            for(String faceName: faceNames){
                deck.add(new Card(seed, faceName));
            }
        }
    }

    /**
     * Method that shuffles the deck of cards
     */
    public void shuffle(){
        Collections.shuffle(deck);
    }

    /**
     * Methods that returns the top card from the deck
     * if the deck is empty => Returns null
     */
    public Card dealTopCard(){
        if(deck.size()>0){
            return deck.remove(0);
        }else{
            return null;
        }
    }
}
