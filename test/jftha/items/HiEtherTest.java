package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HiEtherTest {
    
    Hero hero = new Knight();
    Item item = new HiEther();
    
    public HiEtherTest() {
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
        assertEquals(RarityEnum.uncommon, item.getRarity());
        assertEquals("Hi-Ether: Recover 25MP", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testTriggerEffect() {
        hero.setCurrentMP(3);
        hero.addItem(item);
        item.triggerEffect(hero);
        assertEquals(28, hero.getCurrentMP());
    }
}
