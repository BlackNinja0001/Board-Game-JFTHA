package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class SpellBook extends Weapon{
    private final int magic = 2;
    
    /**
     * Constructor
     */
    public SpellBook() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Spell Book: +" + magic + " Magic");
        this.setGoldCost(50);
    }

    /**
     * Lets current hero equip this weapon.
     * @param hero The hero that is equipping the weapon.
     */
    @Override
    public void equipWeap(Hero hero) {
        hero.setWeapon(this);
        hero.setWeaponEquipped(true);
        hero.setMagic(hero.getMagic() + magic);
    }

    /**
     * Lets current player un-equip this weapon.
     * @param hero The hero that is un-equipping the weapon.
     */
    @Override
    public void dropWeap(Hero hero) {
        hero.setWeapon(null);
        hero.setWeaponEquipped(false);
        hero.setMagic(hero.getMagic() - magic);
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
