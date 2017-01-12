package Backtrack;

/**
 * Created by tharun on 1/11/17.
 * Problem description : https://leetcode.com/problems/sudoku-solver/
 */
import org.junit.Test;
import static org.junit.Assert.*;

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

    public boolean solve(char[][] board) {
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

public class SudokuSolver {
    @Test
    public void testSudokuSolver() {
        SudokuSolverSolution solver = new SudokuSolverSolution();
        String[] board = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        String[] expected = {"519748632","783652419","426139875","357986241","264317598","198524367","975863124","832491756","641275983"};

        char[][] inputBoard = new char[9][9];
        char[][] expectedBoard = new char[9][9];
        for (int i = 0; i < 9; i++) {
            inputBoard[i] = board[i].toCharArray();
            expectedBoard[i] = expected[i].toCharArray();
        }

        solver.solveSudoku(inputBoard);

        for (int i = 0; i < 9; i++)
            assertArrayEquals(expectedBoard[i], inputBoard[i]);
    }
}