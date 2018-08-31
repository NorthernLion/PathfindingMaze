/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.pathfinders;

import north.pathfindingmazejava.datastructures.ArrayList;
import north.pathfindingmazejava.datastructures.PriorityQueue;
import north.pathfindingmazejava.logic.Grid;
import north.pathfindingmazejava.logic.Tile;

/**
 *
 * @author northernpike
 */
public class Dijkstra extends AbstractPathfinder {
    
    private PriorityQueue<Tile> open;

    public Dijkstra(Grid grid) {
        super(grid);
        open = new PriorityQueue<Tile>();
    }
    
    
    

    @Override
    public int find() {
        while (!open.isEmpty()) {
            Tile current = open.poll();
            
            if (current.isEnd()) {
                while (!open.isEmpty()) {                                       // All Tiles in the open have been evaluated. So they have been visited and need to be added in the visited list when the end has been found.
                    visited.add(open.poll());
                }
                return gScore.get(current);
            }

            visited.add(current);
            
            ArrayList<Tile> neighbors = grid.getNeigboringTiles(current);
            
            for (int i = 0; i < neighbors.getSize(); i++) {
                Tile neighbor = (Tile) neighbors.get(i);
                if (visited.contains(neighbor)) {                               //The Tile has alredy been visited
                    continue;
                }   
                
                int cost = gScore.get(current) + 1;
                
                if (cost >= gScore.get(neighbor)) {                        
                    continue;
                }                
                neighbor.setValue(cost);
                open.add(neighbor);      
                cameFrom.put(neighbor, current);
                gScore.put(neighbor, cost);
                
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
    public void initialize() {        
        for (int i = 0; i <= this.grid.getSize() - 1; i++) {
            for (int j = 0; j <= this.grid.getSize() - 1; j++) {
                Tile current = this.grid.getGrid()[j][i];
                if (current.isEnd()) {
                    this.end = current;
                }
                if (current.isStart()) {
                    this.start = current;
                } else {
                    gScore.put(current, Integer.MAX_VALUE);
                }
            }
        }
        start.setValue(0);
        gScore.put(start, 0);
        open.add(start);
    }
    
}
