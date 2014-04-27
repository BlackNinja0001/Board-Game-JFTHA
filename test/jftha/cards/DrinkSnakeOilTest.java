package jftha.cards;

import jftha.heroes.Barbarian;
import jftha.heroes.Hero;
import jftha.main.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DrinkSnakeOilTest {
    
    Card card;
    Player player;
    
    public DrinkSnakeOilTest() {
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
    public void SnakeOilCausesPlaceboEffectAndCostsMoney(){
        card = new DrinkSnakeOil();
        Hero hero = new Barbarian(); //12 Strength
        player = new Player("Steve", hero);
        hero.setGold(500);
        card.triggerEffect(player);
        hero.activateTSCs();
        assertTrue("Gold was not taken.", hero.getGold() == 0);
        assertTrue("Hero's strength should be 14 but is " + hero.getStrength(), hero.getStrength() == 14);
    }
}
