/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.pathfinders;

import north.pathfindingmazejava.logic.Grid;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author northernpike
 */
public class PerformanceTest {
    Grid emptyGrid;
    Grid onePathGrid;
    Grid manyPathGrid;

    @Before
    public void setUp() {
        emptyGrid = new Grid();
        onePathGrid = new Grid();
        manyPathGrid = new Grid();
        emptyGrid.gridInitializeTiles();
        onePathGrid.gridInitializeTiles();
        manyPathGrid.gridInitializeTiles();
        onePathGrid.setOneEnd(onePathGrid.getGrid()[0][0]);
        emptyGrid.setOneEnd(emptyGrid.getGrid()[0][0]);
        manyPathGrid.setOneEnd(manyPathGrid.getGrid()[0][0]);
        manyPathGrid.setOneStart(manyPathGrid.getGrid()[9][9]);
        emptyGrid.setOneStart(emptyGrid.getGrid()[9][9]);
        onePathGrid.setOneStart(onePathGrid.getGrid()[9][9]);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                if (i % 2 != 0) {
                    onePathGrid.getGrid()[j][i].setBlocked(true);
                    manyPathGrid.getGrid()[j][i].setBlocked(true);
                }                
            }
        }
        onePathGrid.getGrid()[9][1].setBlocked(false);
        onePathGrid.getGrid()[0][3].setBlocked(false);
        onePathGrid.getGrid()[9][5].setBlocked(false);
        onePathGrid.getGrid()[0][7].setBlocked(false);
        manyPathGrid.getGrid()[9][1].setBlocked(false);
        manyPathGrid.getGrid()[0][1].setBlocked(false);
        manyPathGrid.getGrid()[0][3].setBlocked(false);
        manyPathGrid.getGrid()[9][3].setBlocked(false);
        manyPathGrid.getGrid()[9][5].setBlocked(false);
        manyPathGrid.getGrid()[0][5].setBlocked(false);
        manyPathGrid.getGrid()[0][7].setBlocked(false);
        manyPathGrid.getGrid()[9][7].setBlocked(false);
    }    
    
    @Test
    public void emptyGridDifferences() {
        long time = AStarTester(emptyGrid);
        System.out.println("It took " + time + " nano seconds to solve empty grid with A Star");
        time = DijkstraTester(emptyGrid);
        System.out.println("It took " + time + " nano seconds to solve empty grid with Dijkstra");
        time = BFSTester(emptyGrid);
        System.out.println("It took " + time + " nano seconds to solve empty grid with BFS");
    }
    
    @Test
    public void onePathGridDifferences() {
        long time = AStarTester(onePathGrid);
        System.out.println("It took " + time + " nano seconds to solve onePathGrid with A Star");
        time = DijkstraTester(onePathGrid);
        System.out.println("It took " + time + " nano seconds to solve onePathGrid with Dijkstra");
        time = BFSTester(onePathGrid);
        System.out.println("It took " + time + " nano seconds to solve onePathGrid with BFS");
    }
    
    @Test
    public void manyPathGridDifferences() {
        long time = AStarTester(manyPathGrid);
        System.out.println("It took " + time + " nano seconds to solve manyPathGrid with A Star");
        time = DijkstraTester(manyPathGrid);
        System.out.println("It took " + time + " nano seconds to solve manyPathGrid with Dijkstra");
        time = BFSTester(manyPathGrid);
        System.out.println("It took " + time + " nano seconds to solve manyPathGrid with BFS");
        
    }
    
    private long AStarTester(Grid grid) {
        long average = 0;
        int i = 10;
        while(i > 0) {
            PathFinder pather = new AStar(grid);
            pather.initialize();
            long startingTime = System.nanoTime();
            pather.find();
            long endingTime = System.nanoTime();
            average += (endingTime - startingTime);
            i--;
        }
        return average/10;
    }
    
    private long BFSTester(Grid grid) {
        long average = 0;
        int i = 10;
        while(i > 0) {
            PathFinder pather = new BFS(grid);
            pather.initialize();
            long startingTime = System.nanoTime();
            pather.find();
            long endingTime = System.nanoTime();
            average += (endingTime - startingTime);
            i--;
        }
        return average/10;        
    }
    
    private long DijkstraTester(Grid grid) {
        long average = 0;
        int i = 10;
        while(i > 0) {
            PathFinder pather = new Dijkstra(grid);
            pather.initialize();
            long startingTime = System.nanoTime();
            pather.find();
            long endingTime = System.nanoTime();
            average += (endingTime - startingTime);
            i--;
        }
        return average/10;        
    }
    
}
