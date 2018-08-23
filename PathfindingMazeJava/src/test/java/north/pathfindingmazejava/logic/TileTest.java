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
public class TileTest {
    
    Tile tile1;
    Tile tile2;

    @Before
    public void setUp() {
        tile1 = new Tile(3, 2, 5);
        tile2 = new Tile(3, 3, 20);
    }
    
    @Test
    public void compareTest() {
        assertEquals(-15, tile1.compareTo(tile2));
        assertEquals(15, tile2.compareTo(tile1));
        tile1.setValue(20);
        assertEquals(0, tile1.compareTo(tile2));
        
    }
    
    @Test
    public void equalTest() {
        assertEquals(true, tile1.equal(tile1));
        assertEquals(false, tile1.equal(tile2));
    }
    
    @Test
    public void SetterGetterTest() {
        tile1.setX(4);
        tile1.setY(6);
        tile1.setChecked(true);
        assertEquals(4, tile1.getX());
        assertEquals(6, tile1.getY());
        assertEquals(true, tile1.isChecked());
    }
    
}
