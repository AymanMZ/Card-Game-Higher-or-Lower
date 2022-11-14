package com.aymanmz.game.elements;

public class Tracker {
    //Variables
    private int punchesTracker;
    private int kicksTracker;
    private int uppercutsTracker;
    //Constructor
    public Tracker() {
        punchesTracker = 0;
        kicksTracker = 0;
        uppercutsTracker = 0;
    }
    //Getters
    public int getPunchesTracker() {
        return punchesTracker;
    }
    private void setPunchesTracker(int punchesTracker) {
        this.punchesTracker = punchesTracker;
    }
    public int getKicksTracker() {
        return kicksTracker;
    }
    private void setKicksTracker(int kicksTracker) {
        this.kicksTracker = kicksTracker;
    }
    public int getUppercutsTracker() {
        return uppercutsTracker;
    }
    private void setUppercutsTracker(int uppercutsTracker) {
        this.uppercutsTracker = uppercutsTracker;
    }

    //Methods
    public void addToPunchTracker() {
        punchesTracker++;
    }
    public void addToKickTracker() {
        kicksTracker++;
    }
    public void addToUppercutTracker() {
        uppercutsTracker++;
    }
    public void resetAllTrackers() {
        punchesTracker = 0;
        kicksTracker = 0;
        uppercutsTracker = 0;
    }
}
