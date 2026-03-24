package com.tictactoe.strategy;

import com.tictactoe.model.Board;
import com.tictactoe.model.Cell;
import com.tictactoe.model.Move;

/**
 * Minimax AI strategy that recursively evaluates all possible game states
 * and selects the move leading to the optimal outcome
 */
public class MinimaxStrategy implements AIStrategy {

    @Override
    public Move chooseMove(Board board, Cell aiSymbol) {
        Cell opponent = (aiSymbol == Cell.X) ? Cell.O : Cell.X;
        Move bestMove = null;
        int bestScore = Integer.MIN_VALUE;

        for (Move move : board.getEmptyCells()) {
            board.makeMove(move.getRow(), move.getCol(), aiSymbol);
            int score = minimax(board, false, aiSymbol, opponent);
            board.undoMove(move.getRow(), move.getCol());
            if (score > bestScore) {
                bestScore = score;
                bestMove = move;
            }
        }
        return bestMove;
    }

    private int minimax(Board board, boolean isMaximizing, Cell aiSymbol, Cell opponent) {
        if (board.isWin(aiSymbol)) return 10;
        if (board.isWin(opponent)) return -10;
        if (board.isDraw()) return 0;

        if (isMaximizing) {
            int best = Integer.MIN_VALUE;
            for (Move move : board.getEmptyCells()) {
                board.makeMove(move.getRow(), move.getCol(), aiSymbol);
                best = Math.max(best, minimax(board, false, aiSymbol, opponent));
                board.undoMove(move.getRow(), move.getCol());
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (Move move : board.getEmptyCells()) {
                board.makeMove(move.getRow(), move.getCol(), opponent);
                best = Math.min(best, minimax(board, true, aiSymbol, opponent));
                board.undoMove(move.getRow(), move.getCol());
            }
            return best;
        }
    }
}
