package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PotionTest {
    
    Hero hero = new Barbarian();
    Item item = new Potion();
    
    public PotionTest() {
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
        assertEquals(RarityEnum.common, item.getRarity());
        assertEquals("Potion: Recover 20HP", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testTriggerEffect() {
        hero.setCurrentHP(3);
        hero.addItem(item);
        item.triggerEffect(hero);
        assertEquals(23, hero.getCurrentHP());
    }
}
