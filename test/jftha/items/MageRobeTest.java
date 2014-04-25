package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MageRobeTest {
    
    Hero hero = new Mage();
    
    public MageRobeTest() {
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
        assertEquals("Mage Robe: +2 Magic, " + "+5 MP", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipArmor() {
        MageRobe a = (MageRobe)hero.getItems().get(0);
        a.equipArmor(hero);
        assertEquals(14, hero.getMagic());
        assertEquals(35, hero.getMaxMP());
        assertTrue(hero.hasArmor());
        assertEquals(a, hero.getArmor());
    }

    @Test
    public void testDropArmor() {
        MageRobe a = (MageRobe)hero.getItems().get(0);
        a.equipArmor(hero);
        a.dropArmor(hero);
        assertEquals(12, hero.getMagic());
        assertEquals(30, hero.getMaxMP());
        assertFalse(hero.hasArmor());
        assertNull(hero.getArmor());
    }
}
