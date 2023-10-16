# IDEA EDU course project

## Project
This is the *Simple Tic Tac Toe (Java)* project that is part of Hyperskill platform from Jetbrains Academy.

Purpose of the project is to learn Java basics and to get more familiar with its ecosystem.

## Technologies

- Java 17

## Project description
Simple Tic Tac Toe game.

## Changelog
15.10.2023
- Added method for creating 3x3 Grid based on string input of X's and/or O's and/or empty cells
- Added method for printing the current game status

16.10.2023

Added the following game states:
- `Game not finished` when neither side has three in a row but the grid still has empty cells.
- `Draw` when no side has a three in a row and the grid has no empty cells.
- `X wins` when the grid has three X’s in a row (including diagonals).
- `O wins` when the grid has three O’s in a row (including diagonals).
- `Impossible` when the grid has three X’s in a row as well as three O’s in a row, or there are a lot more X's than O's or vice versa (the difference should be 1 or 0; if the difference is 2 or more, then the game state is impossible).

## Project status

Completed 3/5 stages