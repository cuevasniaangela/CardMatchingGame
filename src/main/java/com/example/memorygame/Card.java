package com.example.memorygame;

import java.util.Arrays;
import java.util.List;

public class Card {
    private String seed;
    private String faceName;

    public Card(String seed, String faceName) {
        this.seed = seed;
        this.faceName = faceName;
    }

    public String getSeed() {
        return seed;
    }

    public String getFaceName() {
        return faceName;
    }

    public static List<String> getValidSeeds(){
        return Arrays.asList("Swords", "Batons", "Cups", "Coins");
    }

    /**
     * Valid values for seed are "Swords", "Batons", "Cups", "Coins"
     * @param seed
     */
    public void setSeed(String seed) {
        seed = seed.toLowerCase();

        if(getValidSeeds().contains(seed)) {
            this.seed = seed;
        }else{
            throw new IllegalArgumentException(seed + "not correct, must be one of " +  getValidSeeds());
        }
    }

    public static List<String> getValidFaceNames(){
        return Arrays.asList("2", "3", "4", "5", "6", "7", "Jack", "Horse", "King", "Ace");
    }
    /**
     * Valid values of faceName are "2", "3", "4", "5", "6", "7", "Jack", "Horse", "King", "Ace"
     * @param faceName
     */
    public void setFaceName(String faceName) {
        faceName = faceName.toLowerCase();
        if(getValidFaceNames().contains(faceName)) {
            this.faceName = faceName;
        }else{
            throw new IllegalArgumentException(faceName + "is invalid, must be one of " + getValidFaceNames());
        }
    }

    @Override
    public String toString() {
        return faceName + " type of " + seed;
    }
}
