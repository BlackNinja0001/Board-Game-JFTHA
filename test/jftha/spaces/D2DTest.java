package jftha.spaces;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class D2DTest {
    Space current;
    Hero hero;
    Hero enemy;
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
        hero = new Mage();
        enemy = new Ninja();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of triggerEffect method, of class D2D.
     */
    @Test(timeout=100)
    public void testTriggerEffectBothAlive() {
        current.setActivator(hero);
        current.triggerEffect(enemy);
        assertTrue(hero.isGhost() || enemy.isGhost());
        
    }
    
}
