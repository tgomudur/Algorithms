package Graph;

/**
 * Created by tharun on 12/8/16.
 */

public class Edge {
    Vertex source;
    Vertex destination;
    double weight;

    public Edge(Vertex from, Vertex to, double weight = 1.0) {
        this.source = from;
        this.destination = to;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString() {
        return source.getLabel() + "->" + destination.getLabel();
    }
}
