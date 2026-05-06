# Slide Outline (GR/EN)

## Slide 1: Τίτλος
GR:
- Τρίλιζα (Tic-Tac-Toe) με Java
- Μάθημα: Σχεδιαστικά Πρότυπα
EN:
- Tic-Tac-Toe in Java
- Course: Design Patterns

## Slide 2: Στόχος έργου
GR:
- Παιχνίδι κονσόλας με AI αντίπαλο
- Εφαρμογή Strategy και Factory
EN:
- Console game with AI opponent
- Apply Strategy and Factory patterns

## Slide 3: Βασική ροή
GR:
- Επιλογή στρατηγικής
- Εναλλαγή κινήσεων X/O
- Έλεγχος νίκης/ισοπαλίας
EN:
- Choose strategy
- Alternate X/O turns
- Check win/draw

## Slide 4: Δομή πακέτων
GR:
- model, strategy, factory, game
EN:
- model, strategy, factory, game

## Slide 5: Μοντέλο παιχνιδιού
GR:
- `Board`, `Cell`, `Move`
- 3x3 grid, έλεγχος νίκης
EN:
- `Board`, `Cell`, `Move`
- 3x3 grid, win detection

## Slide 6: Παίκτες
GR:
- `Player` abstract
- `HumanPlayer` input
- `AIPlayer` + strategy
EN:
- `Player` abstract
- `HumanPlayer` input
- `AIPlayer` + strategy

## Slide 7: Strategy Pattern
GR:
- `AIStrategy` interface
- Εναλλάξιμες στρατηγικές
EN:
- `AIStrategy` interface
- Interchangeable strategies

## Slide 8: Rule-Based AI
GR:
- Νίκη → μπλοκάρισμα → κέντρο → γωνίες
EN:
- Win → block → center → corners

## Slide 9: Minimax AI
GR:
- Αναδρομική αναζήτηση
- Βέλτιστο αποτέλεσμα, αλλά πιο αργό
EN:
- Recursive search
- Optimal but slower

## Slide 10: Heuristic AI
GR:
- Βαθμολόγηση κινήσεων
- Γρήγορη, όχι πάντα τέλεια
EN:
- Move scoring
- Fast, not always perfect

## Slide 11: Factory Pattern
GR:
- `AIStrategyFactory` δημιουργεί στρατηγικές
- Αποσύνδεση από `Game`
EN:
- `AIStrategyFactory` creates strategies
- Decouples from `Game`

## Slide 12: Build & Run
GR:
- Maven: `mvn compile`, `mvn exec:java`
- Windows: `run.bat`
EN:
- Maven: `mvn compile`, `mvn exec:java`
- Windows: `run.bat`

## Slide 13: Demo / Παράδειγμα
GR:
- Επιλογή στρατηγικής 1/2/3
- Παράδειγμα μιας παρτίδας
EN:
- Strategy choice 1/2/3
- Sample game run

## Slide 14: Συμπέρασμα & επόμενα βήματα
GR:
- Καθαρός σχεδιασμός, εύκολη επέκταση
- Μελλοντικές βελτιώσεις
EN:
- Clean design, easy to extend
- Future improvements
