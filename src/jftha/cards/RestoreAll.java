package jftha.cards;

import jftha.heroes.*;
import jftha.main.*;

public class RestoreAll extends Card{

    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        if(hero.isGhost() == false){
            hero.setCurrentHP(hero.getMaxHP());
            hero.setCurrentMP(hero.getMaxMP());
        }else if(hero.isGhost() == true){
            hero.setCurrentMP(hero.getMaxMP());
        }
        this.setMessage("The Almighty One loves you. Restore HP and MP to max.");
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
