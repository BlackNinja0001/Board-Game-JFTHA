package jftha.cards;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RandomDamageTest {
    
    RandomDamage card = new RandomDamage();
    Player player = new Player("", new Mage());
    
    public RandomDamageTest() {
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
    public void testAliveHPDamage() {
        Hero h = player.getCharacter();
        card.triggerEffect(player);
    }
    
    @Test
    public void testGhostMPDamage() {
        
    }
    
    @Test
    public void testGhostLowMPEliminated() {
        
    }
    
}
