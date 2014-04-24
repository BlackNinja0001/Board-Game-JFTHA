package jftha.items;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SwordOf1000TruthTest {
    
    Player p = new Player("", new Barbarian());
    Player p2 = new Player("", new Ninja());
    
    public SwordOf1000TruthTest() {
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
        Item item = new SwordOf1000Truth();
        assertEquals(RarityEnum.rare, item.getRarity());
        assertEquals("Sword of 1000 Truths: -5 Strength, -10 MP\n" + "Effect: Reduce opponent MP to zero", item.getMessage());
        assertEquals(100, item.getGoldCost());
    }

    @Test
    public void testEquipWeapon() {
        Hero h = p.getCharacter();
        SwordOf1000Truth a = new SwordOf1000Truth();
        h.addItem(a);
        a.equipWeap(p);
        assertEquals(7, h.getStrength());
        assertEquals(20, h.getMaxMP());
        assertEquals(20, h.getCurrentMP());
        assertTrue(p.hasWeapon());
        assertEquals(a, p.getWeapon());
    }
    
    @Test
    public void testDropWeapon() {
        Hero h = p.getCharacter();
        SwordOf1000Truth a = new SwordOf1000Truth();
        h.addItem(a);
        a.equipWeap(p);
        a.dropWeap(p);
        assertEquals(12, h.getStrength());
        assertEquals(30, h.getMaxMP());
        assertEquals(20, h.getCurrentMP());
        assertFalse(p.hasWeapon());
        assertNull(p.getWeapon());
    }
    
    @Test
    public void testTriggerEffect() {
        Hero h = p.getCharacter();
        SwordOf1000Truth a = new SwordOf1000Truth();
        h.addItem(a);
        a.equipWeap(p);
        a.weapEffect(p2);
        assertEquals(0, p2.getCharacter().getCurrentMP());
    }
}
