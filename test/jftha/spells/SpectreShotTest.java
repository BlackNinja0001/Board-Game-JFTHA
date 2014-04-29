package jftha.spells;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpectreShotTest {
    
    public SpectreShotTest() {
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
        Spell spell = new SpectreShot();
        assertEquals(10, spell.getGoldCost());
        assertEquals(7, spell.getmpCost());
        assertEquals("Spectre Shot. Random magic damage between 5-10 to enemy player. Cost 7 MP", spell.getMessage());
    }

    @Test
    public void buySpell() {
        Spell spell = new SpectreShot();
        Hero hero = new Barbarian();
        int initGold = hero.getGold();
        assertTrue(hero.buy(spell));
        int diff = initGold - hero.getGold();
        assertEquals(spell.getGoldCost(), diff);
    }
    
    @Test
    public void testCastSpell() {
        Spell spell = new SpectreShot();
        Hero caster = new Ninja();
        Hero enemy = new Knight();
        int initMP = caster.getCurrentMP();
        int initHP = enemy.getCurrentHP();
        spell.castSpell(caster, enemy);
        int diff = initMP - caster.getCurrentMP();
        assertEquals(spell.getmpCost(), diff);
        diff = initHP - enemy.getCurrentHP();
        assertTrue(diff >= 5 && diff <= 10); 
    }
}
