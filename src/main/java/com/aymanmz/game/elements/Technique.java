package com.aymanmz.game.elements;

import java.util.Random;

public abstract class Technique {
    //Variables
    protected int damage;
    protected int minimumDamage;
    protected int maximumDamage;
    //Getters
    public int getDamage() {
        return damage;
    }
    //Methods
    /**
     * Generate the damage amount using a random number geneator formula.
     * @return
     */
    protected int generateDamage() {
        return new Random().nextInt((maximumDamage - minimumDamage) + 1) + minimumDamage;
    }
}
