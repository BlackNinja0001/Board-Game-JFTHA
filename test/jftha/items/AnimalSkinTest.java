package jftha.items;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalSkinTest {
    Player p = new Player("", new Barbarian());
    
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
        Item item = p.getCharacter().getItems().get(0);
        assertEquals(RarityEnum.common, item.getRarity());
        assertEquals("Animal Skin: +2 Defense", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipArmor() {
        Hero h = p.getCharacter();
        AnimalSkin a = (AnimalSkin)h.getItems().get(0);
        a.equipArmor(p);
        assertEquals(12, h.getDefense());
        assertTrue(p.hasArmor());
        assertEquals(a, p.getArmor());
    }

    @Test
    public void testDropArmor() {
        Hero h = p.getCharacter();
        AnimalSkin a = (AnimalSkin)h.getItems().get(0);
        a.equipArmor(p);
        a.dropArmor(p);
        assertEquals(10, h.getDefense());
        assertFalse(p.hasArmor());
        assertNull(p.getArmor());
    }
}
