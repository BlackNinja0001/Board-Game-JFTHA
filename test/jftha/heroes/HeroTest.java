package jftha.heroes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import jftha.spells.*;
import jftha.items.*;

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
        enemy = new Hero();
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
    public void testItemStorageLimitNoReplacement() {
        assertEquals(5, hero.getStorageSpace());
        hero.addItem(new AnimalSkin());
        hero.addItem(new Ax());
        hero.addItem(new Cloak());
        hero.addItem(new Dagger());
        hero.addItem(new MageRobe());
        String str = "6";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        boolean res = hero.addItem(new SpellBook());
        assertFalse(res);
    }

    @Test
    public void testItemStorageLimitReplacement() {
        assertEquals(5, hero.getStorageSpace());
        hero.addItem(new AnimalSkin());
        hero.addItem(new Ax());
        hero.addItem(new Cloak());
        hero.addItem(new Dagger());
        hero.addItem(new MageRobe());
        String str = "3";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        boolean res = hero.addItem(new SpellBook());
        assertTrue(res);
        assertEquals(SpellBook.class, hero.getItems().get(3).getClass());
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
    public void attackedHeroSuffersDamage() { 
        hero.setStrength(12);
        enemy.setStrength(12);
        hero.setDefense(5);
        enemy.setDefense(5);
        hero.attackEnemy(enemy);
        assertTrue("Attacker did not attack.", enemy.getCurrentHP() < 60);
    }

    @Test
    public void attackedHeroDiesWhenHPIs0() {
        hero.setStrength(12);
        enemy.setCurrentHP(1);
        hero.attackEnemy(enemy);
        assertTrue("Enemy did not die.", enemy.isGhost());
        assertTrue(enemy.getCurrentHP() <= 0);
        assertEquals(enemy.getMaxMP(), enemy.getCurrentMP());
    }
    
    @Test
    public void ghostsCannotBeHitWithoutSpiritualItem() {
        hero.setStrength(12);
        enemy.makeGhost();
        int prevMP = enemy.getCurrentMP(); //ghost'a MP acts like "HP", but still can be used for spells
        hero.attackEnemy(enemy);
        assertTrue(prevMP == enemy.getCurrentMP());
    }
    
    @Test
    public void testBuy() {
        assertEquals(0, hero.getGold());
        assertFalse(hero.buy(new Fireball()));
        hero.setGold(50);
        assertTrue(hero.buy(new Fireball()));
        assertEquals(40, hero.getGold());
        List<Spell> spells = hero.getSpells();
        boolean thereis = false;
        for(Spell s : spells) {
            if(s.getClass().equals(Fireball.class))
                thereis = true;
        }
        assertTrue(thereis);
    }
    @Test
    public void testGhostsWithNoSpiritualItemsLoseAllItems() {
        hero.addItem(new AnimalSkin());
        hero.addItem(new Ax());
        hero.addItem(new Cloak());
        hero.addItem(new Dagger());
        hero.addItem(new MageRobe());
        hero.makeGhost();
        List i = hero.getItems();
        assertEquals(0, i.size());
    }
    
    @Test
    public void testGhostsKeepsItsSpiritualItems() {
        hero.addItem(new AnimalSkin());
        hero.addItem(new Ax());
        hero.addItem(new Cloak());
        hero.addItem(new Dagger());        
        hero.addItem(new Bible());
        hero.makeGhost();
        List i = hero.getItems();
        assertEquals(1, i.size());
        assertEquals(Bible.class, i.get(0).getClass());
    }
    
    @Test
    public void testGhostsLoseSpells() {
        hero = new Mage();
        assertEquals(2, hero.getSpells().size());
        hero.makeGhost();
        assertEquals(1, hero.getSpells().size());
        assertEquals(SpectreShot.class, hero.getSpells().get(0).getClass());
    }
    
    @Test
    public void testUnghostStatUpdates() {
        hero.makeGhost();
        hero.unGhost();
        assertFalse(hero.isGhost());
        assertTrue(hero.getWasGhost());
        assertEquals(hero.getMaxHP(), hero.getCurrentHP());
    }
    
    @Test
    public void testUnghostReturnsAllSpells() {
        hero = new Mage();
        hero.makeGhost();
        hero.unGhost();
        assertEquals(2, hero.getSpells().size());
        assertEquals(Fireball.class, hero.getSpells().get(0).getClass());
        assertEquals(Shield.class, hero.getSpells().get(1).getClass());
        
    }
    
    @Test
    public void testKnightBecomesInvicibleAfterSpecial(){
        hero = new Knight();
        enemy = new Hero();
        hero.triggerSpecial();
        enemy.attackEnemy(hero);
        assertFalse(hero.getCurrentHP() != hero.getMaxHP());
    }
    
}
