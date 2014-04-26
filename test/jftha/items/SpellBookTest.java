package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpellBookTest {
    
    Hero hero = new Mage();
    
    public SpellBookTest() {
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
        assertEquals("Spell Book: +2 Magic", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipWeapon() {
        SpellBook w = (SpellBook)hero.getItems().get(1);
        w.equipWeap(hero);
        assertEquals(14, hero.getMagic());
        assertTrue(hero.getWeaponEquipped());
        assertEquals(w, hero.getWeapon());
    }

    @Test
    public void testDropWeapon() {
        SpellBook w = (SpellBook)hero.getItems().get(1);
        w.equipWeap(hero);
        w.dropWeap(hero);
        assertEquals(12, hero.getMagic());
        assertFalse(hero.getWeaponEquipped());
        assertNull(hero.getWeapon());
    }
}
