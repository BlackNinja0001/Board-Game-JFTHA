package jftha.main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {
    
    public MainTest() {
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

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {
        String str = "2\nPlayer1\n1\nPlayer2\n4\n";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        Main.main(new String[]{"main"});
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] lines = out.toString().split("\n");
        
        System.out.println("line1: " + lines[0]);
        assertTrue(lines[0].startsWith("Player 1 is a Barbarian named Player1 and is going"));
        System.out.println("line2: " + lines[1]);
        assertTrue(lines[1].startsWith("Player 2 is a Knight named Player2 and is going"));
    }

    /**
     * Test of winner method, of class Main.
     */
    @Test
    public void testWinner() {
        Player[] players = null;
        Main instance = new Main();
        Player expResult = null;
        Player result = instance.winner(players);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
