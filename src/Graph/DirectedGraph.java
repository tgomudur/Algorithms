package Graph;

/**
 * Created by tharun on 1/18/17.
 */

import java.util.*;

public class DirectedGraph implements Graph<Vertex> {
    Vertex start;
    HashMap<Vertex, Set<Vertex>> adjList;

    DirectedGraph(Vertex start) {
        this.start = start;
        this.adjList = new HashMap<>();
    }

    public boolean addEdge(Edge edge) {
        Vertex source = edge.getSource();
        Vertex dest = edge.getDestination();

        if (!adjList.containsKey(source)) adjList.put(source, new HashSet<Vertex>());

        adjList.get(source).add(dest);
        return true;
    }

    public boolean removeEdge(Edge edge) {
        Vertex source = edge.getSource();
        Vertex dest = edge.getDestination();

        if (!adjList.containsKey(source)) return false;

        adjList.get(source).remove(dest);
        return true;
    }

    public Set<Vertex> getAdjacentVertices(Vertex v) {
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
            for (Vertex v : adjList.get(child)) {
                if (!visited.contains(v)) {
                    q.offer(v);
                }
            }

        }
        return sb.toString();
    }
}
