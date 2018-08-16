/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.datastructures;

import north.pathfindingmazejava.logic.Tile;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author northernpike
 */
public class PriorityQueueTest {
    PriorityQueue queue;
    Tile first;
    Tile second;
    
    @Before
    public void setUp() {
        queue = new PriorityQueue();
        first = new Tile(2, 29, 3);
        second = new Tile(3, 53, 20);
    }    
    
    @Test
    public void testContainsAfterAdd() {
        queue.add(first);
        assertEquals(true, queue.contains(first));
    }
    
    public void testPollAfterAddAndSeeIfEmpty() {
        queue.add(first);
        assertEquals(first, queue.poll());
        assertEquals(queue.isEmpty(), true);
        
    }
}
