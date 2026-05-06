# Speaker Notes — Tic-Tac-Toe Presentation

Keep this open on a second screen or print it. Each section maps to one slide.

---

## Slide 1 — Title

> "This project is a console-based Tic-Tac-Toe game where a human player competes against an Artificial Intelligence. The interesting part is not the game itself — it's **how the code is structured** to demonstrate three classic software design patterns."

---

## Slide 2 — What Is This Project?

> "When you launch the program, it asks you to pick an AI difficulty. You then play against it in the terminal — you type the row and column, the AI responds, and the board updates. The game detects wins and draws automatically."

> "The project's real purpose is to apply object-oriented design patterns in a context that's easy to understand and demo."

---

## Slide 3 — Technologies

> "The project is written in pure Java 11 with no external libraries. Maven handles compilation and lets you start the game with one command. Everything runs from the command line — no GUI, no installation beyond Java and Maven."

If asked **why no GUI**: "A console app keeps the focus on the code structure rather than UI code. The patterns work the same regardless of interface."

---

## Slide 4 — Project Structure

> "The code is split into four packages, each with a single responsibility. The model package holds the data — the board, cells, moves, and players. The game package runs the loop. The strategy package contains the three AI algorithms. The factory package handles creating them."

> "This separation means you can change how the AI works without ever touching the board logic, and vice versa."

---

## Slide 5 — Class Map

> "There are 12 classes in total. The most important ones are: Board — which is the 3×3 grid and knows how to detect wins; Game — which runs the turn-by-turn loop; AIStrategy — the interface that all three AI algorithms implement; and AIStrategyFactory — which creates the right algorithm based on the player's choice."

If asked **what an interface is**: "An interface is a contract. It says 'any class that implements me must have this method.' The AIStrategy interface requires one method: chooseMove. Each AI provides a different implementation of it."

---

## Slide 6 — Game Flow

> "The flow is straightforward. The program starts, asks which AI mode you want, creates the two players, and enters a loop. Each iteration: ask the current player for a move, apply it to the board, display the board, check for a winner or draw, then switch players. That loop runs until the game ends."

> "Notice that the game loop is identical whether the current player is human or AI — both just return a Move object. The Game class never needs to know who it's dealing with."

---

## Slide 7 — Strategy Pattern

> "The Strategy pattern is the most important one in this project. The idea is that you define a family of algorithms — here, three AI approaches — and make them interchangeable behind a common interface."

> "AIPlayer holds a reference to an AIStrategy. When it's time to move, it calls strategy.chooseMove(). It doesn't know or care which strategy it has — Rule-Based, Minimax, or Heuristic. They all look the same from outside."

> "The benefit: if you wanted to add a fourth AI tomorrow, you'd write a new class. Everything else stays the same."

If asked about the **Open/Closed Principle**: "It means code should be open for adding new things but closed to editing what already works. Adding a new strategy never touches Board, Game, or the other strategies."

---

## Slide 8 — Factory Pattern

> "The Factory pattern centralises object creation. Instead of writing 'new MinimaxStrategy()' scattered across the code, we have one class — AIStrategyFactory — that receives a string like 'minimax' and returns the right object."

> "The Game class never directly imports or names MinimaxStrategy. It only knows AIStrategy, the interface. This means if you rename or replace MinimaxStrategy, you fix it in one place."

---

## Slide 9 — Template Method

> "The abstract Player class defines a template: every player has a symbol, and every player must be able to produce a Move when asked. HumanPlayer fills that in with keyboard reading. AIPlayer fills it in with a strategy call."

> "The Game class calls current.getMove(board) — one line, identical for both players. Polymorphism handles the rest. This is the Template Method pattern."

---

## Slide 10 — Rule-Based Strategy

> "The Rule-Based strategy works like a checklist. First check: can I win this turn? If yes, take it. Second check: will the opponent win next turn? If yes, block. Then prefer the center, then corners, then anything else."

