package com.aymanmz.game;

import com.aymanmz.game.elements.Deck;
import com.aymanmz.game.elements.Player;

import java.util.EmptyStackException;
import java.util.Scanner;

public class App {
    private final Scanner userInput = new Scanner(System.in);
    private final Game game = new Game();

    public static void main(String[] args) {
        App application = new App();
        application.run();
    }

    private void run() {
        displayGreetings();
        boolean running = true;
        while (running) {
            displayMenu();
            int selection = takeIntInput();
            if (selection == 1) {
                isItHigherOrLower();
            } else if (selection == 2) {
                takeTopOff();
            } else if (selection == 3) {
                displayRules();
            }
            else if (selection == 4) {
                running = false;
            } else {
                System.out.printf("Please select one of the option numbers!%n%n");
            }
        }
    }

    /**
     * Used to display the greeting when the program is displayed for the first time.
     */
    private void displayGreetings() {
        System.out.println("---------------------------------");
        System.out.println("|  WELCOME TO HIGHER OR LOWER!  |");
        System.out.println("---------------------------------");
    }

    /**
     * Displays the menu options for the user.
     */
    private void displayMenu() {
        System.out.println("Round: " + game.getRoundNumber() +
                (game.getStreak() > 0 ? "   Streak: " + game.getStreak() + "!" : ""));
        displayCards();
        System.out.println("1. Guess");
        System.out.println("2. Take the top off");
        System.out.println("3. Explain the rules");
        System.out.println("4. Exit");
    }

    /**
     * Displays the board cards in order.
     */
    private void displayCards() {
        Boolean isItFirstCard = true;
        System.out.print("The cards on board are (from oldest to newest): ");
        for (Integer card : game.getBoard().getCardsOnBoard()) {
            if (!isItFirstCard) {
                System.out.print(", " + card);
            } else {
                System.out.print(card);
                isItFirstCard = false;
            }
        }
        System.out.printf("%n%n");
    }

    private void displayRules() {
        System.out.println();
        System.out.println("1. Make a guess if the next card drawn is higher or lower than the current top card on board.");
        System.out.println("2. If you guess correctly, your streak increases. Else, your streak resets.");
        System.out.println("3. The game lasts 5 rounds.");
        System.out.println("4. There is 11 cards total.");
        System.out.println("5. Once per game and if it's past round 1, you can take the board's top card off.");
        System.out.println("   Example: [3, 4] --> [3]");
        System.out.println();
    }

    /**
     * Takes an input from the user and turns into an Integer.
     *
     * @return will always be an Integer, regardless if it is positive or negative.
     */
    private Integer takeIntInput() {
        Integer result = null;
        while (result == null) {
            System.out.printf("%nSelect an option: ");
            String inputAsString = userInput.nextLine();
            try {
                result = Integer.parseInt(inputAsString);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        }
        return result;
    }

    /**
     * Happens when you choose the second option. Takes a card from the board off.
     */
    private void takeTopOff() {
        if (game.getBoard().getCardsOnBoard().size() > 1) {
            game.takeCardFromBoardToHand();
        } else {
            System.out.printf("%nWait until at least round 2!%n%n");
        }
    }

    private Integer takeGuess() {
        Integer guess = null;
        while (guess == null) {
            System.out.printf("%n1. Higher%n");
            System.out.println("2. Lower");
            guess = takeIntInput();
        }
        return guess;
    }

    /**
     * Responds back to the user if the answer is correct or wrong, and resets the game if its over.
     */
    private void cleanUp() {
        if (game.getStreak() == 0) {
            System.out.printf("%nWrong! Try better next time.%n%n");
        } else {
            System.out.printf("%nNice, keep it going!%n%n");
        }

        if (game.getRoundNumber() > 5) {
            System.out.printf("Game over. Your highest streak was: %s!%n%n", game.getHighStreak());
            game.resetGame();
        }
    }

    /**
     * Asks the user to guess between higher and lower, and returns a response based on that.
     */
    private void isItHigherOrLower() {
        boolean running = true;
        while (running) {
            Integer guess = takeGuess();
            if (guess.equals(1)) {
                game.isItHigher();
                running = false;
            } else if (guess.equals(2)) {
                game.isItLower();
                running = false;
            }
        }
        cleanUp();
    }
}
