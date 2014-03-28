package jftha.main;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
        InputStream is = new ByteArrayInputStream("2\nPlayer1\n1\nPlayer2\n4".getBytes());
        Main main = new Main();
        
    }

    /**
     * Test of winner method, of class Main.
     */
    @Test
    public void testWinner() {
        System.out.println("winner");
        Player[] players = null;
        Main instance = new Main();
        Player expResult = null;
        Player result = instance.winner(players);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
