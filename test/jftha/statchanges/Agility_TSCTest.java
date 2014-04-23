package jftha.statchanges;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Agility_TSCTest {
    Hero h;
    Agility_TSC agil;
    public Agility_TSCTest() {
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
        agil = new Agility_TSC(2,1);
        assertEquals(10, h.getAgility());
        h.addTSC(agil);
        h.activateTSCs();
        assertEquals(11, h.getAgility());//turn 1
        h.activateTSCs();
        assertEquals(11, h.getAgility());//turn 2
        h.activateTSCs();
        assertEquals(10, h.getAgility());//turn 3
    }
    
    @Test
    public void testNegativeTempStatChange() {
        agil = new Agility_TSC(2,-1);
        assertEquals(10, h.getAgility());
        h.addTSC(agil);
        h.activateTSCs();
        assertEquals(9, h.getAgility());//turn 1
        h.activateTSCs();
        assertEquals(9, h.getAgility());//turn 2
        h.activateTSCs();
        assertEquals(10, h.getAgility());//turn 3
    }
    
}
