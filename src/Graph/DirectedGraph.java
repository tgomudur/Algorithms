package Graph;

/**
 * Created by tharun on 1/18/17.
 */

import java.util.*;

public class DirectedGraph implements Graph {
    Vertex start;
    HashMap<Vertex, List<Edge>> adjList;

    DirectedGraph(Vertex start) {
        this.start = start;
        this.adjList = new HashMap<>();
    }

    public boolean addEdge(Edge edge) {
        Vertex source = edge.getSource();
        Vertex dest = edge.getDestination();

        if (!adjList.containsKey(source)) adjList.put(source, new ArrayList<Edge>());

        adjList.get(source).add(edge);
        return true;
    }

    public boolean removeEdge(Edge edge) {
        Vertex source = edge.getSource();
        Vertex dest = edge.getDestination();

        if (!adjList.containsKey(source)) return false;

        adjList.get(source).remove(dest);
        return true;
    }

    public List<Edge> getAdjacentVertices(Vertex v) {
        return adjList.get(v);
    }

    public String doBFS(Vertex start) {
        System.out.println(adjList);
        LinkedList<Vertex> q = new LinkedList<Vertex>();
        Set<Vertex> visited = new HashSet<Vertex>();
        StringBuilder sb = new StringBuilder();

        if (!adjList.containsKey(start)) {
            throw new IllegalArgumentException("Start Vertex Not Found");
        }

        q.add(start);

        while (!q.isEmpty()) {
            Vertex child = q.poll();

            sb.append(child.getLabel());
            visited.add(child);

            if (!adjList.containsKey(child)) continue;
            for (Edge v : adjList.get(child)) {
                if (!visited.contains(v.getDestination())) {
                    q.offer(v.getDestination());
                }
            }

        }
        return sb.toString();
    }
}
