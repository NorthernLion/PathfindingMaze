package north.pathfindingmazejava.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import north.pathfindingmazejava.datastructures.ArrayList;
import north.pathfindingmazejava.logic.Grid;
import north.pathfindingmazejava.logic.Tile;

public class ButtonMouseListener implements MouseListener {

    private int y;
    private int x;
    private JButton[][] squares;
    private Grid grid;
    private JButton button;
    private Tile[][] maze;

    ButtonMouseListener(int y, int x, JButton[][] squares, Grid grid) {
        this.y = y;
        this.x = x;
        this.squares = squares;
        this.grid = grid;
        this.maze = grid.getGrid();
        this.button = squares[y][x];
    }

    public void clearButton(Tile current) {
        JButton button = squares[current.getX()][current.getY()];
        if (!current.isBlocked() && !current.isStart() && !current.isEnd()) {
            button.setText("");
        }
    }

    @Override
    public void mouseClicked(MouseEvent me
    ) {
    }

    @Override
    public void mousePressed(MouseEvent me
    ) {
        Tile current = maze[y][x];
        ArrayList<Tile> clearable = new ArrayList<>();
        if (SwingUtilities.isLeftMouseButton(me)) {
            current.setBlocked(false);
            if (current.isStart()) {
                clearable = grid.setOneEnd(current);
                current.setEnd(true);
                current.setStart(false);
                button.setText("F");
            } else if (current.isEnd()) {
                current.setEnd(false);
                current.setStart(false);
                button.setText("");                
            } else {
                clearable = grid.setOneStart(current);
                button.setText("S");
            }
        } else if (SwingUtilities.isRightMouseButton(me)) {
            current.setEnd(false);
            current.setStart(false);
            if (current.isBlocked()) {
                current.setBlocked(false);
                button.setText(" ");
            } else {
                current.setBlocked(true);
                button.setText("B");                
            }
        }
        for (int i = 0; i < clearable.getSize(); i++) {
            Tile clearableTile = (Tile) clearable.get(i);
            clearButton(clearableTile);            
        }
    }

    @Override
    public void mouseReleased(MouseEvent me
    ) {
    }

    @Override
    public void mouseEntered(MouseEvent me
    ) {
    }

    @Override
    public void mouseExited(MouseEvent me
    ) {
    }
}
