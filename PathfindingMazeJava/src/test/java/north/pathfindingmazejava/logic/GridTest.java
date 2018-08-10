/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.logic;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author northernpike
 */
public class GridTest {
    
    Grid readyMade;
    Tile tile;
    Tile tile2;
    Tile tile3;
    
    @Before
    public void setUp() {
        readyMade = new Grid();
        readyMade.gridInitializeTiles();
        tile = readyMade.getGrid()[0][0];        
        tile2 = readyMade.getGrid()[1][1];
        tile3 = readyMade.getGrid()[1][2];
        tile.setBlocked(true);
        tile2.setBlocked(true);
        tile3.setBlocked(true);
    }
    
    @Test
    public void testGettingNeighbors() {        
        assertEquals(readyMade.getNeigboringTiles(readyMade.getGrid()[3][3]).get(0), readyMade.getGrid()[2][2]);
        assertEquals(readyMade.getNeigboringTiles(readyMade.getGrid()[3][3]).getSize(), 8);
    }
    
    @Test
    public void testGettingNeighborsWhenBlcoked() {        
        assertEquals(readyMade.getNeigboringTiles(readyMade.getGrid()[1][3]).get(0), readyMade.getGrid()[0][2]);
        assertEquals(readyMade.getNeigboringTiles(readyMade.getGrid()[1][3]).getSize(), 7);
    }
    
    @Test
    public void testGettingNeighborsWhenBlcokedAndCloseToEdge() {        
        assertEquals(readyMade.getNeigboringTiles(readyMade.getGrid()[0][1]).get(0), readyMade.getGrid()[1][0]);
        assertEquals(readyMade.getNeigboringTiles(readyMade.getGrid()[0][1]).getSize(), 2);
    }
    
    @Test
    public void testGettingNeighborsWhenNextToBlcoked() {        
        assertEquals(readyMade.getNeigboringTiles(tile), null);
    }
    

    

    
}
