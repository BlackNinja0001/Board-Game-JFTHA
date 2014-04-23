package jftha.statchanges;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CurMP_SCPTTest {
    
    CurMP_SCPT curMP;
    Hero h;
    
    public CurMP_SCPTTest() {
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
    public void testPerTurnStatChangeCurMP() {
        h.setCurrentMP(10);
        curMP = new CurMP_SCPT(2,3);
        assertEquals(10, h.getCurrentMP());
        h.addTSC(curMP);
        h.activateTSCs();
        assertEquals(13, h.getCurrentMP());//turn 1
        h.activateTSCs();
        assertEquals(16, h.getCurrentMP());//turn 2
        h.activateTSCs();
        assertEquals(16, h.getCurrentMP());//turn 3
    }
    
    @Test
    public void testNegativeTempStatChange() {
        curMP = new CurMP_SCPT(2,-2);
        assertEquals(30, h.getCurrentMP());
        h.addTSC(curMP);
        h.activateTSCs();
        assertEquals(28, h.getCurrentMP());//turn 1
        h.activateTSCs();
        assertEquals(26, h.getCurrentMP());//turn 2
        h.activateTSCs();
        assertEquals(26, h.getCurrentMP());//turn 3
    }
    
}
