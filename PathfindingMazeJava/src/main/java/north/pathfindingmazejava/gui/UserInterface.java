package north.pathfindingmazejava.gui;

import java.awt.Color;
import north.pathfindingmazejava.logic.Grid;
import north.pathfindingmazejava.logic.Maze;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import north.pathfindingmazejava.datastructures.ArrayList;
import north.pathfindingmazejava.logic.Tile;

public class UserInterface implements Runnable {

    private JFrame frame;
    private Grid grid;
    private JButton[][] squares;

    public UserInterface(Maze maze) {
        this.grid = maze.getGrid();
        this.squares = new JButton[grid.getSize()][grid.getSize()];
    }

    @Override
    public void run() {
        this.frame = new JFrame("Welcome to the Maze");
        frame.setPreferredSize(new Dimension((60 * grid.getSize()), (60 * grid.getSize())));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        container.setLayout(new GridLayout(grid.getSize(), grid.getSize()));

        for (int x = 0; x < grid.getSize(); x++) {
            for (int y = 0; y < grid.getSize(); y++) {
                JButton button = new JButton();
                squares[x][y] = button;
                button.addMouseListener(new ButtonMouseListener(x, y, squares, grid));
                container.add(button);
            }
        }
    }
    //Thread.sleep(100)
    public void showVisited(ArrayList visited) {
        for (int i = 0; i < visited.getSize(); i++) {
            System.out.println(visited.getSize());
            Tile current = (Tile) visited.get(i);
            squares[current.getX()][current.getY()].setBackground(Color.yellow);
            squares[current.getX()][current.getY()].setText("" + current.getValue());
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }            
        }        
    }
    
    public void showPath(ArrayList path) {
        for (int i = 0; i < path.getSize(); i++) {
            Tile current = (Tile) path.get(i);
            squares[current.getX()][current.getY()].setBackground(Color.red);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }            
        }        
        
    }
    
    public void close() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
