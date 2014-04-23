package jftha.statchanges;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaxHP_TSCTest {
    
    Hero h;
    MaxHP_TSC maxHP;
    
    public MaxHP_TSCTest() {
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
        maxHP = new MaxHP_TSC(2,1);
        assertEquals(60, h.getMaxHP());
        h.addTSC(maxHP);
        h.activateTSCs();
        assertEquals(61, h.getMaxHP());//turn 1
        h.activateTSCs();
        assertEquals(61, h.getMaxHP());//turn 2
        h.activateTSCs();
        assertEquals(60, h.getMaxHP());//turn 3
    }
    
    @Test
    public void testNegativeTempStatChange() {
        maxHP = new MaxHP_TSC(2,-1);
        assertEquals(60, h.getMaxHP());
        h.addTSC(maxHP);
        h.activateTSCs();
        assertEquals(59, h.getMaxHP());//turn 1
        h.activateTSCs();
        assertEquals(59, h.getMaxHP());//turn 2
        h.activateTSCs();
        assertEquals(60, h.getMaxHP());//turn 3
    }
}
