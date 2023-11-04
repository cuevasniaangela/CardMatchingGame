package com.example.memorygame;

public class MemoryCard extends Card{
    private boolean matched;

    public MemoryCard(String seed, String faceName) {
        super(seed, faceName);
        this.matched = false;
    }

    public boolean isMatched(){
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    /**
     * Method returns true if the 2 MemoryCard objects
     * have the same seed and faceName
     */
    public boolean isSameCard(MemoryCard otherCard){
        return (this.getSeed().equals(otherCard.getSeed()) &&
                (this.getFaceName().equals(otherCard.getFaceName())));
    }
}
