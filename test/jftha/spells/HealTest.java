package jftha.spells;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HealTest {
    
    public HealTest() {
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
        Spell spell = new Heal();
        assertEquals(10, spell.getGoldCost());
        assertEquals(5, spell.getmpCost());
        assertEquals("Heal. Heals current player between 5-10 HP. Cost 5 MP", spell.getMessage());
    }

    @Test
    public void buySpell() {
        Spell spell = new Heal();
        Hero hero = new Barbarian();
        int initGold = hero.getGold();
        assertTrue(hero.buy(spell));
        int diff = initGold - hero.getGold();
        assertEquals(spell.getGoldCost(), diff);
    }

    @Test
    public void testCastSpell() {
        Spell spell = new Heal();
        Hero caster = new Knight();
        int initHP = 12;
        caster.setCurrentHP(initHP);
        spell.castSpell(caster);
        int diff = caster.getCurrentHP() - initHP;
        System.out.print(diff);
        assertTrue(diff >= 5 && diff <= 10);
    }
    
}
