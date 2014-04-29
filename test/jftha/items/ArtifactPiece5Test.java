package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArtifactPiece5Test {
    ArtifactPiece5 part1, part2;
    Hero hero;
    
    public ArtifactPiece5Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        part1 = ArtifactPiece5.getInstance();
        part2 = ArtifactPiece5.getInstance();
        hero = new Knight();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testUnique() {
        assertEquals(part1, part2);
    }
    
    @Test
    public void testProperties() {
        assertEquals(500, part1.getGoldCost());
        assertEquals(RarityEnum.rare, part1.getRarity());
        assertNull(part1.getOwner());
    }
    
    @Test
    public void testOwnerChange() {
        hero.addItem(part1);
        assertEquals(1, hero.getArtifacts().size());
        assertEquals(hero, part1.getOwner());
        hero.removeItem(part1);
        assertEquals(0, hero.getArtifacts().size());
        assertNull(part1.getOwner());
    }  
}
