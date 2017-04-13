package Array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PascalTriangleTest {
    public boolean assertLists(List<List<Integer>> expected,  List<List<Integer>> actual) {
        assertEquals(expected.size(), actual.size());
        List<Integer> expectedRow;
        List<Integer> actualRow;

        for (int i = 0; i < expected.size(); i++) {
            expectedRow = expected.get(i);
            actualRow = actual.get(i);
            assertEquals(expectedRow.size(), actualRow.size());
            for (int j = 0; j < expectedRow.size(); j++) {
                if (!expectedRow.get(j).equals(actualRow.get(j)))
                    return false;
            }
        }
        return true;
    }
    @Test
    public void testPascalTriangle() {
        PascalTriangle solution = new PascalTriangle();
        List<List<Integer>> expected  = Arrays.asList(Arrays.asList(1), Arrays.asList(1,1), Arrays.asList(1,2,1), Arrays.asList(1,3,3,1));
        assertTrue(assertLists(expected, solution.generate(4)));
    }
}