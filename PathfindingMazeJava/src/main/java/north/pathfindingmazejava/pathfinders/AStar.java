package north.pathfindingmazejava.pathfinders;

//import north.pathfindingmazejava.datastructures.PriorityQueue;
import north.pathfindingmazejava.datastructures.ArrayList;
import north.pathfindingmazejava.logic.Tile;
import north.pathfindingmazejava.logic.Grid;
import north.pathfindingmazejava.datastructures.HashMap;

/**
 *
 * @author northernpike
 */
import java.util.PriorityQueue;

/**
 *
 * @author northernpike
 */
public class AStar extends AbstractPathfinder {
    
    
    private PriorityQueue<Tile> open; 

    /**
     *
     * @param grid
     */
    public AStar(Grid grid) {
        super(grid);
        open = new PriorityQueue<>();        
    }
    
    

    @Override
    public int find() {
        while (!open.isEmpty()) {
            Tile current = open.poll();
            
            if (current.isEnd()) {
                while (!open.isEmpty()) {                                       // All Tiles in the open have been evaluated. So they have been visited and need to be added in the visited list when the end has been found.
                    visited.add(open.poll());
                }
                return gScore.get(current);
            }

            visited.add(current);
            
            ArrayList<Tile> neighbors = grid.getNeigboringTiles(current);
            
            for (int i = 0; i < neighbors.getSize(); i++) {
                Tile neighbor = (Tile) neighbors.get(i);
                if (visited.contains(neighbor)) {                               //The Tile has alredy been visited
                    continue;
                }   
                
                int cost = gScore.get(current) + 1;                             // 1 is the distance between every tile and gScore.get(current) is the distance of previous tile from start
                int estimation = cost + this.manhattanDistance(neighbor, end);  // Heuristic is added to this value to estimate the "goodness" of the tile
                
                if (estimation >= gScore.get(neighbor)) {                        // If lower estimation has been set at gscore before the path we are currently looking at is not better and we can continue
                    continue;
                }                
                neighbor.setValue(estimation);
                open.add(neighbor);      
                cameFrom.put(neighbor, current);
                gScore.put(neighbor, cost);
                
            }
        }
        return -1;
    }
    
    /**
     * The most efficient path to current tile is saved in the cameFrom. That is why going trough the cameFrom from end to start creates the optimal path.
     */
        
    
    @Override
    public ArrayList constructPath() {
        ArrayList<Tile> path = new ArrayList<>();
        Tile current = end;
        while (!current.isStart()) {
            path.add(current);
            current = cameFrom.get(current);
        }
        path.add(start);
        path.reverse();
        return path;
    }
    
    /**
     * initialize finds start and end point and initializes all other tiles to have maximum value in gscore, except start that has 0.
     */
        
    @Override
    public void initialize() {        
        for (int i = 0; i <= this.grid.getSize() - 1; i++) {
            for (int j = 0; j <= this.grid.getSize() - 1; j++) {
                Tile current = this.grid.getGrid()[j][i];
                if (current.isEnd()) {
                    this.end = current;
                }
                if (current.isStart()) {
                    this.start = current;
                } else {
                    gScore.put(current, Integer.MAX_VALUE);
                }
            }
        }
        start.setValue(0);
        gScore.put(start, 0);
        open.add(start);
    }
    
    /**
     *
     * @return Manhattan distance calculated with the formula
     */
    public int manhattanDistance(Tile a, Tile b) {
        return (Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()));
    }
    
    /**
     *
     * @return Euclidean Distance calculated with the formula.
     */
    public int euclideanDistance(Tile a, Tile b) {
        return (int) (Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2)));
    }
    
}

