package jftha.spaces;

import java.util.*;
import jftha.heroes.*;
import jftha.items.*;

public class Store extends Space{
    
    public Store(){
        this.setActivationType('p');
    }
    
    public void buy(){
        Hero h = getActivator();
        ItemLists il = new ItemLists();
        h.buy(null);
    }
}
