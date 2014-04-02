package jftha.spaces;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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

    /**
     * Test of buyTest method, of class Store.
     */
    @Test
    public void testBuyStorageLimitNoReplacement() {
        String str = "6";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        PrintStream original = System.out;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        Player p = new Player("", new Ninja());
        store.buy(p);
        String[] lines = out.toString().split("\n");
        System.setOut(original);
        assertEquals(lines[lines.length-1], "You chose not to buy anything");
    }

    @Test
    public void testItemStorageLimitReplacement() {
       Player p = new Player("", new Ninja());
        Hero hero = p.getCharacter();
        String str = "3";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        //System.setOut(new PrintStream(out));
        store.buy(p);
    }
    
}
