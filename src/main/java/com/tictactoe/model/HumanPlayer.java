package com.tictactoe.model;

import java.util.Scanner;

/**
 * Human player that reads moves from console input
 */
public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(Cell symbol, Scanner scanner) {
        super(symbol);
        this.scanner = scanner;
    }

    @Override
    public Move getMove(Board board) {
        while (true) {
            System.out.print("Enter your move (row col): ");
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Invalid input. Please enter two numbers (row col).");
                continue;
            }
            try {
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);
                if (!board.isValidMove(row, col)) {
                    System.out.println("Cell is occupied or out of range. Try again.");
                    continue;
                }
                return new Move(row, col);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numbers only.");
            }
        }
    }
}
