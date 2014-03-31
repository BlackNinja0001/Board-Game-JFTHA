package jftha.effects;

import jftha.items.*;
import jftha.main.*;
import jftha.spells.*;
import java.util.*;
import jftha.effects.*;
import jftha.heroes.*;

public class InstantDeath extends Effect{
    
    InstantDeath(Hero hero){
        if(hero.isGhost() == false){
            hero.makeGhost();
        }else if(hero.isGhost() == true){
            hero.setEliminated(true);
        }
    }
}
