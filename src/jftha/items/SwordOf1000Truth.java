package jftha.items;

import jftha.heroes.Hero;

public class SwordOf1000Truth extends Weapon{
    private final int strength = (-5);
    private final int mp = (-10);
    
    /**
     * Constructor
     */
    public SwordOf1000Truth(){
        this.setRarity(RarityEnum.rare);
        this.setMessage("Sword of 1000 Truths: " + strength + " Strength, " + mp + " MP\n" + "Effect: Reduce opponent MP to zero");
        this.setGoldCost(100);
    }
    
    /**
     * Lets current hero equip this weapon.
     * @param hero The hero that is equipping the weapon.
     */
    @Override
    public void equipWeap(Hero hero) {
        hero.setWeapon(this);
        hero.setWeaponEquipped(true);
        hero.setStrength(hero.getStrength() + strength);
        hero.setMaxMP(hero.getMaxMP() + mp);
    }

    /**
     * Lets current player un-equip this weapon.
     * @param hero The hero that is un-equipping the weapon.
     */
    @Override
    public void dropWeap(Hero hero) {
        hero.setWeapon(null);
        hero.setWeaponEquipped(false);
        hero.setStrength(hero.getStrength() - strength);
        hero.setMaxMP(hero.getMaxMP() - mp);
    }
    
    /**
     * Enemy hit with this weapon will lose all MP.
     * @param enemy The enemy being hit with the weapon
     */
    @Override
    public void weapEffect(Hero enemy) {
        if(enemy.getWasAttacked() == true){
            enemy.setCurrentMP(0);
            if(enemy.isGhost()) {
                enemy.setEliminated(true);
            }
        }
    }
}
