package jftha.items;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GoldskinTest {
    
    Player p = new Player("", new Barbarian());
    
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
        Hero h = p.getCharacter();
        Goldskin gs = new Goldskin();
        gs.equipArmor(p);
        assertEquals(85, h.getMaxHP());
        assertEquals(22, h.getStrength());
        assertEquals(16, h.getDefense());
        assertTrue(p.hasArmor());
        assertEquals(gs, p.getArmor());
    }

    @Test
    public void testDropArmor() {
        Hero h = p.getCharacter();
        h.setCurrentHP(25);
        Goldskin gs = new Goldskin();
        gs.equipArmor(p);
        gs.dropArmor(p);
        assertEquals(60, h.getMaxHP());
        assertEquals(12, h.getStrength());
        assertEquals(10, h.getDefense());
        assertFalse(p.hasArmor());
        assertNull(p.getArmor());
    }
}
