/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.logic;

import javax.swing.SwingUtilities;
import north.pathfindingmazejava.datastructures.ArrayList;
import north.pathfindingmazejava.gui.TextUi;
import north.pathfindingmazejava.gui.UserInterface;
import north.pathfindingmazejava.pathfinders.AStar;
import north.pathfindingmazejava.pathfinders.BFS;
import north.pathfindingmazejava.pathfinders.Dijkstra;
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
        this.gInterface = new UserInterface(grid);    
        while (true) {            
            SwingUtilities.invokeLater(gInterface);    
            TextUi textualui = new TextUi();
            String algorithm = textualui.run();
            
            if (algorithm.equals("AborthTheMission")) {
                System.out.println("The program is shutting down...");
                gInterface.close();
                break;
            }

            while (true) {                
                if (checkIfEndAndStart()) {
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
            } else if (algorithm.equals("Dijkstra")) {
                pather = new Dijkstra(grid);
            } else if (algorithm.equals("BFS")) {
                pather = new BFS(grid);
            }

            pather.initialize();
            long startingTime = System.nanoTime();
            int steps = pather.find();
            long endingTime = System.nanoTime();
            ArrayList visited = pather.getVisited();
            gInterface.showVisited(visited);
            if (steps == -1) {
                System.out.println("Error ocured. There is no path trought the maze you built.");
            } else {
                gInterface.showPath(pather.constructPath());        
                gInterface.showInformation(endingTime - startingTime, steps, visited.getSize());
            }
        }       
    }
    
    public boolean checkIfEndAndStart() {
        if (!grid.hasStart()) {
            System.out.println("You must select a start point before selecting start");
        }
        if (!grid.hasEnd()) {
            System.out.println("You must select a end point before selecting start");            
        }        
        if (!grid.hasEnd() || !grid.hasStart()) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return the Grid of the maze.
     */
    public Grid getGrid() {
        return grid;
    }
    
    
    
    
}
