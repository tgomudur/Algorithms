package Graph;

/**
 * Created by tharun on 12/8/16.
 */
import java.util.*;

public class Vertex {
    String label;
    double weight;


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getWeight() {
        return weight;
    }

    public void setLabel(double weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        return lebel.hashCode();
    }
}
