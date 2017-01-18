package Graph;

/**
 * Created by tharun on 12/8/16.
 */

public interface Graph<Vertex> {
    public boolean addEdge();
    public boolean removeEdge();
    public Set<Vertex> getAdjacentVertices();
}
