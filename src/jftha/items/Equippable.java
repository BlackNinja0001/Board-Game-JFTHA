package jftha.items;

import jftha.heroes.*;
import jftha.main.Player;

public class Equippable extends Item{
   
    @Override
    public void triggerEffect() {}

    @Override
    public void triggerEffect(Player affected) {}

    @Override
    public void triggerEffect(Player affected1, Player affected2) {}
}
