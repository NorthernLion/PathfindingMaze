package north.pathfindingmazejava.pathfinders;

import north.pathfindingmazejava.datastructures.ArrayList;
import north.pathfindingmazejava.datastructures.HashMap;
import north.pathfindingmazejava.logic.Grid;
import north.pathfindingmazejava.logic.Tile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  This is the abstract class for path finders. All similar code between path finders is implemented here to reduce copy paste.
 * @author northernpike
 */
public abstract class AbstractPathfinder implements PathFinder {

    /**
     * ArrayList that has all the visited aka evaluated Tiles.
     */
    public ArrayList<Tile> visited;
    public Grid grid;
    public Tile end;
    public Tile start;    
    public HashMap<Tile, Integer> gScore;
    public HashMap<Tile, Tile> cameFrom;

    

    public AbstractPathfinder(Grid grid) {
        this.grid = grid;
        this.visited = new ArrayList<>();
        this.gScore = new HashMap<>();      // The distance from starting tile is saved here.
        this.cameFrom = new HashMap<>();    // The Tile it is most efficient to arrive to said Tile is saved here.
    }

    @Override
    public ArrayList getVisited() {
        return visited;
    }
    
    
    
}
