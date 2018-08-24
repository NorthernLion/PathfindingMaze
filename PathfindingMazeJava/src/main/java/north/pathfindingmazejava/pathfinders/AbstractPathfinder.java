package north.pathfindingmazejava.pathfinders;

import north.pathfindingmazejava.datastructures.ArrayList;
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

    public Tile end;
    public Tile start;

    public AbstractPathfinder() {
        visited = new ArrayList<>();
    }

    @Override
    public ArrayList getVisited() {
        return visited;
    }
    
    
    
}
