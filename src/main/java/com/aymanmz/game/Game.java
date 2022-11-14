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
        resetGame();
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

    /**
     * Get a card from the top of the deck and put it in your hand.
     */
    private void takeCardFromDeckToHand() {
        try {
            player.takeCard(deck.removeCardFromTop());
        } catch (EmptyStackException e) {
            throw new LowCardAmountException();
        }
    }

    /**
     * Take a card from the deck and put it to board.
     */
    private void takeCardFromDeckToBoard() {
        try {
            board.takeCard(deck.removeCardFromTop());
        } catch (EmptyStackException e) {
            throw new LowCardAmountException();
        }
    }

    /**
     * Take a specific card from your hand and put it on the board.
     * @param cardIndex
     */
    private void takeCardFromHandToBoard(int cardIndex) {
        try {
            board.takeCard(player.removeCard(cardIndex));
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Take a specific from the board and put it on the hand.
     */
    public void takeCardFromBoardToHand() {
        try {
            player.takeCard(board.putTopCardAway());
        } catch (IndexOutOfBoundsException e) {
            throw new LowCardAmountException();
        }
    }

    /**
     * Take all the cards, put them onto the deck, and shuffle.
     */
    public void shuffleCardsBackIntoDeck() {
        deck.takeAllCards(player.removeAllCards());
        deck.takeAllCards(board.putAllCardsAway());
        deck.shuffleCards();
    }

    /**
     * Do a round of the game by drawing a card and comparing if it is lower, update the values accordingly.
     */
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

    /**
     * Do a round of the game by drawing a card and comparing if it is higher, update the values accordingly.
     */
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

    /**
     * Reset the game by shuffling the deck back, and resetting the values. If the first card on board starts with 1 or 14. Then reshuffle again.
     */
    public void resetGame() {
        do {
            shuffleCardsBackIntoDeck();
            takeCardFromDeckToBoard();
        } while (board.getCardsOnBoard().get(0) == 1 || board.getCardsOnBoard().get(0) == 11);
        roundNumber = 1;
        streak = 0;
        highStreak = 0;
    }
}
