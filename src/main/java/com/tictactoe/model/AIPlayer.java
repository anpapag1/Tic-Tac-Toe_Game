package com.tictactoe.model;

import com.tictactoe.strategy.AIStrategy;

/**
 * AI player that delegates move selection to a strategy
 */
public class AIPlayer extends Player {
    private AIStrategy strategy;

    public AIPlayer(Cell symbol, AIStrategy strategy) {
        super(symbol);
        this.strategy = strategy;
    }

    @Override
    public Move getMove(Board board) {
        return strategy.chooseMove(board, getSymbol());
    }
}
