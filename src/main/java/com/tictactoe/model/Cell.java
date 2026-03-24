package com.tictactoe.model;

/**
 * Represents the possible states of a board cell
 */
public enum Cell {
    EMPTY(' '),
    X('X'),
    O('O');

    private final char symbol;

    Cell(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
