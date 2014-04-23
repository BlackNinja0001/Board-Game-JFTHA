package jftha.items;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SuitOfArmorTest {
    
    Player p = new Player("", new Knight());
    
    public SuitOfArmorTest() {
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
        assertEquals("Suit of Armor: +2 Defense", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipArmor() {
        Hero h = p.getCharacter();
        SuitOfArmor c = (SuitOfArmor)h.getItems().get(0);
        c.equipArmor(p);
        assertEquals(14, h.getDefense());
    }

    @Test
    public void testDropArmor() {
        Hero h = p.getCharacter();
        SuitOfArmor a = (SuitOfArmor)h.getItems().get(0);
        a.equipArmor(p);
        a.dropArmor(p);
        assertEquals(12, h.getDefense());
    }
}
