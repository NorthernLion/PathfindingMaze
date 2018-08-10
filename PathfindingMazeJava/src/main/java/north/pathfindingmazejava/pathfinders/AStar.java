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
        HashSet<Tile> open = new HashSet<>();
        HashMap<Tile, Tile> cameFrom = new HashMap<>();
        HashMap<Tile, Integer> gScore = new HashMap<>();
        HashMap<Tile, Integer> fScore = new HashMap<>();
        
        
        while (!open.isEmpty()) {

        }
        return 0;
    }
    
}

