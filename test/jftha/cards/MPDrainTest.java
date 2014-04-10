package jftha.cards;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MPDrainTest {
    
    MPDrain card = new MPDrain();
    Player player1 = new Player("", new Knight());
    Player player2 = new Player("", new Barbarian());
    
    public MPDrainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of triggerEffect method, of class MPDrain.
     */
    @Test
    public void testTriggerEffect() {
        Hero h = player1.getCharacter();
        int curMP = h.getCurrentMP();
        card.triggerEffect(player1);
        int diff = curMP - h.getCurrentMP();
        System.out.println("diff: " + diff);
        assertTrue(h.getCurrentMP() <= curMP);
        assertTrue(diff < 50 && diff >= 0);
    }
    
}
