package jftha.items;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MageStaffTest {
    
    Player p = new Player("", new Mage());
    
    public MageStaffTest() {
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
        MageStaff item = new MageStaff();
        assertEquals(RarityEnum.common, item.getRarity());
        assertEquals("Mage Staff: +2 Magic, " + "+5 MP", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipWeapon() {
        Hero h = p.getCharacter();
        MageStaff item = new MageStaff();
        item.equipWeap(p);
        assertEquals(14, h.getMagic());
        assertEquals(35, h.getMaxMP());
        assertTrue(p.hasWeapon());
        assertEquals(item, p.getWeapon());
    }

    @Test
    public void testDropWeapon() {
        Hero h = p.getCharacter();
        MageStaff item = new MageStaff();
        item.equipWeap(p);
        item.dropWeap(p);
        assertEquals(12, h.getMagic());
        assertEquals(30, h.getMaxMP());
        assertEquals(30, h.getCurrentMP());
        assertFalse(p.hasWeapon());
        assertNull(p.getWeapon());
    }
}
