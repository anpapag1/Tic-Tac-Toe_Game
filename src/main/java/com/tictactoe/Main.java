package com.tictactoe;

import com.tictactoe.game.Game;

// Antonios Papageorgiou Tsakanikas
// AEM: 220118

/**
 * Entry point for the Tic-Tac-Toe game
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
