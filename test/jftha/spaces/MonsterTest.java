package jftha.spaces;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MonsterTest {
    Space current;
    Hero hero;
    
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
        hero = new Paladin();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testTriggerEffect() {
        current.setActivator(hero);
        int initGold = hero.getGold();
        current.triggerEffect();
        assertEquals((initGold + 10) , hero.getGold());
    }
    
    @Test
    public void testMonsterWinsAgainstWeakHero() {
        hero.setCurrentHP(1);
        current.setActivator(hero);
        current.triggerEffect();
        assertTrue(hero.isGhost());
    }
}