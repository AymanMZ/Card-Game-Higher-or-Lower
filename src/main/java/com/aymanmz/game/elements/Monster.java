package com.aymanmz.game.elements;

public class Monster {
    //Variables
    private final int maxHealth;
    private int currentHealth;
    //Constructor

    public Monster() {
        maxHealth = 120;
        this.currentHealth = maxHealth;
    }


    //Getters and Setters

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
    public void takeDamage(int damageNumber) {
        setCurrentHealth(getCurrentHealth() - damageNumber);
    }
    public void resetValues() {
        setCurrentHealth(getMaxHealth());
    }
}
