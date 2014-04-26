package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class MageRobe extends Armor {
    private final int magic = 2;
    private final int mp = 5;
    
    /**
     * Constructor
     */
    public MageRobe() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Mage Robe: +" + magic + " Magic, " + "+" + mp + " MP");
        this.setGoldCost(50);
    }

    /**
     * Lets current hero equip this armor.
     * @param hero The hero that is equipping the armor.
     */
    @Override
    public void equipArmor(Hero hero) {
        hero.setArmor(this);
        hero.setArmorEquipped(true);
        hero.setMagic(hero.getMagic() + magic);
        hero.setMaxMP(hero.getMaxMP() + mp);
    }

    /**
     * 
     * Lets current hero un-equip this armor.
     * @param hero The character that is un-equipping the armor.
     */
    @Override
    public void dropArmor(Hero hero) {
        hero.setArmor(null);
        hero.setArmorEquipped(false);
        hero.setMagic(hero.getMagic() - magic);
        hero.setMaxMP(hero.getMaxMP() - mp);
    }
    
    /**
     * No Effect.
     * @param hero 
     */
    @Override
    public void armorEffect(Hero hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
