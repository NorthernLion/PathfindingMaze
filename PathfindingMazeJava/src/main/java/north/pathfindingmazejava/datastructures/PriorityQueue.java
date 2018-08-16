package north.pathfindingmazejava.datastructures;

import north.pathfindingmazejava.logic.Tile;

/**
 *
 * @author northernpike
 */
public class PriorityQueue<E> {
    private Tile[] list;
    private int current;

    public PriorityQueue() {
        this.list = new Tile[1];
        this.current = 0;
    }
    
    public void add(Tile given) {
        if (this.list.length == current) {
            this.expand();
        }
        
        if (this.isEmpty()) {
            this.list[current] = given;
        } else {            
            int index = current - 1;
            if (given.getValue() >= this.list[index].getValue()) {
                this.list[current] = given;
            } else {
                while (index > 0) {
                    if (given.getValue() > this.list[index].getValue()) {
                        break;
                    }
                    index--;
                }
                Tile old = this.list[index];
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
    
    private void expand() {
        Tile[] newlist = new Tile[(current * 2)];
        for (int i = 0; i < list.length; i++) {
            newlist[i] = this.list[i];
        }
        this.list = newlist;
    }
    
    public boolean isEmpty() {
        for (int i = 0; i < current; i++) {
            if (this.list[i] != null) {
                return false;
            }
        }
        return true;
    }
    
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
    
    public boolean contains(Tile given) {
        for (int i = 0; i < current; i++) {
            if (given.equals(this.list[i])) {
                return true;
            }
        }
        return false;
    }
    
    public int size() {
        return current;
    }
    
    
    
    
    
    

    
}
