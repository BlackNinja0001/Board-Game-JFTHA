package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DivineBladeTest {
    
    Hero hero = new Paladin();
    
    public DivineBladeTest() {
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
        Item item = hero.getItems().get(1);
        assertEquals(RarityEnum.common, item.getRarity());
        assertEquals("Divine Blade: +4 Strength", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipArmor() {
        DivineBlade w = (DivineBlade)hero.getItems().get(1);
        w.equipWeap(hero);
        assertEquals(19, hero.getStrength());
        assertTrue(hero.hasWeapon());
        assertEquals(w, hero.getWeapon());
    }

    @Test
    public void testDropArmor() {
        DivineBlade w = (DivineBlade)hero.getItems().get(1);
        w.equipWeap(hero);
        w.dropWeap(hero);
        assertEquals(15, hero.getStrength());
        assertFalse(hero.hasWeapon());
        assertNull(hero.getWeapon());
    }
}
