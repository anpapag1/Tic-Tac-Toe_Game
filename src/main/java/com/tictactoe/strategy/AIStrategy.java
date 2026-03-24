package com.tictactoe.strategy;

import com.tictactoe.model.Board;
import com.tictactoe.model.Cell;
import com.tictactoe.model.Move;

/**
 * Strategy interface for AI move selection algorithms
 */
public interface AIStrategy {
    /**
     * Choose the best move for the given board state
     * @param board the current game board
     * @param aiSymbol the symbol (X or O) of the AI player
     * @return the chosen move
     */
    Move chooseMove(Board board, Cell aiSymbol);
}
