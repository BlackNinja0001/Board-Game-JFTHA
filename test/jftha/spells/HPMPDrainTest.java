package jftha.spells;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HPMPDrainTest {
    
    public HPMPDrainTest() {
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
        Spell spell = new HPMPDrain();
        assertEquals(10, spell.getGoldCost());
        assertEquals(15, spell.getmpCost());
        assertEquals(5, spell.getMaxDuration());
        assertEquals("HP/MP Drain. Absorb HP/MP from enemy player for 5 turns. Cost 15 MP", spell.getMessage());
    }

    @Test
    public void buySpell() {
        Spell spell = new HPMPDrain();
        Hero hero = new Barbarian();
        int initGold = hero.getGold();
        assertTrue(hero.buy(spell));
        int diff = initGold - hero.getGold();
        assertEquals(spell.getGoldCost(), diff);
    }

    @Test
    public void testCastSpell() {
        AttackSpell spell = new HPMPDrain();
        Hero caster = new Knight();
        Hero enemy = new Mage();
        int initHP = 2, initMP = 2;
        int enemyHP = enemy.getCurrentHP(), enemyMP = enemy.getCurrentMP();
        caster.setCurrentHP(initHP);
        caster.setCurrentMP(initMP);
        spell.castSpell(caster, enemy);
        caster.activateTSCs();
        enemy.activateTSCs();
        int diffHP = caster.getCurrentHP() - initHP;
        int diffMP = caster.getCurrentMP() - initMP;
        assertTrue(diffHP >= 1 || diffMP >=1);
        int enemyHPDiff = enemyHP - enemy.getCurrentHP();
        int enemyMPDiff = enemyMP - enemy.getCurrentMP();
        assertTrue(diffHP == enemyHPDiff || diffMP == enemyMPDiff);
    }
    
}
