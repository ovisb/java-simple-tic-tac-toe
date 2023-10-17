package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final int maxSize = 3;

    /**
     * Create 3x3 Grid
     * @param input string of chars of X's and/or 0's and/or empty lines
     * @return 2D 3x3 char array
     */
    public static char[][] create_grid(String input) {
        final int gridSize = input.length() / maxSize;
        char[][] grid = new char[gridSize][gridSize];
        int start = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = input.charAt(start++);
            }
        }
        return grid;
    }

    /**
     * Print Grid
     * @param grid 2D 3x3 char array
     */
    public static void printGrid(char[][] grid) {

        System.out.println("-".repeat(grid.length * maxSize));
        for (char[] row : grid) {
            System.out.print("| ");
            for (char letter: row) {
                System.out.printf("%c ", letter);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-".repeat(grid.length * maxSize));
    }

    /**
     * Check if there's a winner on the Grid row
     * @param grid 2D 3x3 char array
     * @param player X or O
     * @return true or false
     */
    public static boolean isLineWinner(char[][] grid, char player) {
        int count;
        for (char[] row: grid) {
            count = 0;
            for (char letter: row) {
                if (letter == player) {
                    count += 1;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if there's a winner on the Grid column
     * @param grid 2D 3x3 char array
     * @param player X or O
     * @return true or false
     */
    public static boolean isColumnWinner(char[][] grid, char player) {
        int count;
        for (int i = 0; i < grid.length; i++) {
            count = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[j][i] == player) {
                    count += 1;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if there's a winner on any of the Grids diagonals
     * @param grid 2D 3x3 char array
     * @param player X or O
     * @return true or false
     */
    public static boolean isDiagonalWinner(char[][] grid, char player) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][i] == player) {
                count += 1;
            }
        }
        if (count == 3) {
            return true;
        } else {
            count = 0;
        }

        for (int i = grid.length - 1; i >= 0; i--) {
            if (grid[i][grid.length - 1 - i] == player) {
                count += 1;
            }
        }
        return count == 3;
    }

    /**
     * Check whether there are more X's then O's and vice versa.
     * If diff is >= 2 game state will be impossible
     * @param input string of chars of X's and/or 0's and/or empty lines
     * @return difference result as int
     */
    public static int countPlayerDiff(String input) {
        int countPlayerX = 0;
        int countPlayerO = 0;

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (letter == 'X') {
                countPlayerX += 1;
            } else if (letter == 'O') {
                countPlayerO += 1;
            }
        }
        return countPlayerX > countPlayerO ? countPlayerX - countPlayerO : countPlayerO - countPlayerX;
    }

    /**
     * Check if Grid has any empty spaces
     * @param grid 2D 3x3 char array
     * @return true if empty space >= 1
     */
    public static boolean hasEmptySpaces(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            // check row for empty
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '_') {
                    return true;
                }
            }
            // check column for empty
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[j][i] == '_') {
                    return true;
                }
            }
        }
        return false;
    }


//    public static void findWinner(String playerX, string playerO) {
//        if ((isLineWinner(grid, 'X') && isLineWinner(grid, 'O')) || (isColumnWinner(grid, 'X') && isColumnWinner(grid, 'O')) || countPlayerDiff(input) >= 2) {
//            System.out.println("Impossible");
//        } else if ((isLineWinner(grid, 'X') || isColumnWinner(grid, 'X')) || isDiagonalWinner(grid, 'X')) {
//            System.out.println("X wins");
//        } else if ((isLineWinner(grid, 'O') || isColumnWinner(grid, 'O')) || isDiagonalWinner(grid, 'O')) {
//            System.out.println("O wins");
//        } else if(!(isLineWinner(grid, 'X') || isColumnWinner(grid, 'O')) && hasEmptySpaces(grid)) {
//            System.out.println("Game not finished");
//        } else if(!(isLineWinner(grid, 'X') || isColumnWinner(grid, 'O')) && !hasEmptySpaces(grid)) {
//            System.out.println("Draw");
//        }
//    }

    public static void main(String[] args) {
        // write your code here
        int row, col;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
//        String input = "X_X_O____";
        char[][] grid = create_grid(input);

        printGrid(grid);

        while (true) {
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
                continue;
            }

            if (row < 1 || col < 1 || row > 3 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (grid[row-1][col-1] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            grid[row-1][col-1] = 'X';
            scanner.close();
            break;
        }
        printGrid(grid);

//        if ((isLineWinner(grid, 'X') && isLineWinner(grid, 'O')) || (isColumnWinner(grid, 'X') && isColumnWinner(grid, 'O')) || countPlayerDiff(input) >= 2) {
//            System.out.println("Impossible");
//        } else if ((isLineWinner(grid, 'X') || isColumnWinner(grid, 'X')) || isDiagonalWinner(grid, 'X')) {
//            System.out.println("X wins");
//        } else if ((isLineWinner(grid, 'O') || isColumnWinner(grid, 'O')) || isDiagonalWinner(grid, 'O')) {
//            System.out.println("O wins");
//        } else if(!(isLineWinner(grid, 'X') || isColumnWinner(grid, 'O')) && hasEmptySpaces(grid)) {
//            System.out.println("Game not finished");
//        } else if(!(isLineWinner(grid, 'X') || isColumnWinner(grid, 'O')) && !hasEmptySpaces(grid)) {
//            System.out.println("Draw");
//        }
    }
}
