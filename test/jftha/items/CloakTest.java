package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CloakTest {
    
    Hero hero = new Ninja();
    
    public CloakTest() {
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
        assertEquals(RarityEnum.common, item.getRarity());
        assertEquals("Cloak: +2 Agility", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipArmor() {
        Cloak c = (Cloak)hero.getItems().get(0);
        c.equipArmor(hero);
        assertEquals(14, hero.getAgility());
        assertTrue(hero.getArmorEquipped());
        assertEquals(c, hero.getArmor());
    }

    @Test
    public void testDropArmor() {
        Cloak a = (Cloak)hero.getItems().get(0);
        a.equipArmor(hero);
        a.dropArmor(hero);
        assertEquals(12, hero.getAgility());
        assertFalse(hero.getArmorEquipped());
        assertNull(hero.getArmor());
    }
}
