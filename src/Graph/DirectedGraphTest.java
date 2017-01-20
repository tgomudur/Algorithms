package Graph;

/**
 * Created by tharun on 1/19/17.
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class DirectedGraphTest {
    @Test
    public void testBFS() {
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

        assertEquals("2031", g.doBFS(c));
    }
}
