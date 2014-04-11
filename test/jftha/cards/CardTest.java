package jftha.cards;

import jftha.heroes.*;
import jftha.main.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {
    
    public CardTest(){};
    
    Card card;
    Player player;
    
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
    
    @Test
    public void FountainOfYouthCausesImpotence(){
        card = new FountainOfYouth();
        Hero hero = new Ninja();
        player = new Player("Greg", hero);
        int prevHealth = hero.getCurrentHP();
        int prevStr = hero.getStrength();
        card.triggerEffect(player);
        hero.activateTSCs(); //turn elapsed
        assertTrue("Strength should be increased by 2 from " + prevStr + " but is " + hero.getStrength(), (prevStr + 2) == hero.getStrength());
        assertFalse("The penis not mightier than the sword.", prevHealth != hero.getCurrentHP());
    }
}
