package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MageStaffTest {
    
    Hero hero = new Mage();
    
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
        MageStaff item = new MageStaff();
        item.equipWeap(hero);
        assertEquals(14, hero.getMagic());
        assertEquals(35, hero.getMaxMP());
        assertTrue(hero.hasWeapon());
        assertEquals(item, hero.getWeapon());
    }

    @Test
    public void testDropWeapon() {;
        MageStaff item = new MageStaff();
        item.equipWeap(hero);
        item.dropWeap(hero);
        assertEquals(12, hero.getMagic());
        assertEquals(30, hero.getMaxMP());
        assertEquals(30, hero.getCurrentMP());
        assertFalse(hero.hasWeapon());
        assertNull(hero.getWeapon());
    }
}
