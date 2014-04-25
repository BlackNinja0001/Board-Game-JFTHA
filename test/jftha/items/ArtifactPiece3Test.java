package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArtifactPiece3Test {
    ArtifactPiece3 part1, part2;
    Hero hero;
    
    public ArtifactPiece3Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        part1 = ArtifactPiece3.getInstance();
        part2 = ArtifactPiece3.getInstance();
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
        for(int i = 0; i < 100; i++) {
            part1 = ArtifactPiece3.getInstance();
        
            assertEquals(500, part1.getGoldCost());
            assertEquals(RarityEnum.rare, part1.getRarity());
            if(part1.getOwner() != null) {
                System.out.println(part1.getOwner());
            }
            assertNull(part1.getOwner());
        }
    }
    
    @Test
    public void testOwnerChange() {
        hero.addItem(part1);
        hero.addItem(part2);
        assertEquals(hero, part1.getOwner());
        assertEquals(hero, part2.getOwner());
    }
}
