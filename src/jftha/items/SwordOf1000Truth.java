package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class SwordOf1000Truth extends Weapon{
    private final int strength = (-5);
    private final int mp = (-10);
    private boolean hasWeapon = false;
    
    /**
     * Constructor
     */
    public SwordOf1000Truth(){
        this.setRarity(RarityEnum.rare);
        this.setMessage("Sword of 1000 Truths: " + strength + " Strength, " + mp + " MP\n" + "Effect: Reduce opponent MP to zero");
        this.setGoldCost(100);
        this.hasWeapon = false;
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
        hero.setStrength(hero.getStrength() + strength);
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
        player.setHasWeapon(false);
        player.setWeapon(null);
        hero.setStrength(hero.getStrength() - strength);
        hero.setMaxMP(hero.getMaxMP() - mp);
    }

    /**
     * Takes in Player class as a parameter.
     * Enemy hit with this weapon will lose all MP.
     * @param player 
     */
    @Override
    public void weapEffect(Player player) {
        Hero enemy = player.getCharacter();
        if(enemy.getWasAttacked() == true){
            enemy.setCurrentMP(0);
        }
    }
}
