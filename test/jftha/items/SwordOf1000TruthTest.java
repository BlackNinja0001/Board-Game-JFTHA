package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SwordOf1000TruthTest {
    
    Hero hero = new Barbarian();
    Hero enemy = new Ninja();
    
    public SwordOf1000TruthTest() {
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
        Item item = new SwordOf1000Truth();
        assertEquals(RarityEnum.rare, item.getRarity());
        assertEquals("Sword of 1000 Truths: -5 Strength, -10 MP\n" + "Effect: Reduce opponent MP to zero", item.getMessage());
        assertEquals(100, item.getGoldCost());
    }

    @Test
    public void testEquipWeapon() {
        SwordOf1000Truth a = new SwordOf1000Truth();
        hero.addItem(a);
        a.equipWeap(hero);
        assertEquals(7, hero.getStrength());
        assertEquals(20, hero.getMaxMP());
        assertEquals(20, hero.getCurrentMP());
        assertTrue(hero.getWeaponEquipped());
        assertEquals(a, hero.getWeapon());
    }
    
    @Test
    public void testDropWeapon() {
        SwordOf1000Truth a = new SwordOf1000Truth();
        hero.addItem(a);
        a.equipWeap(hero);
        a.dropWeap(hero);
        assertEquals(12, hero.getStrength());
        assertEquals(30, hero.getMaxMP());
        assertEquals(20, hero.getCurrentMP());
        assertFalse(hero.getWeaponEquipped());
        assertNull(hero.getWeapon());
    }
    
    @Test
    public void testTriggerEffect() {
        SwordOf1000Truth a = new SwordOf1000Truth();
        hero.addItem(a);
        a.equipWeap(hero);
        hero.attackEnemy(enemy);
        assertEquals(0, enemy.getCurrentMP());
    }
    
    @Test
    public void testTriggerEffectOnGhostMakesEliminated() {
        
    }
}
