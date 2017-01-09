package String;

/**
 * Created by tharun on 1/8/17.
 */
import org.junit.Test;
import static org.junit.Assert.*;

class ValidAnagramSolution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sCount = new int[26];
        int[] tCount = new int[26];

        for (int i = 0; i < s.length(); i++) sCount[s.charAt(i) - 'a']++;

        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i) - 'a']++;
            if (tCount[t.charAt(i) - 'a'] > sCount[t.charAt(i) - 'a']) return false;
        }

        return true;
    }
}

public class ValidAnagram {
    @Test
    public void testIsAnagram() {
        ValidAnagramSolution s = new ValidAnagramSolution();
        assertEquals(true, s.isAnagram("anagram", "nagaram"));
        assertEquals(false, s.isAnagram("rat", "car"));
    }
}
