/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jftha.spells;

import jftha.heroes.Hero;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shane
 */
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
    public void testGetPetDamage() {
        System.out.println("getPetDamage");
        SummonPet instance = new SummonPet();
        int expResult = 0;
        int result = instance.getPetDamage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPetHealth() {
        System.out.println("getPetHealth");
        SummonPet instance = new SummonPet();
        int expResult = 0;
        int result = instance.getPetHealth();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPetDamage() {
        System.out.println("setPetDamage");
        int petDamage = 0;
        SummonPet instance = new SummonPet();
        instance.setPetDamage(petDamage);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPetHealth() {
        System.out.println("setPetHealth");
        int petHealth = 0;
        SummonPet instance = new SummonPet();
        instance.setPetHealth(petHealth);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRandomizeDamage() {
        System.out.println("randomizeDamage");
        SummonPet instance = new SummonPet();
        int expResult = 0;
        int result = instance.randomizeDamage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRandomizeHealth() {
        System.out.println("randomizeHealth");
        SummonPet instance = new SummonPet();
        int expResult = 0;
        int result = instance.randomizeHealth();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCastSpell_Hero() {
        System.out.println("castSpell");
        Hero caster = null;
        SummonPet instance = new SummonPet();
        instance.castSpell(caster);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCastSpell_Hero_Hero() {
        System.out.println("castSpell");
        Hero caster = null;
        Hero victim = null;
        SummonPet instance = new SummonPet();
        instance.castSpell(caster, victim);
        fail("The test case is a prototype.");
    }
    
}
