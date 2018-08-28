/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.pathfinders;

import north.pathfindingmazejava.datastructures.ArrayList;
import north.pathfindingmazejava.datastructures.FIFOQueue;
import north.pathfindingmazejava.datastructures.HashMap;
import north.pathfindingmazejava.logic.Grid;
import north.pathfindingmazejava.logic.Tile;

/**
 *
 * @author northernpike
 */
public class BFS extends AbstractPathfinder{
    
    public FIFOQueue open;

    public BFS(Grid grid) {
        super(grid);
        this.open = new FIFOQueue();
    }   
    

    @Override
    public void initialize() {        
        for (int i = 0; i <= this.grid.getSize() - 1; i++) {
            for (int j = 0; j <= this.grid.getSize() - 1; j++) {
                Tile current = this.grid.getGrid()[j][i];
                if (current.isEnd()) {
                    this.end = current;
                }
                if (current.isStart()) {
                    this.start = current;
                }
            }
        }
        open.enqueue(start);
        
    }    

    @Override
    public int find() {
        visited.add(start);
        while(!open.isEmpty()) {
            Tile current = (Tile) open.dequeue();
            System.out.println("currently " + current);
            if (current.isEnd()) {
                break;
            }
            
            ArrayList<Tile> neighbors = grid.getNeigboringTiles(current);
            
            for (int i = 0; i < neighbors.getSize(); i++) {
                Tile neighbor = (Tile) neighbors.get(i);
                if (visited.contains(neighbor)) {                               //The Tile has alredy been visited
                    continue;
                }
                cameFrom.put(neighbor, current);
                open.enqueue(neighbor);
                visited.add(neighbor);
            }
        }        
        return -1;
    }

    @Override
    public ArrayList constructPath() {
        ArrayList<Tile> path = new ArrayList<>();
        Tile current = end;
        while (!current.isStart()) {
            path.add(current);
            current = cameFrom.get(current);
        }
        path.add(start);
        path.reverse();
        return path;
    }

    @Override
    public ArrayList getVisited() {
        return visited;
    }
    
    
    
}
