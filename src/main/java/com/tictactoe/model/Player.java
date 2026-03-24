package com.tictactoe.model;

/**
 * Abstract base class for game players (human or AI)
 */
public abstract class Player {
    private final Cell symbol;

    public Player(Cell symbol) {
        this.symbol = symbol;
    }

    public Cell getSymbol() {
        return symbol;
    }

    public abstract Move getMove(Board board);
}
