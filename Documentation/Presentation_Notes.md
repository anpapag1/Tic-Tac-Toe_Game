# Tic-Tac-Toe Presentation Notes (GR/EN)

## 1. Περιληπτική περιγραφή
Το έργο είναι ένα παιχνίδι τρίλιζας σε κονσόλα Java, όπου ο άνθρωπος παίζει ως X και ο υπολογιστής ως O. Ο στόχος είναι να δείξω χρήση των προτύπων Strategy και Factory για εναλλαγή αλγορίθμων AI χωρίς αλλαγές στον πυρήνα.

### Summary (EN)
This project is a Java console Tic-Tac-Toe game where the human plays as X and the computer plays as O. The goal is to demonstrate the Strategy and Factory patterns so AI algorithms can be swapped without changing the core game logic.

## 2. Δομή έργου (packages)
- `com.tictactoe` περιέχει το `Main` (entry point).
- `com.tictactoe.game` περιέχει το `Game` (ροή παιχνιδιού).
- `com.tictactoe.model` περιέχει `Board`, `Cell`, `Move`, `Player`, `HumanPlayer`, `AIPlayer`.
- `com.tictactoe.strategy` περιέχει `AIStrategy` και τις υλοποιήσεις AI.
- `com.tictactoe.factory` περιέχει `AIStrategyFactory`.

Για λεπτομέρειες κλάσεων, δείτε και το [Documentation/ClassDiagram_Documentation.md](Documentation/ClassDiagram_Documentation.md).

### Project structure (EN)
- `com.tictactoe` contains `Main` (entry point).
- `com.tictactoe.game` contains `Game` (game flow).
- `com.tictactoe.model` contains `Board`, `Cell`, `Move`, `Player`, `HumanPlayer`, `AIPlayer`.
- `com.tictactoe.strategy` contains `AIStrategy` and AI implementations.
- `com.tictactoe.factory` contains `AIStrategyFactory`.

For class details, see [Documentation/ClassDiagram_Documentation.md](Documentation/ClassDiagram_Documentation.md).

## 3. Ροή εκτέλεσης (game flow)
Η εκκίνηση γίνεται από `Main`, που δημιουργεί `Game` και καλεί `start()`. Ο χρήστης επιλέγει στρατηγική (1-3), η factory δημιουργεί το αντίστοιχο αντικείμενο, και μετά ξεκινά ο βρόχος εναλλαγής κινήσεων μέχρι νίκη ή ισοπαλία.

```mermaid
flowchart TD
    A[Main.main()] --> B[Game.start()]
    B --> C[chooseStrategy()]
    C --> D[AIStrategyFactory.createStrategy()]
    D --> E[Create HumanPlayer X]
    D --> F[Create AIPlayer O]
    E --> G[Game loop]
    F --> G
    G --> H[Human/AI getMove()]
    H --> I[Board.makeMove()]
    I --> J[Board.isWin / isDraw]
    J -->|win| K[Print result and exit]
    J -->|draw| K
    J -->|continue| G
```

### Runtime flow (EN)
Execution starts in `Main`, which creates `Game` and calls `start()`. The user selects a strategy (1-3), the factory creates the corresponding AI object, then the game loop alternates turns until win or draw.

## 4. Μοντέλο δεδομένων (μονάδες παιχνιδιού)
- `Cell` είναι enum: `EMPTY`, `X`, `O`.
- `Move` κρατάει `row` και `col` (0-2).
- `Board` κρατάει πίνακα 3x3, ελέγχει έγκυρες κινήσεις, νίκη και ισοπαλία. Υποστηρίζει `makeMove`, `undoMove`, `getEmptyCells`, `isWin`, `isDraw`, `clone`.

### Data model (EN)
- `Cell` is an enum: `EMPTY`, `X`, `O`.
- `Move` stores `row` and `col` (0-2).
- `Board` holds a 3x3 grid, validates moves, and detects win/draw. It provides `makeMove`, `undoMove`, `getEmptyCells`, `isWin`, `isDraw`, `clone`.

