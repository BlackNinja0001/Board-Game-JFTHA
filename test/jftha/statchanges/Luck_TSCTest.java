package jftha.statchanges;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Luck_TSCTest {
    Hero h;
    Luck_TSC luck;
    
    public Luck_TSCTest() {
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
        luck = new Luck_TSC(2,1);
        assertEquals(10, h.getLuck());
        h.addTSC(luck);
        h.activateTSCs();
        assertEquals(11, h.getLuck());//turn 1
        h.activateTSCs();
        assertEquals(11, h.getLuck());//turn 2
        h.activateTSCs();
        assertEquals(10, h.getLuck());//turn 3
    }
    
    @Test
    public void testNegativeTempStatChange() {
        luck = new Luck_TSC(2,-1);
        assertEquals(10, h.getLuck());
        h.addTSC(luck);
        h.activateTSCs();
        assertEquals(9, h.getLuck());//turn 1
        h.activateTSCs();
        assertEquals(9, h.getLuck());//turn 2
        h.activateTSCs();
        assertEquals(10, h.getLuck());//turn 3
    }
    
}
