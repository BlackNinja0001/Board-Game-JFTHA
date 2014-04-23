package jftha.items;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DaggerTest {
    
    Player p = new Player("", new Ninja());
    
    public DaggerTest() {
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
        Item item = p.getCharacter().getItems().get(1);
        assertEquals(RarityEnum.common, item.getRarity());
        assertEquals("Dagger: +2 Strength, +1 Agility", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipWeapon() {
        Hero h = p.getCharacter();
        Dagger w = (Dagger)h.getItems().get(1);
        w.equipWeap(p);
        assertEquals(12, h.getStrength());
        assertEquals(13, h.getAgility());
        assertTrue(p.hasWeapon());
        assertEquals(w, p.getWeapon());
    }

    @Test
    public void testDropWeapon() {
        Hero h = p.getCharacter();
        Dagger w = (Dagger)h.getItems().get(1);
        w.equipWeap(p);
        w.dropWeap(p);
        assertEquals(10, h.getStrength());
        assertEquals(12, h.getAgility());
        assertFalse(p.hasWeapon());
        assertNull(p.getWeapon());
    }
}
