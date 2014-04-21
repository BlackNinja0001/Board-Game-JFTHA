package jftha.statchanges;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CurHP_SCPTTest {
    
    CurHP_SCPT curHP;
    Hero h;
    
    public CurHP_SCPTTest() {
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
    public void testPerTurnStatChangeCurHP() {
        h.setCurrentHP(40);
        curHP = new CurHP_SCPT(2,3);
        assertEquals(40, h.getCurrentHP());
        h.addTSC(curHP);
        h.activateTSCs();
        assertEquals(43, h.getCurrentHP());//turn 1
        h.activateTSCs();
        assertEquals(46, h.getCurrentHP());//turn 2
        h.activateTSCs();
        assertEquals(46, h.getCurrentHP());//turn 3
    }
    
    @Test
    public void testNegativeTempStatChange() {
        curHP = new CurHP_SCPT(2,-2);
        assertEquals(60, h.getCurrentHP());
        h.addTSC(curHP);
        h.activateTSCs();
        assertEquals(58, h.getCurrentHP());//turn 1
        h.activateTSCs();
        assertEquals(56, h.getCurrentHP());//turn 2
        h.activateTSCs();
        assertEquals(56, h.getCurrentHP());//turn 3
    }
}
