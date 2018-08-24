/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.logic;

import javax.swing.SwingUtilities;
import north.pathfindingmazejava.gui.TextUi;
import north.pathfindingmazejava.gui.UserInterface;
import north.pathfindingmazejava.pathfinders.AStar;
import north.pathfindingmazejava.pathfinders.PathFinder;

/**
 *  This is the main class of the project.
 * @author northernpike
 */
public class Maze {
    
    
    private Grid grid;
    private UserInterface gInterface;

    /**
     *
     */
    public Maze() {
        this.grid = new Grid();
    }
    
    /**
     * The main method of the program. Starts the GUI, Text UI, Maze and algorithms.
     */
    public void start() {
        if (gInterface != null) {
            gInterface.close();
        }
        grid.gridInitializeTiles();
        this.gInterface = new UserInterface(this);
        SwingUtilities.invokeLater(gInterface);        
        TextUi textualui = new TextUi();
        String algorithm = textualui.run();
        
        while (true) {
            if (!grid.hasStart()) {
                System.out.println("You must select a start point before selecting start");
            }
            if (!grid.hasEnd()) {
                System.out.println("You must select a end point before selecting start");            
            }
            if (!grid.hasEnd() || !grid.hasStart()) {
                System.out.println("____________________");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                }    
                algorithm = textualui.run();
            } else {
                break;
            }            
        }

        
        PathFinder pather = null;
        
        if (algorithm.equals("A*")) {
            pather = new AStar(grid);
        }
        
        pather.initialize();
        pather.find();
        gInterface.showVisited(pather.getVisited());
        gInterface.showPath(pather.constructPath());        
        
    }

    /**
     *
     * @return the Grid of the maze.
     */
    public Grid getGrid() {
        return grid;
    }
    
    
    
    
}
