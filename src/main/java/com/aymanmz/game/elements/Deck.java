package com.aymanmz.game.elements;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {
    //Variables
    private Stack<Integer> stackOfCards = new Stack<>();

    //Constructor
    public Deck() {
        for (int i = 1; i <= 11; i++) {
            stackOfCards.push(i);
        }
    }

    //Getters and Setters
    public Stack<Integer> getStackOfCards() {
        return stackOfCards;
    }

    public void setStackOfCards(Stack<Integer> stackOfCards) {
        this.stackOfCards = stackOfCards;
    }
//Methods
    /**
     * Shuffles the contents of the stack around.
     */
    public void shuffleCards() {
        Collections.shuffle(stackOfCards);
    }
    /**
     * Take the top card off.
     * @return return that top card.
     */
    public Integer removeCardFromTop() {
        return stackOfCards.pop();
    }
    /**
     * Take a card and put it on top.
     * @param card the card you are adding.
     */
    public void takeCard(Integer card) {
        if (card != null) {
            stackOfCards.push(card);
        }
    }

    /**
     * Take multiple cards and put them on top.
     * @param cards the cards you are adding.
     */
    public void takeAllCards(List<Integer> cards) {
        for (Integer card : cards) {
            takeCard(card);
        }
    }
}
