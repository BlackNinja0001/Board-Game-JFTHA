package jftha.items;

import jftha.heroes.Hero;

public abstract class Armor extends Equippable{
    
    public abstract void equipArmor(Hero hero);
    public abstract void dropArmor(Hero hero);
    public abstract void armorEffect(Hero hero);
}
