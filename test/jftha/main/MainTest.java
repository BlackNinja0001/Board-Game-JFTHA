package jftha.main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    Main main;
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
        main = new Main();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test2PlayersNameSelection() {
        String str = "2\nPlayer1\n1\nPlayer2\n4\n";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        Main.main(new String[]{});
        String[] lines = out.toString().split("\n");
        System.setOut(original);
        int len = lines.length;
        assertTrue(lines[len-2].startsWith("Player 1 is a Barbarian named Player1"));
        assertTrue(lines[len-1].startsWith("Player 2 is a Knight named Player2"));
    }
    
    @Test
    public void test3PlayersNameSelection() {
        String str = "3\nPlayer1\n2\nPlayer2\n3\nPlayer3\n5\n";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        Main.main(new String[]{});
        String[] lines = out.toString().split("\n");
        System.setOut(original);
        int len = lines.length;
        assertTrue(lines[len-3].startsWith("Player 1 is a Ninja named Player1"));
        assertTrue(lines[len-2].startsWith("Player 2 is a Mage named Player2"));
        assertTrue(lines[len-1].startsWith("Player 3 is a Martial Artist named Player3"));
    }
    
    @Test
    public void test4PlayersNameSelection() {
        String str = "4\nPlayer1\n6\nPlayer2\n7\nPlayer3\n8\nPlayer4\n9\n";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        Main.main(new String[]{});
        String[] lines = out.toString().split("\n");
        System.setOut(original);
        int len = lines.length;
        assertTrue(lines[len-4].startsWith("Player 1 is a Thief named Player1"));
        assertTrue(lines[len-3].startsWith("Player 2 is a Priest named Player2"));
        assertTrue(lines[len-2].startsWith("Player 3 is a Merchant named Player3"));
        assertTrue(lines[len-1].startsWith("Player 4 is a Paladin named Player4"));
    }
    
    @Test
    public void testOrderSelection2Players() {
        String str = "2\nPlayer1\n1\nPlayer2\n4\n";
        StringBuilder stb = new StringBuilder();
        String[] lines;
        for(int i = 0; i < 100; i++) {
            InputStream in = new ByteArrayInputStream(str.getBytes());
            System.setIn(in);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            Main.main(new String[]{});
            lines = out.toString().split("\n");
            int len = lines.length;
            for(int j = 1; j <= 2; j++) {
                int linelen = lines[len-j].length();
                stb.append(lines[len-j].charAt(linelen-4));
            }
        assertTrue(stb.toString().contains("1"));
        assertTrue(stb.toString().contains("2"));
        }
    }
    
    @Test
    public void testOrderSelection3Players() {
        String str = "3\nPlayer1\n1\nPlayer2\n4\nPlayer3\n7\n";
        StringBuilder stb = new StringBuilder();
        String[] lines;
        for(int i = 0; i < 100; i++) {
            InputStream in = new ByteArrayInputStream(str.getBytes());
            System.setIn(in);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            Main.main(new String[]{});
            lines = out.toString().split("\n");
            int len = lines.length;
            for(int j = 1; j <= 4; j++) {
                int linelen = lines[len-j].length();
                stb.append(lines[len-j].charAt(linelen-4));
            }
        assertTrue(stb.toString().contains("1"));
        assertTrue(stb.toString().contains("2"));
        assertTrue(stb.toString().contains("3"));
        }
    }
    
    @Test
    public void testOrderSelection4Players() {
        String str = "4\nPlayer1\n1\nPlayer2\n4\nPlayer3\n7\nPlayer4\n5\n";
        StringBuilder stb = new StringBuilder();
        String[] lines;
        for(int i = 0; i < 100; i++) {
            InputStream in = new ByteArrayInputStream(str.getBytes());
            System.setIn(in);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            Main.main(new String[]{});
            lines = out.toString().split("\n");
            int len = lines.length;
            for(int j = 1; j <= 4; j++) {
                int linelen = lines[len-j].length();
                stb.append(lines[len-j].charAt(linelen-4));
            }
        assertTrue(stb.toString().contains("1"));
        assertTrue(stb.toString().contains("2"));
        assertTrue(stb.toString().contains("3"));
        assertTrue(stb.toString().contains("4"));
        }
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
        players[3].setIsWinner(true);
        Player winner = main.winner(players);
        System.out.print(winner);
        fail("The test case is a prototype.");
    }
    
}
