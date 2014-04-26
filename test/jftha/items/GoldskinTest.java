package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GoldskinTest {
    
    Hero hero = new Barbarian();
    
    public GoldskinTest() {
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
        Item item = new Goldskin();
        assertEquals(RarityEnum.rare, item.getRarity());
        assertEquals("Goldskin: +25 HP, +10 Strength, +6 Defense", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipArmor() {
        Goldskin gs = new Goldskin();
        gs.equipArmor(hero);
        assertEquals(85, hero.getMaxHP());
        assertEquals(22, hero.getStrength());
        assertEquals(16, hero.getDefense());
        assertTrue(hero.getArmorEquipped());
        assertEquals(gs, hero.getArmor());
    }

    @Test
    public void testDropArmor() {
        hero.setCurrentHP(25);
        Goldskin gs = new Goldskin();
        gs.equipArmor(hero);
        gs.dropArmor(hero);
        assertEquals(60, hero.getMaxHP());
        assertEquals(12, hero.getStrength());
        assertEquals(10, hero.getDefense());
        assertFalse(hero.getArmorEquipped());
        assertNull(hero.getArmor());
    }
}
