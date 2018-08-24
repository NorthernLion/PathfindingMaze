package north.pathfindingmazejava.datastructures;

import north.pathfindingmazejava.logic.Tile;

/**
 *
 * @author northernpike
 * @param <E>
 */
public class PriorityQueue<E> {
    private Tile[] list;
    private int current;

    /**
     * PriorityQueue only works with object Tile as there is no other usage for it in the project.
     * This priority queue has been implemented as minimum PriorityQueue. It places lowest values in the front of the queue.
     * Array list will be used to store Tiles.
     * Current is the current index of the list as well as the size of the PriorityQueue.
     */
    public PriorityQueue() {
        this.list = new Tile[1];
        this.current = 0;
    }
    
    /**
     * Adds A Tile to the priority queue and finds its appropriate position in queue.
     */
    public void add(Tile given) {
        if (this.list.length == current) {                                      // If array is full expand it.
            expand();
        }
        
        if (isEmpty()) {                                                        
            this.list[current] = given;
        } else {            
            int index = current - 1;                                            
            if (given.getValue() >= this.list[index].getValue()) {              //If the given value is higher than the highest value in priorityqueue simply place it at the bottom of priority queue.
                this.list[current] = given;                                     
            } else {
                while (index > 0) {                                             //Start looking from the previous index backwards if the value of the given Tile is higher than the next one
                    index--;
                    if (given.getValue() > this.list[index].getValue()) {       //When this is the case you have found the correct position in the priority queue
                        break;
                    }
                }
                Tile old = this.list[index];                                    //Then move the rest of higher value Tiles back by one index in the queue.
                Tile next = null;
                this.list[index] = given;
                index++;
                
                while (index <= current) {
                    next = this.list[index];
                    this.list[index] = old;
                    index++;
                    old = next;
                }
            }
        }
        this.current++;
    }
    
    /**
     *
     * @return
     */
    private void expand() {
        Tile[] newlist = new Tile[(current * 2)];
        for (int i = 0; i < list.length; i++) {
            newlist[i] = this.list[i];
        }
        this.list = newlist;
    }
    
    /**
     * returns false if a value is found from the array otherwise true
     */
    public boolean isEmpty() {
        for (int i = 0; i < current; i++) {
            if (this.list[i] != null) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns the Tile that is on the highest position in the queue. Note that this is still the lowest value.
     */
    public Tile poll() {
        Tile highest = this.list[0];
        for (int i = 0; i < this.list.length - 1; i++) {
            list[i] = this.list[i + 1];
        }
        if (current > 0) {
            current--;
        }
        return highest;
    }
    
    /**
     * Returns true if the queue contains Tile.
     */
    public boolean contains(Tile given) {
        for (int i = 0; i < current; i++) {
            if (given.equals(this.list[i])) {
                return true;
            }
        }
        return false;
    }
    
    /**
     *  Returns the size of the PriorityQueue
     */
    public int size() {
        return current;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String to = "[";
        for (int i = 0; i < list.length; i++) {
            to += list[i];
        }
        to += "]";
        return to;    
    }
    
    
    
    
    
    
    

    
}
