package jftha.cards;

import jftha.heroes.*;
import jftha.main.*;

public class Revive extends Card{

    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected) {
         Hero hero = affected.getCharacter();
         String string;
         if(hero.isGhost() == false){
             string = "You're not dead. Go away.";
             System.out.println(string);
         }else if(hero.isGhost() == true){
             string = "Its your lucky day. Welcome back to the land of the living.";
             System.out.println(string);
             hero.unGhost();
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
