package com.aymanmz.game;

import com.aymanmz.game.elements.AxeKick;
import com.aymanmz.game.elements.Monster;
import com.aymanmz.game.elements.StaticValues;
import com.aymanmz.game.elements.Technique;
import com.aymanmz.game.exception.InvalidOptionException;

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
                startGame();
            } else if (selection == 2) {
                displayRules();
            } else if (selection == 3) {
                running = false;
            } else {
                System.out.println("Please select one of the option numbers!");
                System.out.println();
            }
        }
    }

    /**
     * Used to display the greeting when the program is displayed for the first time.
     */
    private void displayGreetings() {
        System.out.println("--------------------------------");
        System.out.println("|  WELCOME TO MONSTER MASHER!  |");
        System.out.println("--------------------------------");
        System.out.println();
    }

    /**
     * Displays the menu options for the user.
     */
    private void displayMenu() {
        System.out.println("1. Start Game");
        System.out.println("2. Explain the rules");
        System.out.println("3. Exit");
        System.out.println();
    }

    private void displayRules() {
        System.out.println("Rules: ");
        System.out.println("1. Your goal is to take the monster's health to 0 or less.");
        System.out.println("2. While you have an infinite amount of punches, your other moves are limited.");
        System.out.println("3. You can unlock the other moves by using more of them! Keep an eye on your inventory to see if you have any.");
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
                //If results is empty, pass a negative value.
                if (inputAsString.isEmpty()) {
                    result = -1;
                } else {
                    result = Integer.parseInt(inputAsString);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
                System.out.println();
            }
        }
        System.out.println();
        return result;
    }

    private void startGame() {
        System.out.println("Have fun!");
        System.out.println();
        while (game.getMonster().getCurrentHealth() > 0) {
            displayMonsterHealth();
            displayMoves();
            Technique technique;
            int choice = takeIntInput();
            try {
                if (choice == 1) {
                    technique = game.useKickOnMonster();
                } else if (choice == 2) {
                    technique = game.useUpperCutOnMonster();
                } else if (choice == 0) {
                    break;
                } else {
                    technique = game.usePunchOnMonster();
                }
                displayDamage(technique);
            } catch (InvalidOptionException e) {
                System.out.println("Not in stock yet!");
                System.out.println();
            }
        }
        if (game.getMonster().getCurrentHealth() <= 0) {
            System.out.printf("Congratulations, you beat the monster using %d punches, %d kicks, and %d uppercuts!%n%n",
                    game.getTracker().getPunchesTracker(), game.getTracker().getKicksTracker(), game.getTracker().getUppercutsTracker());
        }
        game.resetGame();
    }

    /**
     * i++ moved to middle of method instead of end to make values match up.
     */
    private void displayMonsterHealth() {
        System.out.printf("Current Health: %d / %d%n", game.getMonster().getCurrentHealth(), game.getMonster().getMaxHealth());
        System.out.println();
    }

    private void displayDamage(Technique technique) {
        try {
            int damage = technique.getDamage();
            System.out.print("Monster took " + damage + ". ");
            if (damage == StaticValues.getHighestDamage()) {
                System.out.println("CRITICAL HIT!");
            } else if (damage >= StaticValues.getAmazingDamageFloor()) {
                System.out.println("Amazing work!");
            } else if (damage >= StaticValues.getKeepGoingDamageFloor()) {
                System.out.println("Keep it going!");
            } else {
                System.out.println();
            }
            System.out.println();
        } catch (NullPointerException e) {
            System.out.println("Make sure to pick one of the moves!");
            System.out.println();
        }
    }

    private void displayMoves() {
        System.out.println("What move would you like to choose?");
        System.out.println();
        System.out.println("Press:");
        System.out.printf("1) Axe Kick. (%d/%d)%n", game.getInventory().getListOfKicks().size(), game.getInventory().getMaximumNumberOfKicks());
        System.out.printf("2) Flaming Uppercut. (%d/%d)%n", game.getInventory().getListOfUppercuts().size(), game.getInventory().getMaximumNumberOfUppercuts());
        System.out.println("Enter) Punch.");
        System.out.println("0) Exit.");
    }

}
