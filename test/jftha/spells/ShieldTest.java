package jftha.spells;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShieldTest {
    
    public ShieldTest() {
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
        Spell spell = new Shield();
        assertEquals(10, spell.getGoldCost());
        assertEquals(5, spell.getmpCost());
        assertEquals(5, spell.getMaxCooldown());
        assertEquals(2, spell.getMaxDuration());
        assertEquals("Shield. Temporarily increase defense(1-3) for 2 turns. Cost 5 MP", spell.getMessage());
    }

    @Test
    public void buySpell() {
        Spell spell = new Shield();
        Hero hero = new Barbarian();
        int initGold = hero.getGold();
        assertTrue(hero.buy(spell));
        int diff = initGold - hero.getGold();
        assertEquals(spell.getGoldCost(), diff);
    }

    @Test
    public void testCastSpell() {
        SelfSpell spell = new Shield();
        Hero caster = new Knight();
        int initDef = 2;
        caster.setDefense(initDef);
        spell.castSpell(caster);
        caster.activateTSCs();
        int diff = caster.getDefense() - initDef;
        assertTrue(diff >= 1 && diff <= 3);
    }
    
}
