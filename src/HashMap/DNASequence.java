package HashMap;

/**
 * Created by tharun on 1/10/17.
 */
import java.util.HashSet;
class DNASequenceSolution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<String>();
        HashSet<String> repeated = new HashSet<String>();
        String substr;
        for (int i = 0; i < s.length() - 9; i++) {
            substr = s.substring(i, i + 10);
            if (!seen.add(substr)) {
                repeated.add(substr);
            }
        }
        return new ArrayList<String>(repeated);
    }
}
