package jftha.spaces;

import jftha.heroes.Hero;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class D2DTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of triggerEffect method, of class D2D.
     */
    @Test
    public void testTriggerEffect_Hero() {
        System.out.println("triggerEffect");
        Hero beingAttacked = null;
        D2D instance = new D2D();
        instance.triggerEffect(beingAttacked);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of triggerEffect method, of class D2D.
     */
    @Test
    public void testTriggerEffect() {
        System.out.println("triggerEffect");
        D2D instance = new D2D();
        instance.triggerEffect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
