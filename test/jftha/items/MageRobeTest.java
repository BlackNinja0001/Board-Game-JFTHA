package jftha.items;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MageRobeTest {
    
    Player p = new Player("", new Mage());
    
    public MageRobeTest() {
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
        assertEquals("Mage Robe: +2 Magic, " + "+5 MP", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipArmor() {
        Hero h = p.getCharacter();
        MageRobe a = (MageRobe)h.getItems().get(0);
        a.equipArmor(p);
        assertEquals(14, h.getMagic());
        assertEquals(35, h.getMaxMP());
    }

    @Test
    public void testDropArmor() {
        Hero h = p.getCharacter();
        MageRobe a = (MageRobe)h.getItems().get(0);
        a.equipArmor(p);
        a.dropArmor(p);
        assertEquals(12, h.getMagic());
        assertEquals(30, h.getMaxMP());
    }
}
