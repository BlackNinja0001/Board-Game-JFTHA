package jftha.statchanges;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Defense_TSCTest {
    Hero h;
    Defense_TSC def;
    
    public Defense_TSCTest() {
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
        def = new Defense_TSC(2,1);
        assertEquals(10, h.getDefense());
        h.addTSC(def);
        h.activateTSCs();
        assertEquals(11, h.getDefense());//turn 1
        h.activateTSCs();
        assertEquals(11, h.getDefense());//turn 2
        h.activateTSCs();
        assertEquals(10, h.getDefense());//turn 3
    }
    
    @Test
    public void testNegativeTempStatChange() {
        def = new Defense_TSC(2,-1);
        assertEquals(10, h.getDefense());
        h.addTSC(def);
        h.activateTSCs();
        assertEquals(9, h.getDefense());//turn 1
        h.activateTSCs();
        assertEquals(9, h.getDefense());//turn 2
        h.activateTSCs();
        assertEquals(10, h.getDefense());//turn 3
    }
    
}
