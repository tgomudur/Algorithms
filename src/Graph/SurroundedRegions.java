package Graph;

/**
 * Created by incyphae10 on 5/5/17.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length < 2 || board[0].length < 2)
            return;

        int nRows = board.length, nCols = board[0].length;
        // Mark 'O' and connected 'O' neighbours in first column and last column
        for (int row = 0; row < nRows; row++) {
            if (board[row][0] == 'O')
                markRegionUsingDFS(board, row, 0);
            if (board[row][nCols - 1] == 'O')
                markRegionUsingDFS(board, row, nCols - 1);
        }

        // Mark 'O' and connected 'O' neighbours in first row and last row
        for (int col = 0; col < nCols; col++) {
            if (board[0][col] == 'O')
                markRegionUsingDFS(board, 0, col);
            if (board[nRows - 1][col] == 'O')
                markRegionUsingDFS(board, nRows - 1, col);
        }

        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                if (board[row][col] == 'O')
                    board[row][col] = 'X';
            }
        }

        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                if (board[row][col] == '#')
                    board[row][col] = 'O';
            }
        }

    }

    public boolean isValidIndex(int row, int col, int nRows, int nCols) {
        if (row < 0 || col < 0 || row >= nRows || col >= nCols)
            return false;
        return true;
    }

    public void markRegionUsingDFS(char[][] board, int row, int col) {
        if (!isValidIndex(row, col, board.length, board[0].length) || board[row][col] != 'O')
            return;

        board[row][col] = '#';
        if (row + 1 < board.length && board[row + 1][col] == 'O')
            markRegionUsingDFS(board, row + 1, col);

        if (row - 1 > 0 && board[row - 1][col] == 'O')
            markRegionUsingDFS(board, row - 1, col);

        if (col + 1 < board[0].length && board[row][col + 1] == 'O')
            markRegionUsingDFS(board, row, col + 1);

        if (col - 1 > 0 && board[row][col - 1] == 'O')
            markRegionUsingDFS(board, row, col - 1);
    }
}
