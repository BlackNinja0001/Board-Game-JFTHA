package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class MageStaff extends Weapon{
    private final int magic = 2;
    private final int mp = 5;
    
    public MageStaff() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Mage Staff: +" + magic + " Magic, " + "+" + mp + " MP");
    }

    @Override
    public void equipWeap(Player player) {
        Hero hero = player.getCharacter();
        hero.setMagic(hero.getMagic() + magic);
        hero.setMaxMP(hero.getMaxMP() + mp);
    }

    @Override
    public void dropWeap(Player player) {
        Hero hero = player.getCharacter();
        hero.setMagic(hero.getMagic() - magic);
        hero.setMaxMP(hero.getMaxMP() - mp);
    }

    @Override
    public void weapEffect(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void weapEffect(Player attacker, Player attacked) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
