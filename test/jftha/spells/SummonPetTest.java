package jftha.spells;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SummonPetTest {
    
    public SummonPetTest() {
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
        Spell spell = new SummonPet();
        assertEquals(15, spell.getGoldCost());
        assertEquals(30, spell.getmpCost());
        assertEquals(6, spell.getMaxCooldown());
        assertEquals("Summon Pet. Allows hero to summon a pet to his/her side. Cost 30 MP", spell.getMessage());
    }

    @Test
    public void buySpell() {
        Spell spell = new SummonPet();
        Hero hero = new Barbarian();
        int initGold = hero.getGold();
        assertTrue(hero.buy(spell));
        int diff = initGold - hero.getGold();
        assertEquals(spell.getGoldCost(), diff);
    }

    @Test
    public void testCastSpell() {
        SelfSpell spell = new SummonPet();
        Hero caster = new Knight();
        spell.castSpell(caster);
        assertTrue(caster.getHasPet());
    }
}
