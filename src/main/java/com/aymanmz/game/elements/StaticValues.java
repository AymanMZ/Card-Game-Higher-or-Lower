package com.aymanmz.game.elements;

public class StaticValues {
    private static final int kickConversionRate;
    private static final int uppercutConversionRate;
    private static final int highestDamage;
    private static final int amazingDamageFloor;
    private static final int keepGoingDamageFloor;

    static {
        kickConversionRate = 10;
        uppercutConversionRate = 3;
        highestDamage = 15;
        amazingDamageFloor = 10;
        keepGoingDamageFloor = 3;
    }

    private StaticValues() {
    }

    //Getters
    public static int getKickConversionRate() {
        return kickConversionRate;
    }

    public static int getUppercutConversionRate() {
        return uppercutConversionRate;
    }

    public static int getHighestDamage() {
        return highestDamage;
    }

    public static int getAmazingDamageFloor() {
        return amazingDamageFloor;
    }

    public static int getKeepGoingDamageFloor() {
        return keepGoingDamageFloor;
    }
}
