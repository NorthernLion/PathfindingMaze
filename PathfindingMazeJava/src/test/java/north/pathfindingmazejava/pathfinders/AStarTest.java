package north.pathfindingmazejava.pathfinders;


import north.pathfindingmazejava.datastructures.ArrayList;
import north.pathfindingmazejava.logic.Grid;
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
        Grid grid = new Grid();
        grid.gridInitializeTiles();
        grid.getGrid()[0][0].setStart(true);
        grid.getGrid()[5][7].setEnd(true);
        
        readyMade = new AStar(grid);
        readyMade.initialize();
        added = new Tile (5, 10);
        added2 = new Tile(0, 10);
        added3 = new Tile(10, 20);
        added4 = new Tile(2, 4);
    }
    
    @Test
    public void testFindNoBlocks() {
        int answer = readyMade.find();
        assertEquals(7, answer);
    }    
    
    @Test
    public void constructPathCorrectly() {
        readyMade.find();
        ArrayList<Tile> thepath = readyMade.constructPath();
        
        assertEquals("(0,0)", thepath.get(0).toString());
        assertEquals("(1,1)", thepath.get(1).toString());
        assertEquals("(2,2)", thepath.get(2).toString());
        assertEquals("(3,3)", thepath.get(3).toString());
        assertEquals("(4,4)", thepath.get(4).toString());
        assertEquals("(5,5)", thepath.get(5).toString());
        assertEquals("(5,6)", thepath.get(6).toString());
        assertEquals("(5,7)", thepath.get(7).toString());
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
