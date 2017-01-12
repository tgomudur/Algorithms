package String;

/**
 * Created by tharun on 1/12/17.
 * Problem description : https://leetcode.com/problems/minimum-window-substring/
 */
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

class MinimumWindowSubStringSolution {
    public HashMap<Character, Integer> countChars(String s) {
        HashMap<Character, Integer> map = new HashMap<>();;
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        return map;
    }

    // Time Complexity : O(n), Space Complexity: O(m); where m is the length of character space.
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> map = countChars(t);
        int left = 0, minLeft = 0, right = 0, minLen = s.length() + 1, count = 0;
        char c;
        for (right = 0; right < s.length(); right++) {
            c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) count++;
            }
            while (count == t.length()) {
                c = s.charAt(left);
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) count--;
                }
                left++;
            }
        }
        return (minLen >= s.length() + 1)? "": s.substring(minLeft, minLeft + minLen);
    }
    /** Brute force
     public int[] countChar(String s) {
     int[] count = new int[256];
     for (int i = 0; i < s.length(); i++)
     count[s.charAt(i)]++;
     return count;
     }

     public boolean arrayEquals(int[] sCount, int[] tCount) {
     for (int i = 0; i < 256; i++) {
     if(sCount[i] < tCount[i]) return false;
     }
     return true;
     }

     public String minWindow(String s, String t) {
     int m = s.length();
     int n = t.length();
     int[] sCount;
     int[] tCount = countChar(t);

     if (m == 0 || n == 0 || m < n) return "";

     for (int size = n; size < m + 1; size++){
     sCount = new int[256];
     for (int i = 0; i <= m - size; i++) {
     sCount = countChar(s.substring(i, i + size));
     if (arrayEquals(sCount, tCount)) return s.substring(i, i+size);
     }
     }

     return "";
     }
     */
}
public class MinimumWindowSubString {
    @Test
    public void testMinWindow() {
        MinimumWindowSubStringSolution s = new MinimumWindowSubStringSolution();
        assertEquals("BANC", s.minWindow("ADOBECODEBANC", "ABC"));
    }
}
