package jftha.items;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AxTest {
    Player p = new Player("", new Barbarian());
    
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
        Item item = p.getCharacter().getItems().get(1);
        assertEquals(RarityEnum.common, item.getRarity());
        assertEquals("Ax: +2 Strength", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipArmor() {
        Hero h = p.getCharacter();
        Ax a = (Ax)h.getItems().get(1);
        a.equipWeap(p);
        assertEquals(14, h.getStrength());
    }

    @Test
    public void testDropArmor() {
        Hero h = p.getCharacter();
        Ax a = (Ax)h.getItems().get(1);
        a.equipWeap(p);
        a.dropWeap(p);
        assertEquals(12, h.getStrength());
    }
}
