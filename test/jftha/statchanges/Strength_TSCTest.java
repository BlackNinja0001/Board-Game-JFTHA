package jftha.statchanges;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Strength_TSCTest {
    
    Hero h;
    Strength_TSC strength;
    
    public Strength_TSCTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        h = new Ninja();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testTempStatChangeAgility() {
        strength = new Strength_TSC(2,1);
        assertEquals(10, h.getStrength());
        h.addTSC(strength);
        h.activateTSCs();
        assertEquals(11, h.getStrength());//turn 1
        h.activateTSCs();
        assertEquals(11, h.getStrength());//turn 2
        h.activateTSCs();
        assertEquals(10, h.getStrength());//turn 3
    }
    
    @Test
    public void testNegativeTempStatChange() {
        strength = new Strength_TSC(2,-1);
        assertEquals(10, h.getStrength());
        h.addTSC(strength);
        h.activateTSCs();
        assertEquals(9, h.getStrength());//turn 1
        h.activateTSCs();
        assertEquals(9, h.getStrength());//turn 2
        h.activateTSCs();
        assertEquals(10, h.getStrength());//turn 3
    }
}
