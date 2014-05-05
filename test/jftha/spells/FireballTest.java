package jftha.spells;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FireballTest {
    
    public FireballTest() {
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
        Spell spell = new Fireball();
        assertEquals(10, spell.getGoldCost());
        assertEquals(5, spell.getmpCost());
        assertEquals("Fireball. Random magic damage between 1-5 to enemy player. Cost 5 MP", spell.getMessage());
    }

    @Test
    public void buySpell() {
        Spell spell = new Fireball();
        Hero hero = new Barbarian();
        int initGold = hero.getGold();
        assertTrue(hero.buy(spell));
        int diff = initGold - hero.getGold();
        assertEquals(spell.getGoldCost(), diff);
    }
    
    @Test
    public void testCastSpell() {
        AttackSpell spell = new Fireball();
        Hero caster = new Ninja();
        Hero enemy = new Knight();
        int initMP = caster.getCurrentMP();
        int initHP = enemy.getCurrentHP();
        spell.castSpell(caster, enemy);
        int diff = initMP - caster.getCurrentMP();
        assertEquals(spell.getmpCost(), diff);
        diff = initHP - enemy.getCurrentHP();
        assertTrue(diff >= 1 && diff <= 5); 
    }
    
}
