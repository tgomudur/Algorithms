package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class UndirectedGraph implements Graph {
    HashMap<Vertex, List<Edge>> adjList;

    public UndirectedGraph() {
        adjList = new HashMap<>();
    }

    @Override
    public boolean addEdge(Edge e) {
        Vertex source = e.getSource();
        if (!adjList.containsKey(source))
            adjList.put(source, new ArrayList<>());
        adjList.get(source).add(e);
        return true;
    }

    @Override
    public boolean removeEdge(Edge e) {
        Vertex source = e.getSource();
        Vertex dest = e.getDestination();

        if (!adjList.containsKey(source) || !adjList.containsKey(dest)) return false;

        adjList.get(source).remove(e);
        adjList.get(dest).remove(dest);
        return true;
    }

    @Override
    public List<Edge> getAdjacentVertices(Vertex v) {
        if (!adjList.containsKey(v))
            adjList.put(v, new ArrayList<>());
        return adjList.get(v);
    }

    public void computePaths(Vertex source) {
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        Vertex current;
        source.minDistance = 0;
        queue.add(source);

        while (!queue.isEmpty()) {
            current = queue.remove();
            if (!adjList.containsKey(current))
                continue;
            for (Edge child : adjList.get(current)) {
                Vertex v = child.getDestination();
                double distanceThroughCurrent = child.getWeight() + current.minDistance;
                if (distanceThroughCurrent < v.minDistance) {
                    queue.remove(v);
                    v.minDistance = distanceThroughCurrent;
                    v.parent = current;
                    queue.add(v);
                }
            }
        }
    }

    public int findShortestPathDistance(Vertex dest) {

        return (Double.compare(dest.minDistance, Double.POSITIVE_INFINITY) == 0)? -1 : (int) dest.minDistance;
// int distance = 0;
//        Vertex current = dest;
//        while (current != null) {
//            distance += 6;
//            current = current.parent;
//        }
//        return distance;
    }
}
