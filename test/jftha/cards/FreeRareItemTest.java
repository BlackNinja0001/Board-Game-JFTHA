package jftha.cards;

import jftha.heroes.Hero;
import jftha.heroes.Ninja;
import jftha.main.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FreeRareItemTest {
    FreeRareItem card = new FreeRareItem();
    Player p = new Player("", new Ninja());
    public FreeRareItemTest() {
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
     * Test of triggerEffect method, of class FreeRareItem.
     */
    @Test
    public void testTriggerEffect() {
        Hero h = p.getCharacter();
        card.triggerEffect(p);
        assertEquals(3, h.getItems().size());
        assertEquals(RarityEnum.rare, h.getItems().get(2).getRarity());
    }

}