package jftha.items;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShiningArmorTest {
    
    Player p = new Player("", new Paladin());
    
    public ShiningArmorTest() {
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
        assertEquals(RarityEnum.uncommon, item.getRarity());
        assertEquals("Shining Armor: +20 HP, " + "+5 Defense", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testEquipArmor() {
        Hero h = p.getCharacter();
        ShiningArmor a = (ShiningArmor)h.getItems().get(0);
        a.equipArmor(p);
        assertEquals(100, h.getMaxHP());
        assertEquals(20, h.getDefense());
    }

    @Test
    public void testDropArmor() {
        Hero h = p.getCharacter();
        ShiningArmor a = (ShiningArmor)h.getItems().get(0);
        a.equipArmor(p);
        a.dropArmor(p);
        assertEquals(80, h.getMaxHP());
        assertEquals(15, h.getDefense());
    }
}
