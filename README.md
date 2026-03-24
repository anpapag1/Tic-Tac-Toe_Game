# Tic-Tac-Toe Game

A Java console Tic-Tac-Toe game where a human player competes against an AI opponent, demonstrating the Strategy and Factory design patterns.

## Design Patterns Used

### Strategy Pattern
- **AIStrategy Interface**: Defines the contract for AI move selection algorithms
- **RuleBasedStrategy**: Follows fixed priority rules (win → block → center → corners → any cell)
- **MinimaxStrategy**: Recursively evaluates all possible game states for optimal play
- **HeuristicStrategy**: Scores moves using an evaluation function (positional value + line potential)

### Factory Pattern
- **AIStrategyFactory**: Creates strategy instances based on user choice
- The main game code never directly instantiates strategy objects — the factory handles all creation

## Game Mechanics

### Human Player
- Plays as X
- Enters moves as `row col` (0-2)
- Input is validated for correctness

### AI Player
- Plays as O
- Uses one of three selectable strategies
- Strategy is chosen at game start via the factory

### Game Flow
1. User selects AI strategy (Rule-Based, Minimax, or Heuristic)
2. Human (X) moves first, then AI (O)
3. Board is displayed after every move
4. Game detects win or draw conditions

## How to Build and Run

### Using Maven
```bash
mvn compile
mvn exec:java
```

### Using Java directly
```bash
javac -encoding UTF-8 -d target/classes src/main/java/com/tictactoe/model/*.java src/main/java/com/tictactoe/strategy/*.java src/main/java/com/tictactoe/factory/*.java src/main/java/com/tictactoe/game/*.java src/main/java/com/tictactoe/*.java

java -cp target/classes com.tictactoe.Main
```

### Using the batch file (Windows)
```bash
run.bat
```

## Project Structure
```
src/main/java/com/tictactoe/
├── Main.java                         # Entry point
├── model/
│   ├── Cell.java                     # Enum: EMPTY, X, O
│   ├── Move.java                     # (row, col) value object
│   ├── Board.java                    # Game board state
│   ├── Player.java                   # Abstract player
│   ├── HumanPlayer.java              # Console input player
│   └── AIPlayer.java                 # AI player (uses strategy)
├── strategy/
│   ├── AIStrategy.java               # Strategy interface
│   ├── RuleBasedStrategy.java        # Priority-rule AI
│   ├── MinimaxStrategy.java          # Optimal recursive AI
│   └── HeuristicStrategy.java        # Evaluation-function AI
├── factory/
│   └── AIStrategyFactory.java        # Factory for strategy creation
└── game/
    └── Game.java                     # Game flow and logic
```

## Features
- Interactive console gameplay
- Strategy pattern for interchangeable AI algorithms
- Factory pattern for decoupled object creation
- Input validation and error handling
- Win/draw detection
- Extensible design — new strategies can be added with minimal changes

## Extensibility
Adding a new AI strategy requires:
1. Create a new class implementing `AIStrategy`
2. Add one case to `AIStrategyFactory.createStrategy()`

No changes needed to `Board`, `Player`, `Game`, or `Main`.
