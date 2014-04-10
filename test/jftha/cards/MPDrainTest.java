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
    Player player1 = new Player("Lancelot", new Knight());
    Player player2 = new Player("Conan", new Barbarian());
    
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
    public void testOnePlayerVSMob() {
        Hero h = player1.getCharacter();
        int curMP = h.getCurrentMP();
        card.triggerEffect(player1);
        int diff = curMP - h.getCurrentMP();
        assertTrue(h.getCurrentMP() <= curMP);
        assertTrue(diff < 50 && diff >= 0);
    }
    
    @Test
    public void testOnePlayerMessage() {
        Hero h = player1.getCharacter();
        int curMP = h.getCurrentMP();
        card.triggerEffect(player1);
        int diff = curMP - h.getCurrentMP();
        String msg = card.getMessage();
        msg = msg.replace("You were ambushed by an angry mob who thought you were a witch. They have sapped ", "");
        msg = msg.replace(" MP from you.", "");
        assertEquals(Integer.parseInt(msg), diff);
    }
    
    @Test
    public void testDrainEliminatesGhost() {
        Hero h = player1.getCharacter();
        h.makeGhost();
        int curMP = 1;
        h.setCurrentMP(curMP);
        card.triggerEffect(player1);
        assertTrue(h.getEliminated());
    }
    
    @Test
    public void testTwoPlayers() {
        Hero hero = player1.getCharacter();
        Hero enemy = player2.getCharacter();
        hero.setCurrentMP(1);
        int heroMP = hero.getCurrentMP();
        int enemyMP = enemy.getCurrentMP();
        card.triggerEffect(player1, player2);
        String msg = card.getMessage();
        msg = msg.replace("Lancelot became a magic vampire for 10 seconds and drained ", "");
        msg = msg.replace(" MP from you.", "");
        int diff = Integer.parseInt(msg);
        assertEquals(diff, hero.getCurrentMP() - heroMP);
        assertEquals(diff, enemyMP - enemy.getCurrentMP());
    }
    
    @Test
    public void testTwoPlayersOneGhost() {
        Hero hero = player1.getCharacter();
        Hero enemy = player2.getCharacter();
        hero.setCurrentMP(3);
        enemy.makeGhost();
        enemy.setCurrentMP(3);
        int heroMP = hero.getCurrentMP();
        card.triggerEffect(player1, player2);
        String msg = card.getMessage();
        msg = msg.replace("Lancelot became a magic vampire for 10 seconds and drained ", "");
        msg = msg.replace(" MP from you.", "");
        int diff = Integer.parseInt(msg);
        assertEquals(diff, hero.getCurrentMP() - heroMP);
        assertTrue(enemy.getEliminated());
    }
}
