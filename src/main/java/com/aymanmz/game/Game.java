package com.aymanmz.game;

import com.aymanmz.game.elements.Board;
import com.aymanmz.game.elements.Deck;
import com.aymanmz.game.elements.Player;
import com.aymanmz.game.exception.LowCardAmountException;

import java.util.EmptyStackException;

public class Game {
    //Variables
    private Board board = new Board();
    private Deck deck = new Deck();
    private Player player = new Player();
    private int roundNumber;
    private int streak;
    private int highStreak;

    //Constructor
    public Game() {
        takeCardFromDeckToBoard();
        roundNumber = 1;
        streak = 0;
    }

    //Getters and Setters
    public Board getBoard() {
        return board;
    }

    public Deck getDeck() {
        return deck;
    }

    public Player getPlayer() {
        return player;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getStreak() {
        return streak;
    }

    public int getHighStreak() {
        return highStreak;
    }

    //Methods
    private void takeCardFromDeckToHand() {
        try {
            player.takeCard(deck.removeCardFromTop());
        } catch (EmptyStackException e) {
            throw new LowCardAmountException();
        }
    }

    private void takeCardFromDeckToBoard() {
        try {
            board.takeCard(deck.removeCardFromTop());
        } catch (EmptyStackException e) {
            throw new LowCardAmountException();
        }
    }

    private void takeCardFromHandToBoard(int cardIndex) {
        try {
            board.takeCard(player.removeCard(cardIndex));
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void takeCardFromBoardToHand() {
        try {
            player.takeCard(board.putTopCardAway());
        } catch (IndexOutOfBoundsException e) {
            throw new LowCardAmountException();
        }
    }

    public void shuffleCardsBackIntoDeck() {
        for (int i = player.getCardsOnHand().size(); i > 0; i--) {
            deck.takeCard(player.removeCard(i - 1));
        }
        for (int i = board.getCardsOnBoard().size(); i > 0; i--) {
            deck.takeCard(board.putTopCardAway());
        }

        do {
            deck.shuffleCards();
        } while (deck.getStackOfCards().get(0) == 1 || deck.getStackOfCards().get(0) == 11);

    }


    public void isItLower() {
        Integer previousCard = board.getCardsOnBoard().get(board.getCardsOnBoard().size() - 1);
        takeCardFromDeckToBoard();
        Integer newCard = board.getCardsOnBoard().get(board.getCardsOnBoard().size() - 1);
        if (previousCard > newCard) {
            streak++;
            if (streak > highStreak) {
                highStreak = streak;
            }
        } else {
            streak = 0;
        }
        roundNumber++;
    }

    public void isItHigher() {
        Integer previousCard = board.getCardsOnBoard().get(board.getCardsOnBoard().size() - 1);
        takeCardFromDeckToBoard();
        Integer newCard = board.getCardsOnBoard().get(board.getCardsOnBoard().size() - 1);
        if (previousCard < newCard) {
            streak++;
            if (streak > highStreak) {
                highStreak = streak;
            }
        } else {
            streak = 0;
        }
        roundNumber++;
    }

    public void resetGame() {
        shuffleCardsBackIntoDeck();
        roundNumber = 1;
        takeCardFromDeckToBoard();
    }
}
