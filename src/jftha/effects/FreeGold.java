package jftha.effects;

import jftha.items.*;
import jftha.main.*;
import jftha.spells.*;
import java.util.*;
import jftha.effects.*;
import jftha.heroes.*;

public class FreeGold extends Effect{
    
    FreeGold(Hero hero){
        Random rand = new Random(System.currentTimeMillis());
        
        //can be more or less gold. still need to figure out gold cost of items to balance out this effect
        int freegold = rand.nextInt(50);
        hero.setGold(hero.getGold() + freegold);
    }
}
