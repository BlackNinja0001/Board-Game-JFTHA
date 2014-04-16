package jftha.items;

import jftha.heroes.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class ItemFactoryTest {
    
    ArtifactPiece p1, p2, p3, p4, p5;
    Hero h1, h2;
    
    
    public ItemFactoryTest() {
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

    @Ignore
    @Test(timeout = 50)
    public void testBuildRareItemNotNull() {
        ItemFactory instance = new ItemFactory();
        Item result = instance.buildItem(RarityEnum.rare);
        assertNotNull(result);
    }
    
    @Test
    public void testAllArtifactPiecesTaken() {
        h1 = new Barbarian();
        h2 = new Ninja();
        p1 = ArtifactPiece1.getInstance();
        p2 = ArtifactPiece2.getInstance();
        p3 = ArtifactPiece3.getInstance();
        p4 = ArtifactPiece4.getInstance();
        p5 = ArtifactPiece5.getInstance();
        h1.addArtifact(p1);
        h1.addArtifact(p2);
        h2.addArtifact(p3);
        h2.addArtifact(p4);
        h2.addArtifact(p5);
        ItemFactory instance = new ItemFactory();
        Item result = null;
        for (int i = 0; i < 100; i++) {
            result = instance.buildItem(RarityEnum.rare);
            assertNotNull(result);
            if (ArtifactPiece.class == result.getClass().getSuperclass()) {
                System.err.println("oops");
            }
            assertNotSame(ArtifactPiece.class, result.getClass().getSuperclass());
        }
        
    }
}
