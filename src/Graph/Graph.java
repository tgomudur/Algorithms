package Graph;

/**
 * Created by tharun on 12/8/16.
 */

import java.util.Set;

public interface Graph<Vertex> {
    public boolean addEdge(Edge e);
    public boolean removeEdge(Edge e);
    public Set<Vertex> getAdjacentVertices(Vertex v);
}
