/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.pathfinders;

import north.pathfindingmazejava.datastructures.ArrayList;
import north.pathfindingmazejava.logic.Tile;

/**
 * This is an interface for all PathFinders. It describes methods every pathfinder must implement. 
 * @author northernpike
 */
public interface PathFinder {
    
    /**
     * find is the method that runs the algorithm and sets the values that graphical interface will need in order to display the visited and optimal path.
     * @return the amount of steps it is for optimal path from start to end
     */
    public int find();

    /**
     *  sets the starting values so method find can be ran.
     */
    public void initialize();

    /**
     * reconstructs the path from finish to start finding the most optimal path from visited tiles.
     * @return optimal path to end
     */
    public ArrayList constructPath();

    /**
     *
     * @return all visited and evaluated tiles.
     */
    public ArrayList getVisited();
    
}
