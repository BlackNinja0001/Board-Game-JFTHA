package jftha.statchanges;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaxMP_TSCTest {
    
    Hero h;
    MaxMP_TSC maxMP;
    
    public MaxMP_TSCTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        h = new Barbarian();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testTempStatChangeAgility() {
        maxMP = new MaxMP_TSC(2,1);
        assertEquals(30, h.getMaxMP());
        h.addTSC(maxMP);
        h.activateTSCs();
        assertEquals(31, h.getMaxMP());//turn 1
        h.activateTSCs();
        assertEquals(31, h.getMaxMP());//turn 2
        h.activateTSCs();
        assertEquals(30, h.getMaxMP());//turn 3
    }
    
    @Test
    public void testNegativeTempStatChange() {
        maxMP = new MaxMP_TSC(2,-1);
        assertEquals(30, h.getMaxMP());
        h.addTSC(maxMP);
        h.activateTSCs();
        assertEquals(29, h.getMaxMP());//turn 1
        h.activateTSCs();
        assertEquals(29, h.getMaxMP());//turn 2
        h.activateTSCs();
        assertEquals(30, h.getMaxMP());//turn 3
    }
}
