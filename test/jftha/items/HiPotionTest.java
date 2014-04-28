package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HiPotionTest {
    
    Hero hero = new Ninja();
    Item item = new HiPotion();
    
    public HiPotionTest() {
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
        assertEquals("Hi-Potion: Recover 50HP", item.getMessage());
        assertEquals(50, item.getGoldCost());
    }

    @Test
    public void testTriggerEffect() {
        hero.setCurrentHP(3);
        hero.addItem(item);
        item.triggerEffect(hero);
        assertEquals(53, hero.getCurrentHP());
    }
}
