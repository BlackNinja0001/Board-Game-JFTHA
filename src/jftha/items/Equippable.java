package jftha.items;

import jftha.heroes.*;

public class Equippable extends Item{
   
    @Override
    public void triggerEffect() {}

    @Override
    public void triggerEffect(Hero affected) {}

    @Override
    public void triggerEffect(Hero affected1, Hero affected2) {}
}
