package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AxTest {
    Hero hero = new Barbarian();
    
    public AxTest() {
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
        Item item = hero.getItems().get(1);
        assertEquals(RarityEnum.common, item.getRarity());
        assertEquals("Ax: +2 Strength", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipWeapon() {
        Ax w = (Ax)hero.getItems().get(1);
        w.equipWeap(this.hero);
        assertEquals(14, hero.getStrength());
        assertTrue(this.hero.hasWeapon());
        assertEquals(w, this.hero.getWeapon());
    }

    @Test
    public void testDropWeapon() {
        Ax w = (Ax)hero.getItems().get(1);
        w.equipWeap(this.hero);
        w.dropWeap(this.hero);
        assertEquals(12, hero.getStrength());
        assertFalse(this.hero.hasWeapon());
        assertNull(this.hero.getWeapon());
    }
}
