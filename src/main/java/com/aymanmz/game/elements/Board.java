package com.aymanmz.game.elements;

import com.aymanmz.game.exception.LowCardAmountException;

import java.util.ArrayList;
import java.util.List;

public class Board {
    //Variable
    List<Integer> cardsOnBoard = new ArrayList<>();
    //Constructor

    //Getters
    public List<Integer> getCardsOnBoard() {
        return cardsOnBoard;
    }
    public void setCardsOnBoard(List<Integer> cardsOnBoard) {
        this.cardsOnBoard = cardsOnBoard;
    }

    //Methods

    /**
     * Method that takes the latest the top card off list.
     * @return returns the card that was taken off.
     */
    public Integer putTopCardAway() {
        if (getCardsOnBoard().size() > 0) {
            return cardsOnBoard.remove(getCardsOnBoard().size() - 1);
        } else {
            throw new LowCardAmountException();
        }
    }
    /**
     * Method that takes all cards off list.
     * @return returns a list of the cards taken.
     */
    public List<Integer> putAllCardsAway() {
        List<Integer> results = new ArrayList<>();
        for (int i = cardsOnBoard.size(); i > 0; i--) {
            results.add(putTopCardAway());
        }
        return results;
    }

    /**
     * Take a card and adds it to the list.
     * @param card the card being taken
     */
    public void takeCard(Integer card) {
        if (card != null) {
            cardsOnBoard.add(card);
        }
    }

    /**
     * Take a list of cards and add it to the list.
     * @param cards the cards being taken
     */
    public void takeCards(List<Integer> cards) {
        for (Integer card : cards) {
            takeCard(card);
        }
    }
}
