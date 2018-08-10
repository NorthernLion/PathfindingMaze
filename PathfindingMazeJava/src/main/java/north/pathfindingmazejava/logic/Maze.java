/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.logic;

import javax.swing.SwingUtilities;
import north.pathfindingmazejava.gui.UserInterface;

/**
 *
 * @author northernpike
 */
public class Maze {
    
    
    private Grid grid;
    private UserInterface gInterface;

    public Maze() {
        this.grid = new Grid();
    }
    
    
    
    public void start() {
        if (gInterface != null) {
            gInterface.close();
        }
        grid.gridInitializeTiles();
        this.gInterface = new UserInterface(this);
        SwingUtilities.invokeLater(gInterface);
    }

    public Grid getGrid() {
        return grid;
    }
    
    
    
    
}
