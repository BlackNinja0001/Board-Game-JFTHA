package jftha.items;

import jftha.heroes.*;
import jftha.main.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DivineBladeTest {
    
    Player p = new Player("", new Paladin());
    
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
        Item item = p.getCharacter().getItems().get(1);
        assertEquals(RarityEnum.common, item.getRarity());
        assertEquals("Divine Blade: +4 Strength", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipArmor() {
        Hero h = p.getCharacter();
        DivineBlade w = (DivineBlade)h.getItems().get(1);
        w.equipWeap(p);
        assertEquals(19, h.getStrength());
        assertTrue(p.hasWeapon());
        assertEquals(w, p.getWeapon());
    }

    @Test
    public void testDropArmor() {
        Hero h = p.getCharacter();
        DivineBlade w = (DivineBlade)h.getItems().get(1);
        w.equipWeap(p);
        w.dropWeap(p);
        assertEquals(15, h.getStrength());
        assertFalse(p.hasWeapon());
        assertNull(p.getWeapon());
    }
}
