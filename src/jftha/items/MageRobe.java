package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class MageRobe extends Armor {
    private final int magic = 2;
    private final int mp = 5;
    
    public MageRobe() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Mage Robe: +" + magic + " Magic, " + "+" + mp + " MP");
    }

    @Override
    public void equipArmor(Player player) {
        Hero hero = player.getCharacter();
        hero.setMagic(hero.getMagic() + magic);
        hero.setMaxMP(hero.getMaxMP() + mp);
    }

    @Override
    public void dropArmor(Player player) {
        Hero hero = player.getCharacter();
        hero.setMagic(hero.getMagic() - magic);
        hero.setMaxMP(hero.getMaxMP() - mp);
    }

    @Override
    public void armorEffect(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void armorEffect(Player attacker, Player attacked) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
