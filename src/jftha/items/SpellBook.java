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
