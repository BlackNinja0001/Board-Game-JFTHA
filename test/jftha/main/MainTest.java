package jftha.main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import jftha.heroes.*;
import jftha.items.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MainTest {

    Main main;
    public MainTest() {
    }

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
        main = new Main();
        out = new ByteArrayOutputStream();
    }
    
    @After
    public void tearDown() {
        System.setOut(original);
    }

    @Test
    public void test2PlayersNameSelection() {
        int howmany = 2;
        String str = "Player1\n1\nPlayer2\n4\n";
        in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        Scanner scan = new Scanner(System.in);
        System.setOut(new PrintStream(out));
        Player[] players = new Player[howmany];
        Main.playerSelection(howmany, scan, players);
 
        assertTrue(players[0].getCharacter() instanceof Barbarian);
        assertEquals("Player1", players[0].getCustomName());
        assertTrue(players[1].getCharacter() instanceof Knight);
        assertEquals("Player2", players[1].getCustomName());
    }
    
    @Test
    public void test3PlayersNameSelection() {
        int howmany = 3;
        String str = "Player1\n2\nPlayer2\n3\nPlayer3\n5\n";
        in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        Scanner scan = new Scanner(System.in);
        System.setOut(new PrintStream(out));
        Player[] players = new Player[howmany];
        Main.playerSelection(howmany, scan, players);

        assertTrue(players[0].getCharacter() instanceof Ninja);
        assertEquals("Player1", players[0].getCustomName());
        assertTrue(players[1].getCharacter() instanceof Mage);
        assertEquals("Player2", players[1].getCustomName());
        assertTrue(players[2].getCharacter() instanceof MartialArtist);
        assertEquals("Player3", players[2].getCustomName());
    }
    
    @Test
    public void test4PlayersNameSelection() {
        int howmany = 4;
        String str = "Player1\n6\nPlayer2\n7\nPlayer3\n8\nPlayer4\n9\n";
        in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        Scanner scan = new Scanner(System.in);
        System.setOut(new PrintStream(out));
        Player[] players = new Player[howmany];
        Main.playerSelection(howmany, scan, players);
        
        assertTrue(players[0].getCharacter() instanceof Thief);
        assertEquals("Player1", players[0].getCustomName());
        assertTrue(players[1].getCharacter() instanceof Priest);
        assertEquals("Player2", players[1].getCustomName());
        assertTrue(players[2].getCharacter() instanceof Merchant);
        assertEquals("Player3", players[2].getCustomName());
        assertTrue(players[3].getCharacter() instanceof Paladin);
        assertEquals("Player4", players[3].getCustomName());
    }
    
    @Test
    public void testOrderSelection2Players() {
        int howmany = 2;
        String str = "Player1\n1\nPlayer2\n4\n";
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            in = new ByteArrayInputStream(str.getBytes());
            System.setIn(in);
            Scanner scan = new Scanner(System.in);
            System.setOut(new PrintStream(out));
            Dice die = new Dice(howmany);
            Player[] players = new Player[howmany];
            Main.playerSelection(howmany, scan, players);
            main.setTurnOrder(howmany, players, die);
            for(int j = 0; j < howmany; j++) {
                stb.append(players[j].getTurnOrder());
            }
            assertTrue(stb.toString().contains("1"));
            assertTrue(stb.toString().contains("2"));
        }
    }
    
    @Test
    public void testOrderSelection3Players() {
        int howmany = 3;
        String str = "Player1\n1\nPlayer2\n4\nPlayer3\n7\n";
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            in = new ByteArrayInputStream(str.getBytes());
            System.setIn(in);
            Scanner scan = new Scanner(System.in);
            System.setOut(new PrintStream(out));
            Dice die = new Dice(howmany);
            Player[] players = new Player[howmany];
            Main.playerSelection(howmany, scan, players);
            main.setTurnOrder(howmany, players, die);
            for(int j = 0; j < howmany; j++) {
                stb.append(players[j].getTurnOrder());
            }
            assertTrue(stb.toString().contains("1"));
            assertTrue(stb.toString().contains("2"));
            assertTrue(stb.toString().contains("3"));
        }
    }
    
    @Test
    public void testOrderSelection4Players() {
        int howmany = 4;
        String str = "Player1\n1\nPlayer2\n4\nPlayer3\n7\nPlayer4\n5\n";
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            in = new ByteArrayInputStream(str.getBytes());
            System.setIn(in);
            Scanner scan = new Scanner(System.in);
            System.setOut(new PrintStream(out));
            Dice die = new Dice(howmany);
            Player[] players = new Player[howmany];
            Main.playerSelection(howmany, scan, players);
            main.setTurnOrder(howmany, players, die);
            for(int j = 0; j < howmany; j++) {
                stb.append(players[j].getTurnOrder());
            }
            assertTrue(stb.toString().contains("1"));
            assertTrue(stb.toString().contains("2"));
            assertTrue(stb.toString().contains("3"));
            assertTrue(stb.toString().contains("4"));
        }
    }
    
    @Test
    public void testAllPlayersNonExisitant4Players() {
        Player[] players = {new Player("player1", new Paladin()), 
                            new Player("player2", new Barbarian()),
                            new Player("player3", new Ninja()),
                            new Player("player4", new Mage())};
        players[0].getCharacter().setEliminated(true);
        players[1].getCharacter().setEliminated(true);
        players[2].getCharacter().setEliminated(true);
        assertTrue(main.allOpponentsNonExistent(players, 3));
        assertTrue(main.anyoneWon(players) > -1);
    }
    
    @Test
    public void testWinner5ArtifactPieces() {
        Player[] players = {new Player("player1", new Knight()), 
                            new Player("player2", new Barbarian()),
                            new Player("player3", new Ninja()),
                            new Player("player4", new Mage())};
        players[3].getCharacter().addItem(ArtifactPiece1.getInstance());
        players[3].getCharacter().addItem(ArtifactPiece2.getInstance());
        players[3].getCharacter().addItem(ArtifactPiece3.getInstance());
        players[3].getCharacter().addItem(ArtifactPiece4.getInstance());
        players[3].getCharacter().addItem(ArtifactPiece5.getInstance());
        Player res = main.winner(players);
        assertEquals(players[3], res);
    }
    
    @Test
    public void testWinner() {
        Player[] players = {new Player("player1", new Knight()), 
                            new Player("player2", new Barbarian()),
                            new Player("player3", new Ninja()),
                            new Player("player4", new Mage())};
        players[3].setIsWinner(true);
        Player res = main.winner(players);
        assertEquals(res, players[3]);
    }
    

    @Test
    public void testUpWinCount() {
        Player[] players = {new Player("player1", new Paladin()), 
                            new Player("player2", new Barbarian()),
                            new Player("player3", new Ninja()),
                            new Player("player4", new Mage())};
        players[0].getCharacter().makeGhost();
        players[2].getCharacter().makeGhost();
        players[3].getCharacter().makeGhost();
        assertTrue(main.upWinCountValidated(players, 1));
        assertEquals(1, players[1].getWinCount());
    }
    
    @Test
    public void testResetWinCount() {
        Player[] players = {new Player("player1", new Paladin()), 
                            new Player("player2", new Barbarian()),
                            new Player("player3", new Ninja()),
                            new Player("player4", new Mage())};
        players[0].getCharacter().makeGhost();
        players[2].getCharacter().makeGhost();
        players[3].getCharacter().makeGhost();
        main.upWinCountValidated(players, 1);
        players[3].getCharacter().unGhost();
        assertFalse(main.upWinCountValidated(players, 1));
        assertEquals(0, players[1].getWinCount());
    }
    
    @Test
    public void testPlace4Players() {
        System.out.println("place4Players");
        Player[] players = {new Player("player1", new Knight()), 
                            new Player("player2", new Barbarian()),
                            new Player("player3", new Ninja()),
                            new Player("player4", new Mage())};
        int numSpaces = 22;
        Board board = new Board();
        board.generateBoard(numSpaces);
        board.placePlayers(players, numSpaces);
        for(Player p : players) {
            assertEquals(0, p.getCurrentSpace().getSpaceID() % 5);
            System.out.println(p.getCustomName() + " is on space #" 
                    + p.getCurrentSpace().getSpaceID() + " which is a(n) "
                    + p.getCurrentSpace().getSpaceType());
        }
    }
    
    @Test
    public void testPlace3Players() {
        System.out.println("place3Players");
        Player[] players = {new Player("player1", new Knight()), 
                            new Player("player2", new Barbarian()),
                            new Player("player3", new Ninja())};
        int numSpaces = 22;
        Board board = new Board();
        board.generateBoard(numSpaces);
        board.placePlayers(players, numSpaces);
        for(Player p : players) {
            assertEquals(0, p.getCurrentSpace().getSpaceID() % 7);
            System.out.println(p.getCustomName() + " is on space #" 
                    + p.getCurrentSpace().getSpaceID() + " which is a(n) "
                    + p.getCurrentSpace().getSpaceType());
        }
    }
    
    @Test
    public void testPlace2Players() {
        System.out.println("place2Players");
        Player[] players = {new Player("player1", new Knight()), 
                            new Player("player2", new Barbarian())};
        int numSpaces = 22;
        Board board = new Board();
        board.generateBoard(numSpaces);
        board.placePlayers(players, numSpaces);
        for(Player p : players) {
            assertEquals(0, p.getCurrentSpace().getSpaceID() % 11);
            System.out.println(p.getCustomName() + " is on space #" 
                    + p.getCurrentSpace().getSpaceID() + " which is a(n) "
                    + p.getCurrentSpace().getSpaceType());
        }
    }
}
