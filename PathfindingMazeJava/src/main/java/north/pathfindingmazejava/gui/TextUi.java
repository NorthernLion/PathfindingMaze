/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.pathfindingmazejava.gui;

import java.util.Scanner;

/**
 *
 * @author northernpike
 */
public class TextUi {

    private Scanner scanner;
    private String algorithm;

    public TextUi() {
        this.scanner = new Scanner(System.in);
        algorithm = null;
    }
    
    public String run() {
        if (algorithm == null) {
            System.out.println("You can edit the maze with mouse");
            System.out.println("Right button will make a block, non traversable tile");
            System.out.println("Left button once will set the starting location and twice the finishing location");            
        }
        
        while (true) {
            System.out.println("Write 1 to change algorithm");
            System.out.println("Write 'start' to start the program");
            System.out.println("Write 'exit' to exit the program");
            System.out.println("____________________");
            System.out.println("");
            String answer = scanner.nextLine();
            

            if (answer.equals("1")) {
                this.algorithm = changeAlgorithm();
            } else if (answer.equals("start")) {
                if (algorithm == null) {
                    System.out.println("you must select algorithm first");
                } else {
                    return algorithm;
                }                
            } else if (answer.equals("exit")) {
                return "AborthTheMission";
            }            
        }

    }
    
    public String changeAlgorithm() {
        while (true) {
            System.out.println("Write exit to return previous menu");
            System.out.println("Write 1 to select A*");
            System.out.println("Write 2 to select Dijkstra");
            System.out.println("Write 3 to select BFS");
            System.out.println("____________________");
            System.out.println("");
            String answer = scanner.nextLine();
            if (answer.equals("exit")) { 
                break;
            } else if (answer.equals("1")) {
                System.out.println("A* has been selected");
                return "A*";
            } else if (answer.equals("2")) {
                System.out.println("Dijkstra has been selected");
                return "Dijkstra";
            } else if (answer.equals("3")) {
                System.out.println("BFS has been selected");
                return "BFS";
            }
        }
        return null;
    }
    
    
}
