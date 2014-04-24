package jftha.items;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class IronSwordTest {
    
    Player p = new Player("", new Knight());
    
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
        Item item = p.getCharacter().getItems().get(1);
        assertEquals(RarityEnum.common, item.getRarity());
        assertEquals("Iron Sword: +2 Strength", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipWeapon() {
        Hero h = p.getCharacter();
        IronSword w = (IronSword)h.getItems().get(1);
        w.equipWeap(p);
        assertEquals(12, h.getStrength());
        assertTrue(p.hasWeapon());
        assertEquals(w, p.getWeapon());
    }

    @Test
    public void testDropWeapon() {
        Hero h = p.getCharacter();
        IronSword w = (IronSword)h.getItems().get(1);
        w.equipWeap(p);
        w.dropWeap(p);
        assertEquals(10, h.getStrength());
        assertFalse(p.hasWeapon());
        assertNull(p.getWeapon());
    }
}
