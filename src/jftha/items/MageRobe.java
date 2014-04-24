package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class MageRobe extends Armor {
    private final int magic = 2;
    private final int mp = 5;
    
    public MageRobe() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Mage Robe: +" + magic + " Magic, " + "+" + mp + " MP");
        this.setGoldCost(50);
    }

    @Override
    public void equipArmor(Player player) {
        Hero hero = player.getCharacter();
        player.setArmor(this);
        player.setHasArmor(true);
        hero.setMagic(hero.getMagic() + magic);
        hero.setMaxMP(hero.getMaxMP() + mp);
    }

    @Override
    public void dropArmor(Player player) {
        Hero hero = player.getCharacter();
        player.setArmor(null);
        player.setHasArmor(false);
        hero.setMagic(hero.getMagic() - magic);
        hero.setMaxMP(hero.getMaxMP() - mp);
    }

    @Override
    public void armorEffect(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
