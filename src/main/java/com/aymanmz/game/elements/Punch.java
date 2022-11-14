package com.aymanmz.game.elements;

public class Punch extends Technique {
    public Punch() {
        minimumDamage = 1;
        maximumDamage = 1;
        damage = generateDamage();
    }
}
