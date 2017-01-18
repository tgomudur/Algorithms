package HashMap;

/**
 * Created by tharun on 1/17/17.
 * Problem description: "https://leetcode.com/problems/substring-with-concatenation-of-all-words/"
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

class SubstringConcatenationSolution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> expectedWords = new HashMap<>();
        HashMap<String, Integer> map;
        int expectedLength = 0;
        for (String word : words) {
            expectedWords.put(word, expectedWords.getOrDefault(word, 0) + 1);
            expectedLength += word.length();
        }

        int left = 0, right = 0, wordLength = words[0].length();
        String currentWord, key;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> result = new ArrayList<>();

        for (left = 0; left <= s.length() - expectedLength; left++) {
            map = new HashMap<>(expectedWords);
            for (right = 0; right < words.length; right++) {
                currentWord = s.substring(left + right*wordLength, left + right*wordLength + wordLength);
                if (map.containsKey(currentWord)) {
                    map.put(currentWord, map.get(currentWord) - 1);
                    if (map.get(currentWord) == 0) map.remove(currentWord);

                    if (map.size() == 0) {
                        result.add(left);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
}

public class SubstringConcatenation {
    @Test
    public void testFindSubstring() {
        SubstringConcatenationSolution s = new SubstringConcatenationSolution();
        String[] words = {"foo","bar"};
        assertEquals(Arrays.asList(0, 9), s.findSubstring("barfoothefoobarman", words));
    }
}
