package jftha.spaces;

import jftha.heroes.*;
import jftha.main.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GoldTest {
    
    public GoldTest() {
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
    public void testGoldSpaceTriggerEffect() {
        Gold space = new Gold();
        Player p = new Player("", new Knight());
        Hero hero = p.getCharacter();
        space.setActivator(p);
        int initGold = hero.getGold();
        space.triggerEffect();
        assertTrue(hero.getGold() > initGold);
        assertTrue((hero.getGold() - initGold) <= 5);
    }
}
