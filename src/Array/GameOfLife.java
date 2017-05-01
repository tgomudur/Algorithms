package Array;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.

 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 * https://leetcode.com/problems/game-of-life/#/description
 */

public class GameOfLife {
    // Time : O(mn)
    // Space : O(1)
    public void gameOfLife(int[][] board) {
        int liveNeighbours = 0;
        int nRows = board.length, nCols = board[0].length;
        // Use two bits in each element. Left bit to store current state and right bit to store future state.
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                liveNeighbours = countAliveNeighbours(board, row, col, nRows, nCols);
                // Shifts 01 --> 11. Alive to staying alive
                if ((board[row][col] & 1) == 1 && (liveNeighbours >= 2 && liveNeighbours <= 3))
                    board[row][col] = 3;
                    // Shifts 00 --> 10. Dead to alive.
                else if ((board[row][col] & 1) == 0 && liveNeighbours == 3)
                    board[row][col] = 2;
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = board[row][col] >> 1;
            }
        }
    }

    public int countAliveNeighbours(int[][] board, int row, int col, int nRows, int nCols) {
        int liveNeighbours = 0;
        for (int i = Math.max(row - 1, 0); i <= Math.min(row + 1, nRows - 1); i++) {
            for (int j = Math.max(col - 1, 0); j <= Math.min(col + 1, nCols - 1); j++) {
                liveNeighbours += board[i][j] & 1;
            }
        }
        liveNeighbours -= board[row][col] & 1;
        return liveNeighbours;
    }
}
