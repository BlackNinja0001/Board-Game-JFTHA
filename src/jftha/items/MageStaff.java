package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class MageStaff extends Weapon{
    private final int magic = 2;
    private final int mp = 5;
    
    /**
     * Constructor
     */
    public MageStaff() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Mage Staff: +" + magic + " Magic, " + "+" + mp + " MP");
        this.setGoldCost(50);
    }

    /**
     * Takes in Player class as a parameter.
     * Lets current player equip this weapon.
     * @param player 
     */
    @Override
    public void equipWeap(Player player) {
        Hero hero = player.getCharacter();
        player.setWeapon(this);
        player.setHasWeapon(true);
        hero.setMagic(hero.getMagic() + magic);
        hero.setMaxMP(hero.getMaxMP() + mp);
    }

    /**
     * Takes in Player class as a parameter.
     * Lets current player un-equip this weapon.
     * @param player 
     */
    @Override
    public void dropWeap(Player player) {
        Hero hero = player.getCharacter();
        player.setWeapon(null);
        player.setHasWeapon(false);
        hero.setMagic(hero.getMagic() - magic);
        hero.setMaxMP(hero.getMaxMP() - mp);
    }

    /**
     * No Effect
     * @param player 
     */
    @Override
    public void weapEffect(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
