package jftha.cards;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InstantDeathTest {
    
    InstantDeath card = new InstantDeath();
    Player p = new Player("", new Barbarian());
    
    public InstantDeathTest() {
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
     * Test of triggerEffect method, of class InstantDeath.
     */
    @Test
    public void testTriggerEffectOnLivingHero() {
        Hero h = p.getCharacter();
        card.triggerEffect(p);
        assertTrue(h.isGhost());
    }
    
    @Test
    public void testTriggerEffectOnGhost(){
        Hero h = p.getCharacter();
        h.makeGhost();
        card.triggerEffect(p);
        assertTrue(h.getEliminated());
    }
}
