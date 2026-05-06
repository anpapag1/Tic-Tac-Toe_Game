# Prompt for Claude (copy/paste)

You are given a Java Tic-Tac-Toe project. Create bilingual (Greek first, then English) documentation for a class presentation. Output files must be placed in the folder specified by <OUTPUT_FOLDER>.

## Requirements
1) Create <OUTPUT_FOLDER>/Presentation_Notes.md
   - Medium length (approx. 3-5 pages total)
   - Section order: summary, project structure, runtime flow, data model, players, AI strategies, design patterns, build/run, presentation highlights, improvements
   - Greek text first, then English for each section
   - Include one Mermaid flowchart showing the runtime flow
   - Mention that human plays X and AI plays O
   - Mention the three strategies (rule-based, minimax, heuristic) and their core ideas
   - Mention Factory and Strategy patterns

2) Create <OUTPUT_FOLDER>/Slides_Outline.md
   - 12-14 slides
   - For each slide: Greek bullet list first, then English bullet list
   - Include slides for strategies and design patterns, plus build/run

3) Reference the existing class diagram doc (if present) in the notes file.

## Input assumptions
- Entry point: `com.tictactoe.Main`
- Game loop in `com.tictactoe.game.Game`
- AI strategies in `com.tictactoe.strategy`
- Model in `com.tictactoe.model`
- Factory in `com.tictactoe.factory`

## Output placeholder
Set this before writing files:
- <OUTPUT_FOLDER> = the target folder where docs should be generated

Return only the created file contents and paths.
