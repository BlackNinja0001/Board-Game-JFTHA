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
    InputStream in;
    OutputStream out;
    PrintStream original = System.out;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        hero = new Barbarian();
        enemy = new Mage();
        out = new ByteArrayOutputStream();
    }

    @After
    public void tearDown() {
        System.setOut(original);
    }
    
    /**
     * Test to ensure that spell_slots is the maximum amount of spells
     */
    @Test
    public void testSpellStorageLimitNoReplacement() {
        assertEquals(2, hero.getSpellSlots());
        hero.addSpell(new Shield());
        hero.addSpell(new Heal());

        String str = "3";
        in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(out));
        boolean res = hero.addSpell(new Fireball());
        assertFalse(res);
    }

    @Test
    public void testSpellLimitReplacement() {
        assertEquals(2, hero.getSpellSlots());
        hero.addSpell(new Fireball());
        hero.addSpell(new SummonPet());
        String str = "1";
        in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(out));
        boolean res = hero.addSpell(new HPMPDrain());
        assertTrue(res);
        assertEquals(HPMPDrain.class, hero.getSpells().get(0).getClass());
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
        in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
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
        in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(out));
        boolean res = hero.addItem(new SpellBook());
        assertTrue(res);
        assertEquals(SpellBook.class, hero.getItems().get(2).getClass());
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
        assertEquals("Hero starts with wrong number of items", 2, hero.getItems().size());
        assertTrue("Enemy did not die.", enemy.isGhost());
        assertTrue("Enemy has positive HP as ghost.", enemy.getCurrentHP() <= 0);
        assertEquals(enemy.getMaxMP(), enemy.getCurrentMP());      
    }
    
    @Test
    public void ghostsCannotBeHitWithoutSpiritualItem() {
        hero.setStrength(12);
        enemy.makeGhost();
        int prevMP = enemy.getCurrentMP(); //ghost'a MP acts like "HP", but still can be used for spells
        hero.attackEnemy(enemy);
        assertEquals(prevMP, enemy.getCurrentMP());
    }
    
    @Test
    public void testBuy() {
        assertEquals(500, hero.getGold());
        Spell fireball = new Fireball();
        assertTrue("Hero did not buy spell.", hero.buy(fireball));
        assertEquals(fireball.getGoldCost(), 500 - hero.getGold());
        List<Spell> spells = hero.getSpells();
        boolean thereis = false;
        for(Spell s : spells) {
            if(s.getClass().equals(Fireball.class))
                thereis = true;
        }
        assertTrue("Hero does not have spell.", thereis);
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
        assertEquals("Ghost kept nonspiritual items.", 0, i.size());
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
        assertEquals("Hero has wrong number of items.", 1, i.size());
        assertEquals("Ghost didn't keep spiritual item.", Bible.class, i.get(0).getClass());
    }
    
    @Test
    public void testGhostsGainSpectreShot() {
        hero = new Mage();
        assertEquals(2, hero.getSpells().size());
        hero.makeGhost();
        assertEquals(3, hero.getSpells().size());
        assertEquals(SpectreShot.class, hero.getSpells().get(2).getClass());
    }
    
    @Test
    public void testUnghostStatUpdates() {
        hero.makeGhost();
        hero.unGhost();
        assertFalse("Hero is still a ghost", hero.isGhost());
        assertTrue("Hero was never a ghost", hero.getWasGhost());
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
        enemy = new Barbarian();
        hero.triggerSpecial();
        enemy.attackEnemy(hero);
        assertEquals(hero.getCurrentHP(), hero.getMaxHP());
    }
    
    @Test
    public void testRemoveItem() {
        hero = new Knight();
        Item item = hero.getItems().get(0);
        assertTrue(hero.removeItem(item));
        assertEquals(1, hero.getItems().size());
        assertTrue(hero.getItems().get(0) instanceof IronSword); 
    }
    
    /**
     * Test of setStrength method, of class Hero.
     */
    @Test
    public void testSetStrength() {
        assertEquals(12, hero.getStrength());
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
        assertEquals(8, hero.getMagic());
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

    @Test
    public void testSetMaxHP() {
        assertEquals(60, hero.getMaxHP());
        int hp = 55;
        hero.setMaxHP(hp);
        assertEquals(hp, hero.getMaxHP());
        assertEquals(hp, hero.getCurrentHP());
    }

    /**
     * Test of setMaxMP method, of class Hero.
     */
    @Test
    public void testSetMaxMP() {
        assertEquals(30, hero.getMaxMP());
        int mp = 25;
        hero.setMaxMP(mp);
        assertEquals(mp, hero.getMaxMP());
        assertEquals(mp, hero.getCurrentMP());
    }
}
