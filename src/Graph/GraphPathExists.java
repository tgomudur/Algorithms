package Graph;

/**
 * Created by tharun on 1/20/17.
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

class GraphPathExistsSolution {
    public boolean pathExists(DirectedGraph graph, Vertex source, Vertex dest) {
        LinkedList<Vertex> queue = new LinkedList<>();
        HashSet<Vertex> visited = new HashSet<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex child = queue.poll();
            visited.add(child);
            if (child.equals(dest)) return true;

            for (Vertex v : graph.getAdjacentVertices(child)) {
                if (!visited.contains(v))
                    queue.add(v);
            }
        }
        return false;
    }
}

public class GraphPathExists {
    @Test
    public void testPathExists() {
        Vertex a = new Vertex("0");
        Vertex b = new Vertex("1");
        Vertex c = new Vertex("2");
        Vertex d = new Vertex("3");

        DirectedGraph g = new DirectedGraph(c);
        g.addEdge(new Edge(a, c));
        g.addEdge(new Edge(c, a));
        g.addEdge(new Edge(a, b));
        g.addEdge(new Edge(b, c));
        g.addEdge(new Edge(c, d));
        g.addEdge(new Edge(d, d));

        GraphPathExistsSolution s = new GraphPathExistsSolution();
        assertEquals(true, s.pathExists(g, a, d));
        assertEquals(false, s.pathExists(g, d, a));

    }
}
