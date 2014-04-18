package jftha.spaces;

import jftha.heroes.*;
import jftha.items.*;
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
        assertEquals(3, hero.getItems().size());
        Item item = hero.getItems().get(2);
        for(int i = 0; i < 1000; i++) {
            if(luck > 90) {
                assertEquals(RarityEnum.rare, item.getRarity());
            } else if(luck > 75) {
                assertEquals(RarityEnum.uncommon, item.getRarity());
            } else {
                assertEquals(RarityEnum.common, item.getRarity());
            }
        }
    }
    
    @Test
    public void testItemsReturnedToResurrectedCharacter() {
        Chest instance = new Chest();
        Hero hero = new Ninja();
        hero.makeGhost();
        assertEquals(0, hero.getItems().size());
        hero.unGhost();
        instance.setActivator(hero);
        assertEquals(2, hero.getItems().size());
        assertEquals(hero.getItems().get(0).getClass(), Cloak.class);
        assertEquals(hero.getItems().get(1).getClass(), Dagger.class);
        
    }
    
}