## 5. Παίκτες
- `Player` είναι abstract με `getMove(Board)`.
- `HumanPlayer` διαβάζει είσοδο από την κονσόλα και κάνει validation.
- `AIPlayer` καλεί `AIStrategy.chooseMove()`.

### Players (EN)
- `Player` is abstract with `getMove(Board)`.
- `HumanPlayer` reads console input and validates it.
- `AIPlayer` calls `AIStrategy.chooseMove()`.

## 6. Στρατηγικές AI
1. `RuleBasedStrategy`: νίκη → μπλοκάρισμα → κέντρο → γωνίες → οποιοδήποτε κελί.
2. `MinimaxStrategy`: αναδρομική εξερεύνηση όλων των πιθανών κινήσεων, βέλτιστο αποτέλεσμα. Πολυπλοκότητα εκθετική σε βάθος (πλήρης αναζήτηση).
3. `HeuristicStrategy`: βαθμολόγηση κινήσεων με σταθμίσεις (κέντρο 0.4, γωνίες 0.2, άκρες 0) και ανάλυση γραμμών.

### AI strategies (EN)
1. `RuleBasedStrategy`: win → block → center → corners → any cell.
2. `MinimaxStrategy`: recursive search of all possible moves for optimal play. Exponential complexity in depth (full search).
3. `HeuristicStrategy`: move scoring with weights (center 0.4, corners 0.2, edges 0) and line evaluation.

## 7. Σχεδιαστικά πρότυπα
- **Strategy**: Η `AIStrategy` ορίζει το interface. Οι `RuleBasedStrategy`, `MinimaxStrategy`, `HeuristicStrategy` υλοποιούν διαφορετικούς αλγόριθμους χωρίς αλλαγές στον πυρήνα.
- **Factory**: Η `AIStrategyFactory` συγκεντρώνει τη δημιουργία των στρατηγικών και αποσυνδέει το `Game` από τις συγκεκριμένες κλάσεις.

### Design patterns (EN)
- **Strategy**: `AIStrategy` defines the interface. `RuleBasedStrategy`, `MinimaxStrategy`, and `HeuristicStrategy` provide interchangeable algorithms without changing core logic.
- **Factory**: `AIStrategyFactory` centralizes creation and decouples `Game` from concrete strategy classes.

## 8. Build & Run
### Greek
- Maven (Java 11, UTF-8):

```bash
mvn compile
mvn exec:java
```

- Windows batch:

```bat
run.bat
```

### English
- Maven (Java 11, UTF-8):

```bash
mvn compile
mvn exec:java
```

- Windows batch:

```bat
run.bat
```

## 9. Σημεία για παρουσίαση
- Αναφέρω ότι το πρόγραμμα είναι console και ο άνθρωπος παίζει ως X.
- Δείχνω ότι αλλάζοντας τη στρατηγική αλλάζει η συμπεριφορά της AI χωρίς αλλαγή στο `Game`.
- Τονίζω πως η `AIStrategyFactory` αφαιρεί τη λογική δημιουργίας από τον πυρήνα.

### Presentation highlights (EN)
- Mention that this is a console game and the human plays as X.
- Show how changing the strategy changes AI behavior without modifying `Game`.
- Emphasize that `AIStrategyFactory` removes creation logic from the core.

## 10. Πιθανές βελτιώσεις
- Προσθήκη alpha-beta pruning στο Minimax για καλύτερη απόδοση.
- Επίπεδα δυσκολίας (τυχαίο/κανόνας/heuristic/minimax).
- GUI αντί για κονσόλα.
- Unit tests για `Board` και στρατηγικές.

### Possible improvements (EN)
- Add alpha-beta pruning to Minimax for better performance.
- Difficulty levels (random/rule-based/heuristic/minimax).
- GUI instead of console.
- Unit tests for `Board` and strategies.
