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
    PriorityQueue<Tile> queue;
    Tile first;
    Tile second;
    Tile third;
    
    @Before
    public void setUp() {
        queue = new PriorityQueue();
        first = new Tile(2, 29, 3);
        second = new Tile(3, 53, 20);
        third = new Tile(5, 21, 500);
    }    
    
    @Test
    public void testContainsAfterAdd() {
        queue.add(first);
        assertEquals(true, queue.contains(first));
    }
    
    @Test
    public void testPollAfterAddAndSeeIfEmpty() {
        queue.add(first);
        assertEquals(first, queue.poll());
        assertEquals(queue.isEmpty(), true);        
    }
    
    @Test
    public void queueWithAnEntryIsNotEmpty() {
        queue.add(first);
        assertEquals(queue.isEmpty(), false);
    }
    
    @Test
    public void PollingFromMultipleEntriesReturnsCorrectOne() {
        queue.add(third);
        queue.add(second);  
        queue.add(first);
        assertEquals(first, queue.poll());
        queue.add(third);
        queue.add(second);
        queue.add(first);
        assertEquals(first, queue.poll());
        queue.add(third);
        queue.add(second);
        queue.add(second);
        assertEquals(second, queue.poll());        
    }
    
    @Test
    public void pollingEmptyQueue() {
        assertEquals(null, queue.poll());
    }
    
    @Test
    public void containsEmptyQueue() {
        assertEquals(false, queue.contains(first));
    }
    
    @Test
    public void SizeIsCorrect() {
        queue.add(third);
        queue.add(second);  
        queue.add(first); 
        assertEquals(3, queue.size());
    }
    
    
}
