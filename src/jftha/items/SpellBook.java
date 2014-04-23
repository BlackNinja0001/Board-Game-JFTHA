package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class SpellBook extends Weapon{
    private final int magic = 2;
    
    public SpellBook() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Spell Book: +" + magic + " Magic");
        this.setGoldCost(50);
    }

    @Override
    public void equipWeap(Player player) {
        Hero hero = player.getCharacter();
        hero.setMagic(hero.getMagic() + magic);
    }

    @Override
    public void dropWeap(Player player) {
        Hero hero = player.getCharacter();
        hero.setMagic(hero.getMagic() - magic);
    }

    @Override
    public void weapEffect(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
