package jftha.cards;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FreeGoldTest {
    FreeGold card = new FreeGold();
    Player p = new Player("", new Ninja());
    
    public FreeGoldTest() {
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
     * Test of triggerEffect method, of class FreeGold.
     */
    @Test
    public void testTriggerEffect() {
        Hero hero = p.getCharacter();
        int initGold = hero.getGold();
        double luck = .5 * hero.getLuck();
        card.triggerEffect(p);
        assertTrue(hero.getGold() > initGold);
        int diff = hero.getGold() - initGold;
        assertTrue(diff > luck);
        
    }
}