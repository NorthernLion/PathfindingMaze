package north.pathfindingmazejava.logic;

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
                grid[x][y] = new Tile(x, y);
            }
        }        
    }
    
}
