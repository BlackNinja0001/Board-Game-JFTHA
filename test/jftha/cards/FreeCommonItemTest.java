package jftha.cards;

import jftha.heroes.*;
import jftha.main.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FreeCommonItemTest {
    
    FreeCommonItem card;
    Player p;
    
    public FreeCommonItemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        card = new FreeCommonItem();
        p = new Player("", new Ninja());
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testTriggerEffect() { //Sometimes this fails
        Hero h = p.getCharacter();
        card.triggerEffect(p);
        assertEquals(3, h.getItems().size());
        assertEquals(jftha.items.RarityEnum.common, h.getItems().get(2).getRarity());
    }
}