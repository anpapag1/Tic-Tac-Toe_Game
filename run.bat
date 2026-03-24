@echo off
echo Compiling Tic-Tac-Toe Game...
echo.

REM Create target directory
if not exist target\classes mkdir target\classes

REM Compile Java files with UTF-8 encoding
javac -encoding UTF-8 -d target/classes src/main/java/com/tictactoe/model/*.java src/main/java/com/tictactoe/strategy/*.java src/main/java/com/tictactoe/factory/*.java src/main/java/com/tictactoe/game/*.java src/main/java/com/tictactoe/*.java

if %ERRORLEVEL% EQU 0 (
    echo Compilation successful!
    echo.
    echo Starting the game...
    echo.
    java -cp target/classes com.tictactoe.Main
) else (
    echo Compilation failed!
    pause
)
echo.
echo Game ended. Press any key to close window.
pause >nul

