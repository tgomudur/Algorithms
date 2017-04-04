package Array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tharun on 4/4/17.
 *
 */
public class MajorityElementTest {
    @Test
    public void majorityElement() throws Exception {
        int[] input = {2,1,3,4,3,3,4,3};
        int[] input2 = {2,1,3,4,3,3,4,3,3};
        MajorityElement solution = new MajorityElement();
        assertEquals(-1, solution.majorityElement(input));
        assertEquals(3, solution.majorityElement(input2));
    }

    @Test
    public void majorityElement2() throws Exception {
        int[] input = {2,1,3,4,3,3,4,3};
        int[] input2 = {2,1,3,4,3,3,4,3,3};
        MajorityElement solution = new MajorityElement();
        assertEquals(-1, solution.majorityElement2(input));
        assertEquals(3, solution.majorityElement2(input2));

    }

}