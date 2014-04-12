package jftha.cards;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReviveTest {
    
    Revive card = new Revive();
    Player p = new Player("", new Merchant());
    
    public ReviveTest() {
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

    @Test
    public void testReviveMessage() {
        card.triggerEffect(p);
        assertEquals("You're not dead. Go away.", card.getMessage());
    }
    
    @Test
    public void testReviveGhost() {
        Hero hero = p.getCharacter();
        hero.makeGhost();
        card.triggerEffect(p);
        assertFalse(hero.isGhost());
        assertTrue(hero.getWasGhost());
        assertEquals(hero.getMaxHP(), hero.getCurrentHP());
    }
    
    @Test
    public void testReviveGhostMessage() {
        Hero h = p.getCharacter();
        h.makeGhost();
        card.triggerEffect(p);
        assertEquals("Its your lucky day. Welcome back to the land of the living.", card.getMessage());
        
    }
}
