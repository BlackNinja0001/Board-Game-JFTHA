package jftha.main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import jftha.heroes.Barbarian;
import jftha.heroes.Mage;
import jftha.heroes.Ninja;
import jftha.heroes.Paladin;
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
    public void test2PlayerNameSelection() {
        String str = "2\nPlayer1\n1\nPlayer2\n4\n";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        Main.main(new String[]{"main"});
        String[] lines = out.toString().split("\n");
        System.setOut(original);
        int len = lines.length;
        assertTrue(lines[len-2].startsWith("Player 1 is a Barbarian named Player1 and is going"));
        assertTrue(lines[len-1].startsWith("Player 2 is a Knight named Player2 and is going"));
    }

    /**
     * Test of winner method, of class Main.
     */
    @Test
    public void testWinner() {
        
        Player[] players = {new Player("player1", new Paladin()), 
                            new Player("player2", new Barbarian()),
                            new Player("player3", new Ninja()),
                            new Player("player4", new Mage())};
        
        fail("The test case is a prototype.");
    }
    
}
