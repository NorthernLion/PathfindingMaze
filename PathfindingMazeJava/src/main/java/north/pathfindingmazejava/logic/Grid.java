package north.pathfindingmazejava.logic;

import north.pathfindingmazejava.datastructures.ArrayList;
import north.pathfindingmazejava.gui.UserInterface;
/**
 *
 * @author northernpike
 */
public class Grid {

    private UserInterface gInterface;
    private Tile[][] grid;
    private int size;

    public Grid() {
        this.size = 10;
        this.grid = new Tile[size][size];
    }

    public int getSize() {
        return size;
    }
    
    public void gridInitializeTiles() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                this.grid[x][y] = new Tile(x, y);
            }
        }        
    }
    
    public ArrayList<Tile> getNeigboringTiles(Tile tile) {
        if (tile.isBlocked()) {
            return null;
        }
        ArrayList<Tile> neighbors = new ArrayList<>();
        int x = tile.getX();
        int y = tile.getY();
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (x == j && y == i) {
                    continue;
                }
                if (i < 0 || i >= size) {
                    continue;
                }
                if (j < 0 || j >= size) {
                    continue;
                }
                if (grid[j][i].isBlocked()) {
                    continue;
                }
                neighbors.add(grid[j][i]);
            }
        }
        return neighbors;
    }
    
    public ArrayList<Tile> setOneEnd(Tile tile) {
        ArrayList<Tile> oldEnds = new ArrayList<>();
        int x = tile.getX();
        int y = tile.getY();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[j][i].isEnd()) {
                    grid[j][i].setEnd(false);
                    oldEnds.add(grid[j][i]);
                }                
            }
        }
        tile.setEnd(true);
        return oldEnds;        
    }
    
    public ArrayList<Tile> setOneStart(Tile tile) {
        ArrayList<Tile> oldstarts = new ArrayList<>();
        int x = tile.getX();
        int y = tile.getY();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[j][i].isStart()) {
                    grid[j][i].setStart(false);
                    oldstarts.add(grid[j][i]);                    
                }       
            }
        }
        tile.setStart(true);
        return oldstarts;
        
    }

    public Tile[][] getGrid() {
        return grid;
    }
    
    
    
}
