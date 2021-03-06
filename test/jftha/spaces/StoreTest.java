package jftha.spaces;

import java.io.*;
import jftha.heroes.*;
import jftha.main.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StoreTest {
    
    Store store;
    public StoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        store = new Store();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testStoreGenerats5UniqueItems() {
        Player p = new Player("", new Ninja());
        PrintStream original = System.out;
        String str = "3";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        store.setActivator(p);
        store.triggerEffect();
        String[] lines = out.toString().split("\n");
        System.setOut(original);
        for(int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].substring("Input 1 to buy ".length());
        }
        for(int i = 0; i < lines.length-1; i++) {
            for(int j = i+1; j < lines.length -1; j++) {
                assertNotSame(lines[i], lines[j]);
            }
        }
    }
    
    @Test
    public void testStoreDontBuy() {
        String str = "6";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        PrintStream original = System.out;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        Player p = new Player("", new Ninja());
        store.setActivator(p);
        store.triggerEffect();
        String[] lines = out.toString().split("\n");
        System.setOut(original);
        assertTrue(lines[lines.length-1].contains("You chose not to buy anything"));
    }
    
    @Test
    public void testStoreBuySomething() {
        String str = "3";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        PrintStream original = System.out;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        Player p = new Player("", new Ninja());
        p.getCharacter().setGold(500);
        store.setActivator(p);
        store.triggerEffect();
        String[] lines = out.toString().split("\n");
        System.setOut(original);
        assertTrue(lines[lines.length-2].startsWith("You bought a "));
    }    
    
    @Test
    public void testStoreBuySomethingGoldChange() {
        String str = "3";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        PrintStream original = System.out;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        Player p = new Player("", new Ninja());
        int initGold = 500;
        p.getCharacter().setGold(initGold);
        store.setActivator(p);
        store.triggerEffect();
        String[] lines = out.toString().split("\n");
        System.setOut(original);
        String goldSpent = lines[3];
        goldSpent = goldSpent.replace(" gold", "");
        goldSpent = goldSpent.substring(goldSpent.length()-3).trim();
        String goldLeft = lines[lines.length-1];
        goldLeft = goldLeft.replace("You have ", "").replace(" gold left", "");
        
        assertEquals(Integer.parseInt(goldSpent), initGold - Integer.parseInt(goldLeft));
    }
    
    @Test
    public void testDontHaveEnoughGold() {
        String str = "4";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        PrintStream original = System.out;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        Player p = new Player("", new Ninja());
        int initGold = 5;
        p.getCharacter().setGold(initGold);
        store.setActivator(p);
        store.triggerEffect();
        String[] lines = out.toString().split("\n");
        System.setOut(original);
        String goldLeft = lines[lines.length-1];
        goldLeft = goldLeft.replace("You still have ", "").replace(" gold", "");
        
        assertEquals(initGold, Integer.parseInt(goldLeft));
    }
    
}
