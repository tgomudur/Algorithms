package Graph;

/**
 * Created by tharun on 4/5/17.
 *
 */

import java.io.File;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class ShortestReach {
    public static int bfs(int[][] adjMat, int source, int dest) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[adjMat.length];

        int distance = 0;
        queue.offer(source);
        boolean found = false;
        HashMap<Integer, Integer> path = new HashMap<>();
        while (!queue.isEmpty()) {
            int node = queue.remove();
            visited[node] = true;
            // adjMat[node][i]

            if (node == dest) {
                distance = 0;
                int current = dest;
                while (current != source) {
                    found = true;
                    if (path.containsKey(current)) {
                        current = path.get(current);
                        distance += 6;
                    }
                }
                // System.out.print(distance + " ");
                break;
            }
            else {
                for (int i = 1; i < adjMat.length; i++) {
                    if (!visited[i] && i != node && adjMat[node][i] > 0) {
                        queue.offer(i);
                        path.put(i, node);
                    }
                }
            }
        }
        return (found)? distance : -1;

    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        try {
//            File file = new File("data/Graph/ShortestReach/Input/Test1.txt");
//            Scanner sc = new Scanner(file);
//            while (sc.hasNextLine()) {
//                int q = sc.nextInt();
//                for (int i = 0; i < q; i++) {
//                    int n = sc.nextInt();
//                    int m = sc.nextInt();
//                    int[][] adjMat = new int[n + 1][n + 1];
//                    for (int j = 0; j < m; j++) {
//                        int node1 = sc.nextInt();
//                        int node2 = sc.nextInt();
//                        adjMat[node1][node2] = 6;
//                        adjMat[node2][node1] = 6;
//                    }
//                    int startNode = sc.nextInt();
//                    StringBuilder sb = new StringBuilder();
//                    for (int endNode = 1; endNode <= n; endNode++)
//                        if (endNode != startNode) {
//                            sb.append(bfs(adjMat, startNode, endNode) + " ");
//                        }
//                    System.out.println(sb.toString().trim());
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            File file = new File("data/Graph/ShortestReach/Input/Test1.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                int q = sc.nextInt();
                for (int i = 0; i < q; i++) {
                    int n = sc.nextInt();
                    int m = sc.nextInt();
                    UndirectedGraph graph = new UndirectedGraph();
                    HashMap<String, Vertex> vertices = new HashMap<>();
                    for (int j = 0; j < m; j++) {
                        String node1 = "" + sc.nextInt();
                        String node2 = "" + sc.nextInt();
                        vertices.put(node1, new Vertex(node1));
                        vertices.put(node2, new Vertex(node2));
                        graph.addEdge(new Edge(vertices.get(node1), vertices.get(node2), 6));
                    }
                    int startNode = sc.nextInt();
                    Vertex source = vertices.get("" + startNode);
                    graph.computePaths(source);

                    StringBuilder sb = new StringBuilder();

                    for (int endNode = 1; endNode <= n; endNode++)
                        if (endNode != startNode) {
                            Vertex dest = vertices.get("" + endNode);
                            sb.append(graph.findShortestPathDistance(source, dest) + " ");
                        }
                    System.out.println(sb.toString().trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}