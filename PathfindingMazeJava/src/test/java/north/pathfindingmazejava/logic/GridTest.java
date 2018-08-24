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
    Grid empty;
    Tile tile;
    Tile tile2;
    Tile tile3;
    
    @Before
    public void setUp() {
        empty = new Grid();
        empty.gridInitializeTiles();
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
        assertEquals(readyMade.getNeigboringTiles(readyMade.getGrid()[9][9]).get(0), readyMade.getGrid()[8][8]);
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
    
    @Test
    public void testWithEmptyGridsetOneEndReturnsEmptyArrayList() {
        assertEquals(empty.setOneEnd(tile).getSize(), 0);
    }
    
    @Test
    public void testWithEmptyGridsetOneStartReturnsEmptyArrayList() {
        assertEquals(empty.setOneEnd(tile).getSize(), 0);
    }
    
        @Test
    public void testWithAlredySetStartGridsetOneStartReturnsArrayListWithSetStart() {
        empty.getGrid()[0][0].setStart(true);
        Tile settedstart = empty.getGrid()[0][0];
        assertEquals(empty.setOneStart(tile).get(0), settedstart);
    }
    
    @Test
    public void testWithAlredySetEndGridsetOneEndReturnsArrayListWithSetEnd() {
        empty.getGrid()[0][0].setEnd(true);
        Tile settedend = empty.getGrid()[0][0];
        assertEquals(empty.setOneEnd(tile).get(0), settedend);
    }
    
    @Test
    public void testIfItHasStartTrue() {
        empty.getGrid()[0][0].setStart(true);
        assertEquals(true, empty.hasStart());
    }
    
    @Test
    public void testIfItHasEndTrue() {
        empty.getGrid()[0][0].setEnd(true);
        assertEquals(true, empty.hasEnd());
    }
    
    @Test
    public void testIfItHasNoEndFalse() {
        assertEquals(false, empty.hasEnd());        
    }
    
    @Test
    public void testIfItHasNoStartFalse() {        
        assertEquals(false, empty.hasStart());
        
    }

    

    
}
