package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class IronSwordTest {
    
    Hero hero = new Knight();
    
    public IronSwordTest() {
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
        assertEquals("Iron Sword: +2 Strength", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipWeapon() {
        IronSword w = (IronSword)hero.getItems().get(1);
        w.equipWeap(hero);
        assertEquals(12, hero.getStrength());
        assertTrue(hero.getWeaponEquipped());
        assertEquals(w, hero.getWeapon());
    }

    @Test
    public void testDropWeapon() {
        IronSword w = (IronSword)hero.getItems().get(1);
        w.equipWeap(hero);
        w.dropWeap(hero);
        assertEquals(10, hero.getStrength());
        assertFalse(hero.getWeaponEquipped());
        assertNull(hero.getWeapon());
    }
}
