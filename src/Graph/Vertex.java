package Graph;

public class Vertex implements Comparable<Vertex>{
    String label;
    double weight;
    Vertex parent;
    double minDistance;

    public Vertex(String label, double weight) {
        this.label = label;
        this.weight = weight;
        this.parent = null;
        this.minDistance = Double.POSITIVE_INFINITY;
    }

    public Vertex(String label) {
        this(label, 1.0);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getWeight() {
        return weight;
    }

    public void setLabel(double weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public int compareTo(Vertex v) {
        if (minDistance < v.minDistance)
            return -1;
        else if (minDistance == v.minDistance)
            return 0;
        else
            return 1;
    }
}
