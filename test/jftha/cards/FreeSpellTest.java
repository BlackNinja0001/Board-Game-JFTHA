package jftha.cards;

import jftha.heroes.*;
import jftha.main.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FreeSpellTest {
    FreeSpell card = new FreeSpell();
    Player p = new Player("", new Ninja());
    
    public FreeSpellTest() {
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
     * Test of triggerEffect method, of class FreeSpell.
     */
    @Test
    public void testTriggerEffect() {
        Hero h = p.getCharacter();
        card.triggerEffect(p);
        assertEquals(1, h.getSpells().size());
    }
}
