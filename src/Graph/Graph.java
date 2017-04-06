package Graph;

/**
 * Created by tharun on 12/8/16.
 */

import java.util.List;

public interface Graph {
    public boolean addEdge(Edge e);
    public boolean removeEdge(Edge e);
    public List<Edge> getAdjacentVertices(Vertex v);
}
