/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.pathfinders;

import java.util.HashSet;
import java.util.PriorityQueue;
import north.pathfindingmazejava.datastructures.ArrayList;
import north.pathfindingmazejava.datastructures.HashMap;
import north.pathfindingmazejava.logic.Tile;
import north.pathfindingmazejava.logic.Grid;
import north.pathfindingmazejava.datastructures.HashMap;

/**
 *
 * @author northernpike
 */
public class AStar implements PathFinder{
    
    private Grid grid;
    private HashSet<Tile> closed; //The Tiles visited will be placed here
    private PriorityQueue<Tile> open; //The Tiles not yet visited will be in a priority queue acording to the value heuristics has given them
    //rest a bit unclear
    private HashMap<Tile, Tile> cameFrom;
    private HashMap<Tile, Integer> gScore;
    private HashMap<Tile, Integer> fScore;
    private Tile end; //What could go wrong if saved here....
    private Tile start;
    
    
    public AStar(Grid grid) {
        closed = new HashSet<>();
        open = new PriorityQueue<>();
        this.grid = grid;
        this.cameFrom = new HashMap<>();
        this.gScore = new HashMap<>();
        this.fScore = new HashMap<>();
    }
    
    

    @Override
    public int find() { //Definetly still needs cleaning... This is a stackoverflow, wikipedia, google combination monster!
        this.initialize();
        
        while (!open.isEmpty()) {
            Tile current = open.poll();
            if (current.isEnd()) {
                return gScore.get(current);
            }
            
            closed.add(current);
            
            ArrayList<Tile> neighbors = grid.getNeigboringTiles(current);
            
            for (int i = 0; i < neighbors.getSize(); i++) {
                Tile neighbor = (Tile) neighbors.get(i);
                if (closed.contains(neighbor)) { //The Tile has alredy been visited
                    continue;
                }
                
                if (!open.contains(neighbor)) {
                    open.add(neighbor);
                }
                
                int cost = gScore.get(current) + 1; // 1 is the distance between every tile.
                
                if (cost >= gScore.get(neighbor)) { //Not a better path comparison
                    continue;
                }
                
                cameFrom.put(neighbor, current);
                gScore.put(neighbor, cost);
                fScore.put(neighbor, gScore.get(neighbor) + this.manhattanDistance(neighbor, this.end));
            }
        }
        
        return -1;
    }
    
    public ArrayList constructPath() {
        ArrayList<Tile> path = new ArrayList<>();
        Tile current = end;
        while (! current.isStart()) {
            path.add(current);
            current = cameFrom.get(current);
        }
        path.add(start);
        path.reverse();
        return path;
    }
    
    @Override
    public void initialize() {        
        for (int i = 0; i <= this.grid.getSize()-1; i++) {
            for (int j = 0; j <= this.grid.getSize()-1; j++) {
                Tile current = this.grid.getGrid()[j][i];
                if (current.isEnd()) {
                    this.end = current;
                }
                if (current.isStart()) {
                    gScore.put(current, 0);
                    open.add(current);
                    this.start = current;
                } else {
                    gScore.put(current, Integer.MAX_VALUE);
                    fScore.put(current, Integer.MAX_VALUE);
                }
            }
        }
        fScore.put(start, this.manhattanDistance(start, end));
    }
    
    //maybe make heuristic into interface!?!?! lets see
    public int manhattanDistance(Tile a, Tile b) {
        return (Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()));
    }
    
    public int euclideanDistance(Tile a, Tile b) {
        return (int) (Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2)));
    }
    
}

