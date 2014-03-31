package jftha.spaces;

import jftha.heroes.Hero;
import jftha.heroes.Mage;
import jftha.items.Item;
import jftha.items.RarityEnum;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChestTest {
    
    public ChestTest() {
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

    /**
     * Test of giveItem method, of class Chest.
     */
    @Test
    public void testGiveItem() {
        Chest instance = new Chest();
        Hero hero = new Mage();
        instance.setActivator(hero);
        int luck = instance.giveItem();
        assertTrue(hero.getItems().size() == 3);
        Item item = hero.getItems().get(2);
        for(int i = 0; i < 100; i++) {
            if(luck > 90)
                assertEquals(item.getRarity(), RarityEnum.rare);
            else if(luck > 75)
                assertEquals(item.getRarity(), RarityEnum.uncommon);
            else 
                assertEquals(item.getRarity(), RarityEnum.common);
        }

    }
    
}
