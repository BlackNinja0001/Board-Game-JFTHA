package jftha.cards;

import jftha.heroes.*;
import jftha.main.*;
import jftha.spaces.*;
import jftha.spaces.*;

public class MoveBack extends Card{

    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected) {
        int movement = 3;
        while(movement >= 0) {
            Space current = affected.move("b");
            if(current.getActivationType() == 'p') { //pass-by
                    current.triggerEffect();     
            } else if (movement == 0 && current.getActivationType() == 'l'){ //land-on
                    if(current.getSpaceType() == SpaceEnum.D2D) {
                        // prompt for hero
                        Player p = null;
                        current.triggerEffect(p.getCharacter());
                    } else {
                        current.triggerEffect();
                    }
            } else {
                throw new IllegalActivationTypeException();
            }
            
            movement--;
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
