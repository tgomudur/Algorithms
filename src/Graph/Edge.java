package Graph;

public class Edge {
    Vertex source;
    Vertex destination;
    double weight;

    public Edge(Vertex from, Vertex to, double weight) {
        this.source = from;
        this.destination = to;
        this.weight = weight;
    }

    public Edge(Vertex from, Vertex to) {
        this(from, to, 1.0);
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
