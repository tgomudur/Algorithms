package Graph;

/**
 * Created by tharun on 12/8/16.
 */
import java.util.*;

public class Vertex {
    String label;
    double weight;

    public Vertex(String label, double weight) {
        this.label = label;
        this.weight = weight;
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

}
