/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jftha.heroes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import jftha.spells.*;
import jftha.items.*;

/**
 *
 * @author tue75856
 */
public class HeroTest {

    public HeroTest() {
    }
    Hero hero;
    Hero enemy;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        hero = new Hero();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setStrength method, of class Hero.
     */
    @Test
    public void testSetStrength() {
        assertEquals(10, hero.getStrength());
        int strength = 15;
        hero.setStrength(strength);
        assertEquals(strength, hero.getStrength());
    }

    /**
     * Test of setAgility method, of class Hero.
     */
    @Test
    public void testSetAgility() {
        assertEquals(10, hero.getAgility());
        int agility = 15;
        hero.setAgility(agility);
        assertEquals(agility, hero.getAgility());
    }

    /**
     * Test of setMagic method, of class Hero.
     */
    @Test
    public void testSetMagic() {
        assertEquals(10, hero.getMagic());
        int magic = 15;
        hero.setMagic(magic);
        assertEquals(magic, hero.getMagic());
    }

    /**
     * Test of setDefense method, of class Hero.
     */
    @Test
    public void testSetDefense() {
        assertEquals(10, hero.getDefense());
        int defense = 15;
        hero.setDefense(defense);
        assertEquals(defense, hero.getDefense());
    }

    /**
     * Test of setLuck method, of class Hero.
     */
    @Test
    public void testSetLuck() {
        assertEquals(10, hero.getLuck());
        int luck = 15;
        hero.setLuck(luck);
        assertEquals(luck, hero.getLuck());
    }

    /**
     * Test of setStorageSpace method, of class Hero.
     */
    @Test
    public void testSetStorageSpace() {
        assertEquals(5, hero.getStorageSpace());
        int storage_space = 7;
        hero.setStorageSpace(storage_space);
        assertEquals(storage_space, hero.getStorageSpace());
    }

    /**
     * Test of setSpellSlots method, of class Hero.
     */
    @Test
    public void testSetSpellSlots() {
        assertEquals(2, hero.getSpellSlots());
        int spell_slots = 4;
        hero.setSpellSlots(spell_slots);
        assertEquals(spell_slots, hero.getSpellSlots());
    }

    /**
     * Test of setMaxHP method, of class Hero.
     */
    @Test
    public void testSetHP() {
        assertEquals(60, hero.getMaxHP());
        int hp = 55;
        hero.setMaxHP(hp);
        assertEquals(hp, hero.getMaxHP());
    }

    /**
     * Test of setMaxMP method, of class Hero.
     */
    @Test
    public void testSetMP() {
        assertEquals(30, hero.getMaxMP());
        int mp = 25;
        hero.setMaxMP(mp);
        assertEquals(mp, hero.getMaxMP());
    }

    /**
     * Test to ensure that spell_slots is the maximum amount of spells
     */
    @Test
    public void testSpellStorageLimit() {
        assertEquals(2, hero.getSpellSlots());
        hero.addSpell(new Heal());
        hero.addSpell(new Fireball());
        assertFalse(hero.addSpell(new Shield()));
    }

    /**
     * Test to ensure that storage_space is the maximum amount of items
     */
    @Test
    public void testItemStorageLimit() {
        assertEquals(5, hero.getStorageSpace());
        hero.addItem(new AnimalSkin());
        hero.addItem(new Ax());
        hero.addItem(new Cloak());
        hero.addItem(new Dagger());
        hero.addItem(new MageRobe());
        assertFalse(hero.addItem(new SpellBook()));
    }

    @Test
    public void testForNoDuplicateItems() {
        hero.addItem(new Ax());
        assertFalse(hero.addItem(new Ax()));
    }

    @Test
    public void testForNoDuplicateSpells() {
        hero.addSpell(new Heal());
        assertFalse(hero.addSpell(new Heal()));
    }

    @Test
    public void attackingReturnsCorrectValues() {
        hero = new Hero();
        enemy = new Hero();
        hero.attackEnemy(enemy);
        assertFalse("Attacker did not attack.", hero.getCurrentHP() != 60); //was attacked
        assertFalse("Attacked did not attack back.", enemy.getCurrentHP() != 60); //attacker did retaliate
    }
}