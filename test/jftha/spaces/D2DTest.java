package jftha.spaces;

import jftha.heroes.*;
import jftha.main.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class D2DTest {
    AttackSpace current;
    Player hero;
    Player enemy;
    public D2DTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        current = new D2D();
        hero = new Player("", new Mage());
        enemy =  new Player("", new Mage());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of triggerEffect method, of class D2D.
     */
    @Test(timeout=50)
    public void testTriggerEffectBothAlive() {
        current.setActivator(hero);
        current.triggerEffect(enemy);
        Hero h = hero.getCharacter();
        Hero e = enemy.getCharacter();
        assertTrue(h.isGhost() || e.isGhost());
        
    }
    
}
