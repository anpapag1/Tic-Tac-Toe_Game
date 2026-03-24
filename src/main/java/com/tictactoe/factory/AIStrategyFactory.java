package com.tictactoe.factory;

import com.tictactoe.strategy.AIStrategy;
import com.tictactoe.strategy.RuleBasedStrategy;
import com.tictactoe.strategy.MinimaxStrategy;
import com.tictactoe.strategy.HeuristicStrategy;

/**
 * Factory class for creating AI strategy instances.
 * Uses the Factory pattern to encapsulate strategy creation
 * so the main game code never directly instantiates strategies.
 */
public class AIStrategyFactory {

    /**
     * Creates a strategy instance based on the user's choice
     * @param type the strategy type ("rule-based", "minimax", "heuristic")
     * @return the corresponding AIStrategy instance
     */
    public static AIStrategy createStrategy(String type) {
        switch (type.toLowerCase()) {
            case "rule-based":
                return new RuleBasedStrategy();
            case "minimax":
                return new MinimaxStrategy();
            case "heuristic":
                return new HeuristicStrategy();
            default:
                throw new IllegalArgumentException("Unknown strategy: " + type
                        + ". Available: rule-based, minimax, heuristic");
        }
    }
}
