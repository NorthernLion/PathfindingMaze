/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.datastructures;

/**
 *
 * @author northernpike
 */
public class FIFOQueue {
    
    private Object[] queue;
    private int head;
    private int tail;
    private int size;

    public FIFOQueue() {
        this.size= 100; //We happen to need 100 size in running of BFS.
        this.queue = new Object[size];
        head = 0;
        tail = 0;
    }
    
    public void enqueue(Object o) {
        if (tail == queue.length) {
            expand();
        }
        queue[tail] = o;
        tail++;
    }
    
    public Object dequeue() {
        if (head == tail) {
            return null;
        } else {
            head++;
            return queue[head - 1];            
        }
    }
    
    public boolean isEmpty() {
        if (head == tail) {
            return true;
        }
        return false;
    }
    
    private void expand() {
        this.size = (size + size / 2 + 2);
        Object[] newQueue = new Object[size];
        for (int i = 0; i < queue.length; i++) {
            newQueue[i] = queue[i];
        }
        this.queue = newQueue;
    }
    
    
    
}
