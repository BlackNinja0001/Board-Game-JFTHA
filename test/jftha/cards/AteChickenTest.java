package jftha.cards;

import jftha.heroes.Hero;
import jftha.heroes.Knight;
import jftha.main.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AteChickenTest {
    Card card;
    Player player;
    public AteChickenTest() {
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
    public void AteChickenHealsButCausesDigestion(){
        card = new AteChicken();
        Hero hero = new Knight();
        player = new Player("Jim", hero);
        player.getCharacter().setCurrentHP(30); //allow to heal
        card.triggerEffect(player);
        hero.activateTSCs();
        assertTrue("Player's health should be 35 but is " + player.getCharacter().getCurrentHP(), player.getCharacter().getCurrentHP() == 35);
    }
}
