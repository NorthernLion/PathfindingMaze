/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.pathfinders;

import java.util.HashSet;
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
    
    

    @Override
    public int find(Tile start, Tile end) {
        HashSet<Tile> closed = new HashSet<>();
        HashSet<Tile> open = new PriorityQueue<>();
        HashMap<Tile, Tile> cameFrom = new HashMap<>();
        HashMap<Tile, Integer> gScore = new HashMap<>();
        HashMap<Tile, Integer> fScore = new HashMap<>();
        
        
        while (!open.isEmpty()) {

        }
        return 0;
    }
    
    //Hah these heuristic were easy, maybe make heuristic into interface!?!?! lets see
    public int manhattanDistance(Tile a, Tile b) {
        return (Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()));
    }
    
    public int euclideanDistance(Tile a, Tile b) {
        return (int) (Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2)));
    }
    
}

