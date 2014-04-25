package jftha.items;


import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalSkinTest {
    Hero hero = new Barbarian();
    
    public AnimalSkinTest() {
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
        assertEquals("Animal Skin: +2 Defense", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipArmor() {
        AnimalSkin a = (AnimalSkin)hero.getItems().get(0);
        a.equipArmor(hero);
        assertEquals(12, hero.getDefense());
        assertTrue(hero.hasArmor());
        assertEquals(a, hero.getArmor());
    }

    @Test
    public void testDropArmor() {
        AnimalSkin a = (AnimalSkin)hero.getItems().get(0);
        a.equipArmor(hero);
        a.dropArmor(hero);
        assertEquals(10, hero.getDefense());
        assertFalse(hero.hasArmor());
        assertNull(hero.getArmor());
    }
}
