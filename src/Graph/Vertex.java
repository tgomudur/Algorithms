package Graph;

public class Vertex implements Comparable<Vertex>{
    String label;
//    double weight;
    Vertex parent;
    double minDistance;

    public Vertex(String label) {
        this.label = label;
        this.parent = null;
        this.minDistance = Double.POSITIVE_INFINITY;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
        return Double.compare(this.minDistance, v.minDistance);
//        if (minDistance < v.minDistance)
//            return -1;
//        else if (minDistance == v.minDistance)
//            return 0;
//        else
//            return 1;
    }
}
