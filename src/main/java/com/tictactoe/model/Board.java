package com.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Tic-Tac-Toe game board
 */
public class Board {
    private Cell[][] cells;

    public Board() {
        cells = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = Cell.EMPTY;
            }
        }
    }

    private Board(Cell[][] src) {
        cells = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(src[i], 0, cells[i], 0, 3);
        }
    }

    public boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) return false;
        return cells[row][col] == Cell.EMPTY;
    }

    public void makeMove(int row, int col, Cell cell) {
        cells[row][col] = cell;
    }

    public void undoMove(int row, int col) {
        cells[row][col] = Cell.EMPTY;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public List<Move> getEmptyCells() {
        List<Move> empty = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == Cell.EMPTY) {
                    empty.add(new Move(i, j));
                }
            }
        }
        return empty;
    }

    public boolean isWin(Cell cell) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == cell && cells[i][1] == cell && cells[i][2] == cell) return true;
            if (cells[0][i] == cell && cells[1][i] == cell && cells[2][i] == cell) return true;
        }
        // Check diagonals
        if (cells[0][0] == cell && cells[1][1] == cell && cells[2][2] == cell) return true;
        if (cells[0][2] == cell && cells[1][1] == cell && cells[2][0] == cell) return true;
        return false;
    }

    public boolean isDraw() {
        return getEmptyCells().isEmpty() && !isWin(Cell.X) && !isWin(Cell.O);
    }

    public boolean isGameOver() {
        return isWin(Cell.X) || isWin(Cell.O) || isDraw();
    }

    @Override
    public Board clone() {
        return new Board(this.cells);
    }

    public void display() {
        System.out.println("  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j].getSymbol());
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("  ---------");
        }
        System.out.println();
    }
}
