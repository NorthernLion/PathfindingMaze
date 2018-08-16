/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        int index = current -1;
        
        if(list.length == index) {
            this.expand();
        }
        
        if (this.isEmpty()) {
            list[current] = given;
        } else {
            if (given.getValue() >= list[index].getValue()) {
                list[current] = given;
            } else {
                while(index > 0) {
                    if(given.getValue() < list[index].getValue()) {
                        break;
                    }
                    index--;
                }
                
                Tile old = list[index];
                Tile next = null;
                list[index] = given;
                index++;
                
                while(index <= current) {
                    next = list[index];
                    list[index] = old;
                    index++;
                    old = next;
                }
            }
        }
        this.current++;
    }
    
    private void expand() {
        Tile[] newlist = new Tile[(current * 2)];
        for (int i = 0; i < current -1; i++) {
            newlist[i] = this.list[i];
        }
        this.list = newlist;        
    }
    
    public boolean isEmpty() {
        for (int i = 0; i < current; i++) {
            if (list[i] != null) {
                return false;
            }
        }
        return true;
    }
    
    public Tile poll() {
        Tile highest = list[0];
        for (int i = 0; i < list.length; i++) {
            list[i] = list[i+1];
        }
        if(current > 0) {
            current --;
        }
        return highest;
    }
    
    public boolean contains(Tile given) {
        for (int i = 0; i < current; i++) {
            if(given.equals(list[i])) {
                return true;
            }
        }
        return false;
    }
    
    public int size() {
        return this.list.length;
    }
    
    
    
    

    
}
