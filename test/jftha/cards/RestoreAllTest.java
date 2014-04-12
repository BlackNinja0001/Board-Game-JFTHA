package jftha.cards;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RestoreAllTest {
    
    RestoreAll card = new RestoreAll();
    Player p = new Player("", new Knight());
    
    public RestoreAllTest() {
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
    public void testRestoreAll() {
        Hero h = p.getCharacter();
        h.setCurrentMP(12);
        h.setCurrentHP(2);
        card.triggerEffect(p);
        assertEquals(h.getMaxMP(), h.getCurrentMP());
        assertEquals(h.getMaxHP(), h.getCurrentHP());
    }
    
    @Test
    public void testRestoreAllMessage() {
        card.triggerEffect(p);
        assertEquals("The Almighty One loves you. Restore HP and MP to max.", card.getMessage());
    }
    
    @Test
    public void testRestoreAllGhost() {
        Hero h = p.getCharacter();
        h.makeGhost();
        h.setCurrentMP(12);
        card.triggerEffect(p);
        assertEquals(h.getMaxMP(), h.getCurrentMP());
    }
    
    @Test
    public void testRestoreAllGhostMessage() {
        Hero h = p.getCharacter();
        h.makeGhost();
        card.triggerEffect(p);
        assertEquals("The Almighty One loves you. Restore MP to max.", card.getMessage());
    }
}
