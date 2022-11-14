package com.aymanmz.game;

import com.aymanmz.game.elements.*;
import com.aymanmz.game.exception.InvalidOptionException;

public class Game {
    private Inventory inventory;
    private Monster monster;
    private Tracker tracker;

    //Constructor
    public Game() {
        inventory = new Inventory();
        monster = new Monster();
        tracker = new Tracker();
    }

    //Getters
    public Inventory getInventory() {
        return inventory;
    }

    public Monster getMonster() {
        return monster;
    }

    public Tracker getTracker() {
        return tracker;
    }


    //Methods
    /**
     * Uses a punch on monster, and adds to the tracker. If the tracker gets high enough, resets the tracker and adds a punch.
     */
    public Technique usePunchOnMonster() {
        Technique technique = inventory.useAPunch();
        monster.takeDamage(technique.getDamage());
        tracker.addToPunchTracker();
        if (tracker.getPunchesTracker() % StaticValues.getKickConversionRate() == 0) {
            for (int i = 0; i < 2; i++) {
                inventory.addAKick();
            }
        }
        return technique;
    }

    /**
     * Same logic as usePunchOnMonster(). Throws an InvalidOptionException if there aren't kicks in the inventory.
     */
    public Technique useKickOnMonster() {
        try {
            Technique technique = inventory.useAKick();
            monster.takeDamage(technique.getDamage());
            tracker.addToKickTracker();
            if (tracker.getKicksTracker() % StaticValues.getUppercutConversionRate() == 0) {
                inventory.addAnUppercut();
            }
            return technique;
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidOptionException();
        }
    }

    /**
     * No tracker included. Just throws an exception if there aren't kicks in the inventory.
     */
    public Technique useUpperCutOnMonster() {
        try {
            Technique technique = inventory.useAnUppercut();
            monster.takeDamage(technique.getDamage());
            tracker.addToUppercutTracker();
            return technique;
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidOptionException();
        }
    }

    public void resetGame() {
        inventory.resetValues();
        tracker.resetAllTrackers();
        monster.resetValues();
    }

}
