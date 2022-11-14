package com.aymanmz.game.elements;

import java.util.ArrayList;
import java.util.List;

public class Player {
    //Variables
    private List<Integer> cardsOnHand = new ArrayList<>();

    //Constructor

    //Getters and Setters
    public List<Integer> getCardsOnHand() {
        return cardsOnHand;
    }
    public void setCardsOnHand(List<Integer> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
    }
    //Methods
    /**
     * Take a card and add it to your hand.
     */
    public void takeCard(Integer card) {
        if (card != null) {
            cardsOnHand.add(card);
        }
    }
    /**
     * Put a specific card away.
     */
    public Integer removeCard(int cardIndex) {
        try {
            return cardsOnHand.remove(cardIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
    }
    /**
     * Put all cards away.
     */
    public List<Integer> removeAllCards() {
        List<Integer> results = new ArrayList<>();
        for (int i = cardsOnHand.size(); i > 0; i--) {
            results.add(removeCard(i - 1));
        }
        return results;
    }
}
