package jftha.cards;

import jftha.main.Player;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StealGoldTest {
    
    StealGold card = new StealGold();
    Player player1 = new Player("Thief", new Thief());
    Player player2 = new Player("Victim", new Priest());
    
    public StealGoldTest() {
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
    public void testStealGoldMessage() {
        card.triggerEffect(player1, player2);
        String str = "Victim has just invested in Thief's ponzi scheme. As a result, Thief steals ";
        assertTrue(card.getMessage().startsWith(str));
        str = " from Victim";
        assertTrue(card.getMessage().endsWith(str));
    }
    
    @Test
    public void testStealGold() {
        Hero thief = player1.getCharacter();
        Hero victim = player2.getCharacter();
        int thiefInitGold = thief.getGold();
        int victimInitGold = victim.getGold();
        card.triggerEffect(player1, player2);
        int diff = thief.getGold() - thiefInitGold;
        String msg = card.getMessage();
        msg = msg.replace("Victim has just invested in Thief's ponzi scheme. As a result, Thief steals ", "");
        msg = msg.replace(" from Victim", "");
        assertEquals(diff, Integer.parseInt(msg));
        assertEquals(thiefInitGold + Integer.parseInt(msg), thief.getGold());
        assertEquals(Integer.parseInt(msg), victimInitGold - victim.getGold());
    }
    
    @Test
    public void testPoorVictimWontHaveNegativeGold() {
        Hero thief = player1.getCharacter();
        Hero victim = player2.getCharacter();
        int initGold = thief.getGold();
        victim.setGold(1);
        card.triggerEffect(player1, player2);
        assertEquals(initGold + 1, thief.getGold());
        assertEquals(0, victim.getGold());
        
    }
}
