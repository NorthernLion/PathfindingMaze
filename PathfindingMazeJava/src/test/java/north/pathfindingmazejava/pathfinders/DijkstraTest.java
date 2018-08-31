/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.pathfinders;

import north.pathfindingmazejava.datastructures.ArrayList;
import north.pathfindingmazejava.logic.Grid;
import north.pathfindingmazejava.logic.Tile;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author northernpike
 */
public class DijkstraTest {
    Dijkstra readyMade;
    Tile added;
    Tile added2;
    Tile added3;
    Tile added4;
    Grid grid;
    

    @Before
    public void setUp() {
        grid = new Grid();
        grid.gridInitializeTiles();
        grid.getGrid()[0][0].setStart(true);
        grid.getGrid()[5][7].setEnd(true);
        
        readyMade = new Dijkstra(grid);
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
    public void testWithBlocks() {
        grid.getGrid()[1][1].setBlocked(true);
        grid.getGrid()[1][2].setBlocked(true);
        grid.getGrid()[2][1].setBlocked(true);
        grid.getGrid()[2][2].setBlocked(true);
        grid.getGrid()[0][1].setBlocked(true);
        Dijkstra newMade = new Dijkstra(grid);
        newMade.initialize();
        int answer = newMade.find();
        assertEquals(9, answer);
        assertEquals(80, newMade.getVisited().getSize());
    }
    
    @Test
    public void constructPathCorrectly() {
        readyMade.find();
        ArrayList<Tile> thepath = readyMade.constructPath();
        
        assertEquals("(0,0)", thepath.get(0).toString());
        assertEquals("(0,1)", thepath.get(1).toString());
        assertEquals("(0,2)", thepath.get(2).toString());
        assertEquals("(1,3)", thepath.get(3).toString());
        assertEquals("(2,4)", thepath.get(4).toString());
        assertEquals("(3,5)", thepath.get(5).toString());
        assertEquals("(4,6)", thepath.get(6).toString());
        assertEquals("(5,7)", thepath.get(7).toString());
    }    
    
}
