package jftha.spaces;

import jftha.heroes.*;
import jftha.items.*;
import jftha.main.Player;
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
        Chest space = new Chest();
        Player p = new Player("", new Mage());
        Hero hero = p.getCharacter();
        space.setActivator(p);
        space.triggerEffect();
        assertEquals(3, hero.getItems().size() + hero.getArtifacts().size());
    }
    
    @Test
    public void testItemsReturnedToResurrectedCharacter() {
        Chest space = new Chest();
        Player p = new Player("", new Ninja());
        Hero hero = p.getCharacter();
        hero.makeGhost();
        assertEquals(0, hero.getItems().size());
        hero.unGhost();
        space.setActivator(p);
        space.triggerEffect();
        assertEquals(2, hero.getItems().size());
        assertEquals(hero.getItems().get(0).getClass(), Cloak.class);
        assertEquals(hero.getItems().get(1).getClass(), Dagger.class);
        
    }
    
}
