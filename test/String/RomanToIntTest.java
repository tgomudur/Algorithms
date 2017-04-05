package String;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanToIntTest {
    @Test
    public void romanToInt() throws Exception {
        RomanToInt solution = new RomanToInt();
        assertEquals(621, solution.romanToInt("DCXXI"));
        assertEquals(1996, solution.romanToInt("MCMXCVI"));
    }

}