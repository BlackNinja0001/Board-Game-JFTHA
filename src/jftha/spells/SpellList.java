package jftha.spells;

import java.util.ArrayList;
import java.util.List;

public class SpellList {
    private List<Class> spellList = new ArrayList<>();
    
    public int getSpellSize() {
        return spellList.size();
    }
    public Class getSpellClass(int i) {
        return spellList.get(i);
    }
    
    public SpellList() {
        spellList.add(Fireball.class);
        spellList.add(Heal.class);
        spellList.add(Shield.class);
        spellList.add(SpectreShot.class);
    }
}
