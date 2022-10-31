package com.aymanmz.game.elements;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Player {
    //Variables
    private List<Integer> cardsOnHand = new ArrayList<>();

    //Constructor

    //Getters and Setters
    public List<Integer> getCardsOnHand() {
        return cardsOnHand;
    }
    //Methods
    /**
     * Take a card and add it to your hand.
     */
    public void takeCard(Integer card) throws EmptyStackException {
        cardsOnHand.add(card);
    }
    /**
     * Put a specific card away.
     */
    public Integer removeCard(int specificCardInHand) {
        try {
            return cardsOnHand.remove(specificCardInHand);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
    }
}
