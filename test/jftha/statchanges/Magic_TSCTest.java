package jftha.statchanges;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Magic_TSCTest {
    Hero h;
    Magic_TSC magic;
    
    public Magic_TSCTest() {
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
        magic = new Magic_TSC(2,1);
        assertEquals(8, h.getMagic());
        h.addTSC(magic);
        h.activateTSCs();
        assertEquals(9, h.getMagic());//turn 1
        h.activateTSCs();
        assertEquals(9, h.getMagic());//turn 2
        h.activateTSCs();
        assertEquals(8, h.getMagic());//turn 3
    }
    
    @Test
    public void testNegativeTempStatChange() {
        magic = new Magic_TSC(2,-1);
        assertEquals(8, h.getMagic());
        h.addTSC(magic);
        h.activateTSCs();
        assertEquals(7, h.getMagic());//turn 1
        h.activateTSCs();
        assertEquals(7, h.getMagic());//turn 2
        h.activateTSCs();
        assertEquals(8, h.getMagic());//turn 3
    }
    
}
