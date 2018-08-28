/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.datastructures;

import north.pathfindingmazejava.logic.Tile;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author northernpike
 */
public class FIFOQueueTest {
    FIFOQueue readyMade;
    Tile tile1;
    Tile tile2;
    Tile tile3;

    public FIFOQueueTest() {
        this.readyMade = new FIFOQueue();
        tile1 = new Tile(0, 0);
        tile2 = new Tile(5, 0);
        tile3 = new Tile(2, 0);
    }
    
    @Test
    public void testEnqueueAndDequeue() {
        readyMade.enqueue(tile1);
        readyMade.enqueue(tile2);
        readyMade.enqueue(tile3);
        assertEquals(tile1, readyMade.dequeue());
        assertEquals(tile2, readyMade.dequeue());
        assertEquals(tile3, readyMade.dequeue());
    }

    @Test
    public void testEnqueueWhenFull() {
        for (int i = 0; i < 101; i++) {
            readyMade.enqueue(i);
        }
        assertEquals(0, readyMade.dequeue());
    }
    
    @Test
    public void testEnqueueAfterBecomingEmpty() {
        for (int i = 0; i < 101; i++) {
            readyMade.enqueue(i);
            readyMade.dequeue();
        }        
        assertEquals(true, readyMade.isEmpty());
        assertEquals(null, readyMade.dequeue());        
        readyMade.enqueue(42);
        assertEquals(42, readyMade.dequeue());
    }
    
    @Test
    public void DequeueWhenEmpty() {        
        assertEquals(true, readyMade.isEmpty());
        assertEquals(null, readyMade.dequeue());
        assertEquals(true, readyMade.isEmpty());
        assertEquals(null, readyMade.dequeue());
        assertEquals(true, readyMade.isEmpty());        
    }

    
}
