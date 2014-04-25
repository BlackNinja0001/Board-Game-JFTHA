package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DaggerTest {
    
    Hero hero = new Ninja();
    
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
        Item item = hero.getItems().get(1);
        assertEquals(RarityEnum.common, item.getRarity());
        assertEquals("Dagger: +2 Strength, +1 Agility", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipWeapon() {
        Dagger w = (Dagger)hero.getItems().get(1);
        w.equipWeap(this.hero);
        assertEquals(12, hero.getStrength());
        assertEquals(13, hero.getAgility());
        assertTrue(this.hero.hasWeapon());
        assertEquals(w, this.hero.getWeapon());
    }

    @Test
    public void testDropWeapon() {
        Dagger w = (Dagger)hero.getItems().get(1);
        w.equipWeap(this.hero);
        w.dropWeap(this.hero);
        assertEquals(10, hero.getStrength());
        assertEquals(12, hero.getAgility());
        assertFalse(this.hero.hasWeapon());
        assertNull(this.hero.getWeapon());
    }
}
