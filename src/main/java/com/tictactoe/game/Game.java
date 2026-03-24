package com.tictactoe.game;

import com.tictactoe.model.Board;
import com.tictactoe.model.Cell;
import com.tictactoe.model.HumanPlayer;
import com.tictactoe.model.AIPlayer;
import com.tictactoe.model.Player;
import com.tictactoe.model.Move;
import com.tictactoe.strategy.AIStrategy;
import com.tictactoe.factory.AIStrategyFactory;
import java.util.Scanner;

/**
 * Main game class that manages game flow, player turns,
 * and win/draw detection
 */
public class Game {
    private Board board;
    private Player human;
    private Player ai;
    private Scanner scanner;

    public Game() {
        this.scanner = new Scanner(System.in);
        this.board = new Board();
    }

    public void start() {
        System.out.println("=== Tic-Tac-Toe ===");
        System.out.println();

        // Let user choose AI strategy through the factory
        String strategyType = chooseStrategy();
        AIStrategy strategy = AIStrategyFactory.createStrategy(strategyType);
        System.out.println("Using " + strategyType + " strategy.\n");

        human = new HumanPlayer(Cell.X, scanner);
        ai = new AIPlayer(Cell.O, strategy);

        Player current = human;
        board.display();

        while (!board.isGameOver()) {
            if (current == human) {
                System.out.println("Your turn (X):");
            } else {
                System.out.println("AI is thinking...");
            }

            Move move = current.getMove(board);
            board.makeMove(move.getRow(), move.getCol(), current.getSymbol());

            if (current == ai) {
                System.out.println("AI plays " + move);
            }

            board.display();

            if (board.isWin(current.getSymbol())) {
                if (current == human) {
                    System.out.println("You win!");
                } else {
                    System.out.println("AI wins!");
                }
                scanner.close();
                return;
            }

            if (board.isDraw()) {
                System.out.println("It's a draw!");
                scanner.close();
                return;
            }

            // Switch turns
            current = (current == human) ? ai : human;
        }

        scanner.close();
    }

    private String chooseStrategy() {
        System.out.println("Choose AI strategy:");
        System.out.println("  1. Rule-Based");
        System.out.println("  2. Minimax");
        System.out.println("  3. Heuristic");
        System.out.print("Enter choice (1-3): ");

        String input = scanner.nextLine().trim();
        switch (input) {
            case "1": return "rule-based";
            case "2": return "minimax";
            case "3": return "heuristic";
            default:
                System.out.println("Invalid choice. Defaulting to Rule-Based.");
                return "rule-based";
        }
    }
}
