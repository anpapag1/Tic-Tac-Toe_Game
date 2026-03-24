package com.tictactoe.strategy;

import com.tictactoe.model.Board;
import com.tictactoe.model.Cell;
import com.tictactoe.model.Move;
import java.util.List;

/**
 * Rule-based AI strategy using fixed priority rules:
 * 1. Win if possible
 * 2. Block opponent
 * 3. Take center
 * 4. Take corners
 * 5. Take any available cell
 */
public class RuleBasedStrategy implements AIStrategy {

    @Override
    public Move chooseMove(Board board, Cell aiSymbol) {
        Cell opponent = (aiSymbol == Cell.X) ? Cell.O : Cell.X;

        // Try to win
        Move winMove = findWinningMove(board, aiSymbol);
        if (winMove != null) return winMove;

        // Block opponent from winning
        Move blockMove = findWinningMove(board, opponent);
        if (blockMove != null) return blockMove;

        // Prefer center
        if (board.isValidMove(1, 1)) return new Move(1, 1);

        // Prefer corners
        int[][] corners = {{0, 0}, {0, 2}, {2, 0}, {2, 2}};
        for (int[] corner : corners) {
            if (board.isValidMove(corner[0], corner[1])) {
                return new Move(corner[0], corner[1]);
            }
        }

        // Take any empty cell
        return board.getEmptyCells().get(0);
    }

    private Move findWinningMove(Board board, Cell cell) {
        List<Move> moves = board.getEmptyCells();
        for (int i = 0; i < moves.size(); i++) {
            Move m = moves.get(i);
            board.makeMove(m.getRow(), m.getCol(), cell);
            boolean found = board.isWin(cell);
            board.undoMove(m.getRow(), m.getCol());
            if (found) return m;
        }
        return null;
    }
}