> "It's fast and handles obvious situations well. But it has no lookahead — it can't see two moves ahead. A patient player can set up a fork — two winning threats at once — and the Rule-Based AI won't notice until it's too late."

If asked **what a fork is**: "A fork is when you set up two ways to win at the same time. The opponent can only block one, so you win with the other. Rule-Based misses this because it only looks one move ahead."

---

## Slide 11 — Minimax Strategy

> "Minimax is a classic AI algorithm for two-player games. It simulates every possible game from the current position all the way to the end — win, loss, or draw. It assigns +10 to positions where the AI wins, -10 where the human wins, and 0 for draws."

> "The AI assumes the human plays perfectly — always picking the move that minimises the AI's score. Given that assumption, Minimax finds the move with the best guaranteed outcome."

> "The result is mathematically provable: if the AI uses Minimax, you cannot beat it. The best you can do is draw."

If asked about **performance**: "On the first move, there are up to 362,880 possible game sequences on a 3×3 board — 9 factorial. That sounds like a lot, but modern computers evaluate all of them in milliseconds. For larger boards like chess, you'd need pruning techniques, but for Tic-Tac-Toe it's fine."

---

## Slide 12 — Heuristic Strategy

> "The Heuristic strategy is a middle ground. Instead of searching the entire game tree, it scores each available cell right now and picks the best one. No recursion, no lookahead."

> "The score has two components: positional value — center is worth 0.4, corners 0.2, edges 0 — and line evaluation. For every row, column, or diagonal that passes through the candidate cell, it checks whether the AI is about to win, or needs to block. Lines where both players have pieces are worthless."

> "It's much faster than Minimax and usually plays well — but it can miss complex traps that require thinking two moves ahead."

---

## Slide 13 — Win Detection

> "Win detection is simple and direct. The board checks all 8 possible winning lines after every move — 3 rows, 3 columns, and 2 diagonals. If all 3 cells in any line belong to the same symbol, that player wins."

> "Draw detection is: all 9 cells are filled AND no winning line exists."

> "The same isWin() method is used both to detect the real winner and by the AI strategies to simulate hypothetical moves without permanently changing the board — that's why Board also has undoMove()."

---

## Slide 14 — Extensibility

> "One of the clearest tests of good design is how easy it is to add a new feature without breaking anything. Here, adding a fourth AI strategy requires exactly two steps: write a new class that implements AIStrategy, and add one line to the factory switch statement."

> "Board, Game, Player, AIPlayer — none of them change. That's the Open/Closed Principle in practice."

---

## Slide 15 — Summary

> "To summarise: the project is a 12-class, 4-package Java application with three design patterns — Strategy for swappable AI algorithms, Factory for centralised object creation, and Template Method for the abstract Player base. The three AI modes range from a simple priority checklist to a provably optimal game-tree search."

> "The design choices all serve the same goal: code that's easy to understand, easy to test, and easy to extend without breaking what already works."

---

## Common Questions — Pre-Answered

**Q: Why not use a GUI?**
A: Console keeps the focus on design patterns. The patterns are identical in a GUI version — you'd just swap the display and input methods.

**Q: Could you add a two-human mode?**
A: Yes — create a second HumanPlayer with symbol O. Zero changes to Board or Game.

**Q: Why three strategies instead of just Minimax?**
A: Each strategy demonstrates a different approach to AI decision-making — rule-following vs. greedy evaluation vs. optimal search. They make the Strategy pattern concrete and comparable.

**Q: Can Minimax be beaten?**
A: No. It is mathematically proven optimal. The human's best outcome is a draw.

**Q: What is the time complexity of Minimax?**
A: O(9!) in the worst case — 362,880 states. Still instant on modern hardware for a 3×3 board.

**Q: What would you add next?**
A: Alpha-Beta Pruning to speed up Minimax, or a difficulty slider that limits search depth. Both require only a new strategy class and one factory line.
