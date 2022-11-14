package com.aymanmz.game.elements;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    //Variables
    private List<AxeKick> listOfKicks;
    private List<FlamingUppercut> listOfUppercuts;
    private Punch punch;
    private final int maximumNumberOfKicks;
    private final int maximumNumberOfUppercuts;
    //Constructor
    public Inventory() {
        listOfKicks = new ArrayList<>();
        listOfUppercuts = new ArrayList<>();
        punch = new Punch();
        maximumNumberOfKicks = 5;
        maximumNumberOfUppercuts = 3;
    }
    //Getters
    public List<AxeKick> getListOfKicks() {
        return listOfKicks;
    }
    public List<FlamingUppercut> getListOfUppercuts() {
        return listOfUppercuts;
    }
    public int getMaximumNumberOfKicks() {
        return maximumNumberOfKicks;
    }
    public int getMaximumNumberOfUppercuts() {
        return maximumNumberOfUppercuts;
    }
    //Methods
    public Technique useAKick() {
        return listOfKicks.remove(getListOfKicks().size() - 1);
    }
    public Technique useAnUppercut() {
        return listOfUppercuts.remove(getListOfUppercuts().size() - 1);
    }
    public Technique useAPunch() {
        return punch;
    }
    public void addAKick() {
        if (listOfKicks.size() < getMaximumNumberOfKicks()) {
            listOfKicks.add(new AxeKick());
        }
    }
    public void addAnUppercut() {
        if (listOfUppercuts.size() < getMaximumNumberOfUppercuts()) {
            listOfUppercuts.add(new FlamingUppercut());
        }
    }

    /**
     * Reset the lists in the inventory back to 0.
     */
    public void resetValues() {
        listOfKicks = new ArrayList<>();
        listOfUppercuts = new ArrayList<>();
    }
}
