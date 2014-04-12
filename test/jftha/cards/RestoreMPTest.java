package jftha.cards;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RestoreMPTest {
    
    RestoreMP card = new RestoreMP();
    Player p = new Player("", new Barbarian());
    
    public RestoreMPTest() {
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
    public void testRestoreMP() {
        Hero h = p.getCharacter();
        h.setCurrentMP(12);
        card.triggerEffect(p);
        assertEquals(h.getMaxMP(), h.getCurrentMP());
    }
    
    @Test
    public void testRestoreMPMessage() {
        card.triggerEffect(p);
        assertEquals("You got drunk on magic potions. Restore MP to max.", card.getMessage());
    }
}
