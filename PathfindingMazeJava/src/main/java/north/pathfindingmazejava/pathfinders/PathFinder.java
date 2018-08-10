/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.pathfinders;

import north.pathfindingmazejava.logic.Tile;

/**
 *
 * @author northernpike
 */
public interface PathFinder {
    
    public int find(Tile start, Tile end);
    
}
