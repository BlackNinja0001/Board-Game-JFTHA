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

public class FountainOfYouthTest {
    
    Card card;
    Player player;
    
    public FountainOfYouthTest() {
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
    public void FountainOfYouthCausesImpotence(){
        card = new FountainOfYouth();
        Hero hero = new Ninja();
        player = new Player("Greg", hero);
        int prevHealth = hero.getCurrentHP();
        int prevStr = hero.getStrength();
        card.triggerEffect(player);
        hero.activateTSCs(); //turn elapsed
        assertTrue("Strength should be increased by 2 from " + prevStr + " but is " + hero.getStrength(), (prevStr + 2) == hero.getStrength());
        assertTrue("The penis not mightier than the sword.", prevHealth != hero.getCurrentHP());
    }
}
