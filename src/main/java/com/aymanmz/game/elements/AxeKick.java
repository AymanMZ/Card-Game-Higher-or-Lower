package com.aymanmz.game.elements;

import java.util.Random;

public class AxeKick extends Technique {
    //Constructor
    public AxeKick() {
        this.minimumDamage = 3;
        this.maximumDamage = 5;
        this.damage = generateDamage();
    }
}
