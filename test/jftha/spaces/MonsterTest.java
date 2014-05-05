package jftha.spaces;

import jftha.heroes.*;
import jftha.main.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MonsterTest {
    RegularSpace current;
    Player hero;
    
    public MonsterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        current = new Monster();
        hero = new Player("", new Paladin());
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testTriggerEffect() {
        current.setActivator(hero);
        Hero h = hero.getCharacter();
        int initGold = h.getGold();
        current.triggerEffect();
        assertEquals((initGold + 10) , h.getGold());
    }
}