package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ElixirTest {
    
    Elixir elixir = new Elixir();
    Hero hero = new Mage();
    
    public ElixirTest() {
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
    public void testProperties() {
        assertEquals(RarityEnum.rare, elixir.getRarity());
        assertEquals("Elixir: fully Recover HP/MP", elixir.getMessage());
        assertEquals(50, elixir.getGoldCost());
    }

    @Test
    public void testTriggerEffect() {
        hero.setCurrentMP(3);
        hero.setCurrentHP(2);
        hero.addItem(elixir);
        elixir.triggerEffect(hero);
        assertEquals(hero.getMaxHP(), hero.getCurrentHP());
        assertEquals(hero.getMaxMP(), hero.getCurrentMP());
    }
}
