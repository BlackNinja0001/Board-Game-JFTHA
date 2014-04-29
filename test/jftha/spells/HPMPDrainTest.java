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
    public void testCastSpell_Hero() {
        System.out.println("castSpell");
        Hero caster = null;
        HPMPDrain instance = new HPMPDrain();
        instance.castSpell(caster);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCastSpell_Hero_Hero() {
        System.out.println("castSpell");
        Hero caster = null;
        Hero enemy = null;
        HPMPDrain instance = new HPMPDrain();
        instance.castSpell(caster, enemy);
        fail("The test case is a prototype.");
    }
    
}
