package jftha.statchanges;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Gold_SCPTTest {
    
    Gold_SCPT gold;
    Hero h;
    
    public Gold_SCPTTest() {
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
        gold = new Gold_SCPT(2,3);
        assertEquals(500, h.getGold());
        h.addTSC(gold);
        h.activateTSCs();
        assertEquals(503, h.getGold());//turn 1
        h.activateTSCs();
        assertEquals(506, h.getGold());//turn 2
        h.activateTSCs();
        assertEquals(506, h.getGold());//turn 3
    }
    
    @Test
    public void testNegativeTempStatChange() {
        gold = new Gold_SCPT(2,-2);
        assertEquals(500, h.getGold());
        h.addTSC(gold);
        h.activateTSCs();
        assertEquals(498, h.getGold());//turn 1
        h.activateTSCs();
        assertEquals(496, h.getGold());//turn 2
        h.activateTSCs();
        assertEquals(496, h.getGold());//turn 3
    }
}
