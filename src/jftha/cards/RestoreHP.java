package jftha.cards;

import java.util.*;
import jftha.heroes.*;
import jftha.main.*;

public class RestoreHP extends Card{

    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        if(hero.isGhost() == false){
            hero.setCurrentHP(hero.getMaxHP());
        }else if(hero.isGhost() == true){
            hero.setCurrentMP(hero.getMaxMP());
        }
    }

    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected1, Player affected2, Player affected3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
