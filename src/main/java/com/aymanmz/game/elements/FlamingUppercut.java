package com.aymanmz.game.elements;

public class FlamingUppercut extends Technique{
    //Constructor
    public FlamingUppercut() {
        this.minimumDamage = 10;
        this.maximumDamage = 15;
        this.damage = generateDamage();
    }
}
