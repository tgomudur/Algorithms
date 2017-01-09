package String;

/**
 * Created by tharun on 1/7/17.
 */

import org.junit.Test;
import static org.junit.Assert.*;

class IsomorphicStringSolution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int[] m1 = new int[256];
        int[] m2 = new int[256];

        for (int i = 0; i < n; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = m2[t.charAt(i)] = i + 1;
        }

        return true;

        // Using hashmap, if character space is too large.
        // HashMap<Character, Character> map = new HashMap<>();
        // HashSet<Character> assigned = new HashSet<>();
        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < n; i++) {
        //     if (!map.containsKey(s.charAt(i))) {
        //         if (!assigned.add(t.charAt(i))) return false;
        //         map.put(s.charAt(i), t.charAt(i));
        //         sb.append(t.charAt(i));
        //     } else {
        //         sb.append(map.get(s.charAt(i)));
        //     }
        // }
        // return sb.toString().equals(t);
    }
}

public class IsomorphicString {
    @Test
    public void testIsIsomorphic() {
        IsomorphicStringSolution s = new IsomorphicStringSolution();
        assertEquals(true, s.isIsomorphic("egg", "foo"));
        assertEquals(false, s.isIsomorphic("egg", "bar"));
        assertEquals(true, s.isIsomorphic("paper", "title"));

    }
}
