package Graph.Djikstras;

import java.io.*;
import java.util.*;

class Vertex implements Comparable<Vertex>{
    int id;
    int parent;
    double distance;

    Vertex(int id, int parent) {
        this.id = id;
        this.parent = parent;
        this.distance = Double.POSITIVE_INFINITY;
    }

    Vertex(int id) {
        this(id, -1);
    }

    @Override
    public int compareTo(Vertex that) {
        double diff = this.distance - that.distance;
        return (int) diff;
    }
}

class Edge {
    int source;
    int dest;
    double weight;

    Edge(int source, int dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

class Node implements Comparable<Node>{
    double distanceFromSource;
    int vertexId;

    Node(int vertexId, double distanceFromSource) {
        this.vertexId = vertexId;
        this.distanceFromSource = distanceFromSource;
    }

    @Override
    public int compareTo(Node that) {
        double diff = this.distanceFromSource - that.distanceFromSource;
        return (int) diff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof  Edge))
            return false;
        Node n = (Node) o;
        if (n.vertexId == this.vertexId)
            return true;

        return false;
    }

    public int hashCode() {
        return vertexId;
    }

}

class Graph {
    int size;
    Map<Integer, Vertex> vertices;
    Map<Integer, List<Edge>> adjList;
    Map<String, Edge> edgeMap;

    Graph(int size) {
        this.size = size;
        this.vertices = new HashMap<>();
        this.adjList = new HashMap<>();
        this.edgeMap = new HashMap<>();
    }

    void addVertex(int vertex) {
        if (!vertices.containsKey(vertex))
            vertices.put(vertex, new Vertex(vertex));
    }

    void addEdge(int source, int dest, int weight) {
        if (!adjList.containsKey(source)) {
            adjList.put(source, new ArrayList<Edge>());
            String key = source + "#" + dest;
            Edge edge = new Edge(source, dest, weight);
            edgeMap.put(key, edge);
            adjList.get(source).add(edge);
        } else {
            String key = source + "#" + dest;
            if (edgeMap.containsKey(key) && edgeMap.get(key).weight > weight) {
                edgeMap.get(key).weight = weight;
            } else {
                Edge edge = new Edge(source, dest, weight);
                edgeMap.put(key, edge);
                adjList.get(source).add(edge);
            }

        }
    }

    void addEdges(int source, int dest, int weight) {
        addEdge(source, dest, weight);
        addEdge(dest, source, weight);
    }

//    void resetAllVertices() {
//        for (Map.Entry<Integer, Vertex> entry : vertices.entrySet()) {
//            Vertex v = entry.getValue();
//            v.distance = Double.POSITIVE_INFINITY;
//        }
//    }

    void findSingleSourceShortestPath(int source) {
        double[] distanceFromSource = new double[size + 1];
        Arrays.fill(distanceFromSource, Double.POSITIVE_INFINITY);

        Set<Integer> visited = new HashSet<>();
        distanceFromSource[source] = 0.0;
        Queue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(source, distanceFromSource[source]));

        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            // System.out.println(String.format("Id: %d, Dist: %f", currentNode.vertexId, currentNode.distanceFromSource));
            if (!visited.contains(currentNode.vertexId)) {
                visited.add(currentNode.vertexId);
                for (Edge e : adjList.get(currentNode.vertexId)) {
                    double distanceThroughCurrent = distanceFromSource[currentNode.vertexId] + e.weight;
                    if (distanceFromSource[e.dest] > distanceThroughCurrent) {
                        distanceFromSource[e.dest] =  distanceThroughCurrent;
                        queue.add(new Node(e.dest, distanceFromSource[e.dest]));
                    }
                }
            }
        }

        for (int i = 1; i <= size; i++) {
            if (i != source) {
                double shortestDist = distanceFromSource[i];
                System.out.print(((distanceFromSource[i] == Double.POSITIVE_INFINITY)? -1 : (int) shortestDist) + " ");
            }
        }
    }

//    void findShortestPathFromSource(int source) {
//        Queue<Vertex> queue = new PriorityQueue<>();
//        Set<Vertex> visited = new HashSet<>();
//        resetAllVertices();
//
//        Vertex s = vertices.get(source);
//        s.distance = 0;
//        queue.add(s);
//
//        while (!queue.isEmpty()) {
//            Vertex currentNode = queue.remove();
//            if (!visited.contains(currentNode)){
//                visited.add(currentNode);
//                for (Edge e : adjList.get(currentNode.id)) {
//                    Vertex destNode = vertices.get(e.dest);
//                    if (currentNode.distance + e.weight < destNode.distance) {
//                        queue.remove(destNode);
//                        destNode.distance = currentNode.distance + e.weight;
//                        destNode.parent = currentNode.id;
//                        queue.add(destNode);
//                    }
//                }
//            }
//        }
//
//
//    }
}

public class ShortestPath {
    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long startTime = System.nanoTime();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Incyphae\\Documents\\Code\\Algorithms\\data\\Graph\\ShortestReach\\Input\\input07.txt")));
        StringTokenizer tokenizer;
        int t = Integer.parseInt(br.readLine());
        for(int a0 = 0; a0 < t; a0++){
            tokenizer = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());
            Graph graph = new Graph(n);

            for (int i = 1; i <= n; i++)
                graph.addVertex(i);

            for(int a1 = 0; a1 < m; a1++){
                tokenizer = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                int r = Integer.parseInt(tokenizer.nextToken());
                graph.addEdges(x, y, r);
            }

            int s = Integer.parseInt(br.readLine());
            long endTime = System.nanoTime();
            System.out.println("Input Duration: " + (endTime - startTime)/1000000000.0);

            startTime = System.nanoTime();
            // graph.findShortestPathFromSource(s);
            graph.findSingleSourceShortestPath(s);
            endTime = System.nanoTime();
            System.out.println("Execution Duration: " + (endTime - startTime)/1000000000.0);

            System.out.println();
        }
    }
}
