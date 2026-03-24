package com.tictactoe.strategy;

import com.tictactoe.model.Board;
import com.tictactoe.model.Cell;
import com.tictactoe.model.Move;

/**
 * Heuristic AI strategy that scores all possible moves using an
 * evaluation function and selects the highest-scoring move
 */
public class HeuristicStrategy implements AIStrategy {

    @Override
    public Move chooseMove(Board board, Cell aiSymbol) {
        Cell opponent = (aiSymbol == Cell.X) ? Cell.O : Cell.X;
        Move bestMove = null;
        double bestScore = Double.NEGATIVE_INFINITY;

        for (Move move : board.getEmptyCells()) {
            double score = evaluateMove(board, move, aiSymbol, opponent);
            if (score > bestScore) {
                bestScore = score;
                bestMove = move;
            }
        }
        return bestMove;
    }

    private double evaluateMove(Board board, Move move, Cell ai, Cell opponent) {
        int r = move.getRow();
        int c = move.getCol();
        double score = 0;

        // Positional value: center > corners > edges
        if (r == 1 && c == 1) score += 0.4;
        else if ((r == 0 || r == 2) && (c == 0 || c == 2)) score += 0.2;

        // Evaluate all lines passing through this cell
        score += evaluateLine(board, r, c, 0, 1, ai, opponent);  // row
        score += evaluateLine(board, r, c, 1, 0, ai, opponent);  // column
        if (r == c) score += evaluateLine(board, r, c, 1, 1, ai, opponent);  // diagonal \
        if (r + c == 2) score += evaluateLine(board, r, c, 1, -1, ai, opponent);  // diagonal /

        return score;
    }

    private double evaluateLine(Board board, int r, int c, int dr, int dc, Cell ai, Cell opponent) {
        int aiCount = 0;
        int oppCount = 0;

        for (int i = -2; i <= 2; i++) {
            int nr = r + i * dr;
            int nc = c + i * dc;
            if (nr < 0 || nr > 2 || nc < 0 || nc > 2) continue;
            Cell cell = board.getCell(nr, nc);
            if (cell == ai) aiCount++;
            else if (cell == opponent) oppCount++;
        }

        if (oppCount > 0 && aiCount > 0) return 0;
        if (oppCount == 2) return -0.9;
        if (aiCount == 2) return 0.9;
        if (aiCount == 1) return 0.3;
        return 0.1;
    }
}
