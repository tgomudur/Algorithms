package Backtrack;

/**
 * Created by tharun on 1/11/17.
 * Problem description : https://leetcode.com/problems/sudoku-solver/
 */

class SudokuSolverSolution {
    public boolean isValidGuess(char[][] board, int i, int j, char guess) {
        int rowBase = i - i%3, colBase = j - j%3;
        // check if guess in row or col
        for (int x = 0; x < 9; x++) {
            if (board[i][x] == guess) return false;
            if (board[x][j] == guess) return false;
        }

        // check if guess in cube
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (board[rowBase + x][colBase + y] == guess)
                    return false;
            }
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solveSudoku(char[][] board) {
        for (int  i = 0; i < board.length;  i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidGuess(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) return true;
                            else board[i][j] = '.'; //backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}