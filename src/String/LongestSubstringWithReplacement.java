package String;

import java.util.Map;
import java.util.HashMap;
import java.lang.*;

/**
 * Created by tharun on 12/20/16.
 * Longest Repeating Character Replacemen
 * Problem description - https://leetcode.com/problems/longest-repeating-character-replacement/
 */

class LongestSubstringWithReplacementSolution {
    public String generateSubstring (String s){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char key, maxKey = s.charAt(0);
        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++){
            key = s.charAt(i);
            if (!map.containsKey(key)) map.put(key, 1);
            else map.put(key, map.get(key) + 1);

            if (map.get(key) > maxCount){
                maxCount = map.get(key);
                maxKey = key;
            }
        }

        return new String(new char[s.length()]).replace("\0", String.valueOf(maxKey));
    }
    public String findLongestSubStringWithReplacement(String s, int k) {
        if (s == null || s.length() == 0) return "";

        String result = "";
        int n = s.length();
        int start = 0, end = 0, maxCount = 0, maxLength = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (end = 0; end < n; end++){
            if (!map.containsKey(s.charAt(end))) map.put(s.charAt(end), 1);
            else map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
            maxCount = Math.max(maxCount, map.get(s.charAt(end)));

            while (end - start + 1 - maxCount > k){
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }

            if (end - start + 1 > maxLength){
                maxLength = end - start + 1;
                result = s.substring(start, end + 1);
            }
        }
        return generateSubstring(result);
    }
}

public class LongestSubstringWithReplacement {
    public static void main (String[] args){
        LongestSubstringWithReplacementSolution s = new LongestSubstringWithReplacementSolution();
        System.out.println(s.findLongestSubStringWithReplacement("ABABABBA", 3));

    }
}
