package HashMap;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ValidAnagramTest {
    @Test
    public void testValidAnagram() {
        ValidAnagram solution = new ValidAnagram();
        assertTrue(solution.isAnagram("silent", "listen"));
        assertFalse(solution.isAnagram("lamb", "bamh"));
    }
}