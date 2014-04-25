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
     * Lets current hero equip this weapon.
     * @param hero The hero that is equipping the weapon.
     */
    @Override
    public void equipWeap(Hero hero) {
        hero.setWeapon(this);
        hero.setHasWeapon(true);
        hero.setMagic(hero.getMagic() + magic);
        hero.setMaxMP(hero.getMaxMP() + mp);
    }

    /**
     * Lets current player un-equip this weapon.
     * @param hero The hero that is un-equipping the weapon.
     */
    @Override
    public void dropWeap(Hero hero) {
        hero.setWeapon(null);
        hero.setHasWeapon(false);
        hero.setMagic(hero.getMagic() - magic);
        hero.setMaxMP(hero.getMaxMP() - mp);
    }

    /**
     * No Effect
     * @param hero 
     */
    @Override
    public void weapEffect(Hero hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
