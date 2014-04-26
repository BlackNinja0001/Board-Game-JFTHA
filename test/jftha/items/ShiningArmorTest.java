package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShiningArmorTest {
    
    Hero hero = new Paladin();
    
    public ShiningArmorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testProperties() {
        Item item = hero.getItems().get(0);
        assertEquals(RarityEnum.uncommon, item.getRarity());
        assertEquals("Shining Armor: +20 HP, " + "+5 Defense", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipArmor() {
        ShiningArmor a = (ShiningArmor)hero.getItems().get(0);
        a.equipArmor(hero);
        assertEquals(100, hero.getMaxHP());
        assertEquals(20, hero.getDefense());
        assertTrue(hero.getArmorEquipped());
        assertEquals(a, hero.getArmor());
    }

    @Test
    public void testDropArmor() {
        ShiningArmor a = (ShiningArmor)hero.getItems().get(0);
        a.equipArmor(hero);
        a.dropArmor(hero);
        assertEquals(80, hero.getMaxHP());
        assertEquals(15, hero.getDefense());
        assertFalse(hero.getArmorEquipped());
        assertNull(hero.getArmor());
    }
}
