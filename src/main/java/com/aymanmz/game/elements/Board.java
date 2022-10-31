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

    //Methods
    public Integer putTopCardAway() {
        if (getCardsOnBoard().size() > 0) {
            return cardsOnBoard.remove(getCardsOnBoard().size() - 1);
        } else {
            throw new LowCardAmountException();
        }
    }
    public void takeCard(Integer card) {
        cardsOnBoard.add(card);
    }
}
