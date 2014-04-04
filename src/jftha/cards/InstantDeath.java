package jftha.cards;

import jftha.items.*;
import jftha.main.*;
import jftha.spells.*;
import java.util.*;
import jftha.heroes.*;

public class InstantDeath extends Card{
    
    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected) {
        Hero playerHero = affected.getCharacter();
        if(playerHero.isGhost() == false){
            playerHero.makeGhost();
        }else if(playerHero.isGhost() == true){
            playerHero.setEliminated(true);
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
