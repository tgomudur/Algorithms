package Graph;

/**
 * Floyd's City of Blinding Lights
 * https://www.hackerrank.com/challenges/floyd-city-of-blinding-lights
 */
import java.util.*;

public class FloydShortestPath {
    public static void runFloydShortestPath(int[][] shortestPathMatrix, int nNodes) {
        for (int k = 0; k < nNodes; k++) {
            for (int i = 0; i < nNodes; i++) {
                for (int j = 0; j < nNodes; j++) {
                    int distanceThroughK = shortestPathMatrix[i][k] + shortestPathMatrix[k][j];
                    if (distanceThroughK > 0 && shortestPathMatrix[i][j] > distanceThroughK)
                        shortestPathMatrix[i][j] = distanceThroughK;
                }
            }
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int nNodes = sc.nextInt(); // No of nodes
        int nEdges = sc.nextInt(); // No of edges
        int[][] shortestPathMatrix = new int[nNodes][nNodes];
        for (int[] row : shortestPathMatrix) Arrays.fill(row, Integer.MAX_VALUE);
        for (int i = 0; i < nEdges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            shortestPathMatrix[u - 1][v - 1] = w;
        }

        for (int u = 0; u < nNodes; u++)
            shortestPathMatrix[u][u] = 0;

        // printMatrix(shortestPathMatrix);
        runFloydShortestPath(shortestPathMatrix, nNodes);
        // printMatrix(shortestPathMatrix);

        int nQueries = sc.nextInt();
        for (int i = 0; i < nQueries; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println((shortestPathMatrix[a - 1][b - 1] == Integer.MAX_VALUE)? -1 : shortestPathMatrix[a - 1][b - 1]);
        }

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
