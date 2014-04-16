package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArtifactPiece1Test {
    ArtifactPiece1 part1, part2;
    Hero hero;
    
    public ArtifactPiece1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        part1 = ArtifactPiece1.getInstance();
        part2 = ArtifactPiece1.getInstance();
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
        hero.addArtifact(part1);
        hero.addArtifact(part2);
        assertEquals(hero, part1.getOwner());
        assertEquals(hero, part2.getOwner());
    }
    
    
}
