package HashMap;

import java.util.HashMap;
import java.util.HashSet;
/**
 * Created by tharun on 12/22/16.
 * Problem description: https://leetcode.com/problems/word-pattern/
 */

class WordPatternSolution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<String, Character> map = new HashMap<String, Character>();
        HashSet<Character> hs = new HashSet<Character>();
        boolean[] seen = new boolean[256];
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;

        for (int i = 0; i < words.length;  i++){
            String key = words[i];
            char value = pattern.charAt(i);
            if (map.containsKey(key) && value != map.get(key)) return false;
            if (!map.containsKey(key) && hs.contains(value)) return false;
            // if (!map.containsKey(key) && seen[value - 'a']) return false;

            map.put(key, value);
            hs.add(value);
            // seen[value - 'a'] = true;
        }
        return true;
    }
}

public class WordPattern {
    public static void main (String[] args){
        WordPatternSolution s = new WordPatternSolution();
        System.out.println(s.wordPattern("abba", "dog cat cat dog"));
    }
}
