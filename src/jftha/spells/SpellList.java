package jftha.spells;

import java.util.ArrayList;
import java.util.List;

public class SpellList {
    private List<Class> spellList = new ArrayList<>();
    public SpellList() {
        spellList.add(Fireball.class);
        spellList.add(Heal.class);
        spellList.add(Shield.class);
        spellList.add(SpectreShot.class);
    }
}
