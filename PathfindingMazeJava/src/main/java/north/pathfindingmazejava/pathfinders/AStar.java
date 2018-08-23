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
public class AStar extends AbstractPathfinder {
    
    private Grid grid;
    //The Tiles visited will be placed here
    private PriorityQueue<Tile> open; //The Tiles not yet visited will be in a priority queue acording to the value heuristics has given them
    private HashMap<Tile, Tile> cameFrom;
    private HashMap<Tile, Integer> gScore;

    
    // There are some issue with setting value for tiles in priority queue, need  to save reconstruct somewhere
    public AStar(Grid grid) {
        super();
        open = new PriorityQueue<>();
        this.grid = grid;
        this.cameFrom = new HashMap<>();
        this.gScore = new HashMap<>();
    }
    
    

    @Override
    public int find() {
        while (!open.isEmpty()) {
            Tile current = open.poll();
            
            if (current.isEnd()) {
                while (!open.isEmpty()) { //this is simply for the sake of showing visited tiles
                    visited.add(open.poll());
                }
                return gScore.get(current);
            }

            visited.add(current);
            
            ArrayList<Tile> neighbors = grid.getNeigboringTiles(current);
            
            for (int i = 0; i < neighbors.getSize(); i++) {
                Tile neighbor = (Tile) neighbors.get(i);
                if (visited.contains(neighbor)) { //The Tile has alredy been visited
                    continue;
                }   
                
                int cost = gScore.get(current) + 1; // 1 is the distance between every tile.
                int estimation = cost + this.manhattanDistance(neighbor, end);
                
                if (estimation > gScore.get(neighbor)) { //Not a better path comparison
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
    
    //maybe make heuristic into interface!?!?! lets see
    public int manhattanDistance(Tile a, Tile b) {
        return (Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()));
    }
    
    public int euclideanDistance(Tile a, Tile b) {
        return (int) (Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2)));
    }
    
}

