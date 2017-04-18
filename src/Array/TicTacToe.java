package Array;

/**
 * Created by tharun on 4/17/17.
 * Check if the game has ended or not.
 */
public class TicTacToe {
    int[] rows;
    int[] cols;
    int size;
    int diagonal;
    int antiDigonal;

    public TicTacToe(int n) {
        size = n;
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDigonal = 0;
    }

    public boolean isGameOver(int row, int col, int player) {
        if (Math.abs(rows[row]) == size || Math.abscols[col]) == size ||
                Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size) {
            return true;
        }
        return false;
    }

    public int addMove(int row, int col, int player) {
        int toAdd = (player == 1)? 1 : -1;
        rows[row] += toAdd;
        rows[col] += toAdd;

        if ((row - col) == 0)
            diagonal += toAdd;

        if ((row + col) == (n - 1))
            antiDiagonal += toAdd;

        if (isGameOver(row, col, player))
            return player;

        return 0;
    }
}
