package com.aymanmz.game.elements;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    //Variables
    private Stack<Integer> stackOfCards = new Stack<>();

    //Constructor
    public Deck() {
        for (int i = 1; i <= 11; i++) {
            stackOfCards.push(i);
        }
        do {
            shuffleCards();
        } while (stackOfCards.get(0) == 1 || stackOfCards.get(0) == 11);
    }

    //Getters
    public Stack<Integer> getStackOfCards() {
        return stackOfCards;
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
        stackOfCards.push(card);
    }
}
