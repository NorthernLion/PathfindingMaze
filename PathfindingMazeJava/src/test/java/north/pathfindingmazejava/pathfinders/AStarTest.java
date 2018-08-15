package north.pathfindingmazejava.pathfinders;


import north.pathfindingmazejava.logic.Tile;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AStarTest {
    AStar readyMade;
    Tile added;
    Tile added2;
    Tile added3;
    Tile added4;
    
    

    @Before
    public void setUp() {
        readyMade = new AStar();
        added = new Tile (5, 10);
        added2 = new Tile(0, 10);
        added3 = new Tile(10, 20);
        added4 = new Tile(2, 4);
    }
    
    @Test
    public void testManhattan() {
        assertEquals(readyMade.manhattanDistance(added, added2), 5);
        assertEquals(readyMade.manhattanDistance(added3, added2), 20);
        assertEquals(readyMade.manhattanDistance(added, added4), 9);
        assertEquals(readyMade.manhattanDistance(added4, added2), 8);
    }

    @Test
    public void testEuclidean() {
        assertEquals(readyMade.euclideanDistance(added, added2), 5);
        assertEquals(readyMade.euclideanDistance(added3, added2), 14);
        assertEquals(readyMade.euclideanDistance(added, added4), 6);
        assertEquals(readyMade.euclideanDistance(added4, added2), 6);
    }
}
