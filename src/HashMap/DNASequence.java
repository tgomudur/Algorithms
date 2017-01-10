package HashMap;

/**
 * Created by tharun on 1/10/17.
 * Problem description: https://leetcode.com/problems/repeated-dna-sequences/
 */
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

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

public class DNASequence {
    @Test
    public void testDNASequence() {
        DNASequenceSolution s = new DNASequenceSolution();
        assertEquals(Arrays.asList("AAAAACCCCC", "CCCCCAAAAA"), s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
