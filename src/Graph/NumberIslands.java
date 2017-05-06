package Graph;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * https://leetcode.com/problems/number-of-islands/#/description
 */

public class NumberIslands {
    // Time : O(n^2)
    // Space: O(1)
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length, n = grid[0].length, count = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1') {
                    runDFS(grid, row, col, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isValid(int rowIdx, int colIdx, int nRows, int nCols) {
        if (rowIdx < 0 || rowIdx >= nRows || colIdx < 0 || colIdx >= nCols)
            return false;
        return true;
    }

    public void runDFS(char[][] grid, int row, int col, int m, int n) {
        if (!isValid(row, col, m, n) || grid[row][col] == '0')
            return;

        grid[row][col] = '0';
        runDFS(grid, row - 1, col, m, n);
        runDFS(grid, row + 1, col, m, n);
        runDFS(grid, row, col - 1, m, n);
        runDFS(grid, row, col + 1, m, n);
    }
}
