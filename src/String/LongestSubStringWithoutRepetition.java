package String;

import java.util.Map;
import java.util.HashMap;
/**
 * Created by tharun on 12/16/16.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description
 */

class LongestSubStringWithoutRepetitionSolution {
    // Using hashmap
    // Time : O(n)
    // Space : O(k) - where k = min(n, m), n - length of string, m - character space size.
    public String findLongestSubstringWithoutRepetition2(String s) {
        int n = s.length();
        int left = 0, right = 0, maxLength = 0, maxStartIdx;
        // Maps character to position in array
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while (left < n && right < n) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)));
            }
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                maxStartIdx = left;
            }
            map.put(s.charAt(right), right + 1);
            right++;
        }
    }

    public String findLongestSubstringWithoutRepetition(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int maxLen = 0;
        char c;
        int currentLen = 0;
        int maxStartIdx = 0;

        for (int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if (map.containsKey(c))
                start = Math.max(start, map.get(c) + 1);
            map.put(c, i);
            currentLen = i - start + 1;
            if (currentLen > maxLen){
                maxLen = currentLen;
                maxStartIdx = start;
            }
        }
        return s.substring(maxStartIdx, maxStartIdx + maxLen);
    }
}

public class LongestSubStringWithoutRepetition {
    public static void main(String[] args){
        LongestSubStringWithoutRepetitionSolution s = new LongestSubStringWithoutRepetitionSolution();
        System.out.println(s.findLongestSubstringWithoutRepetition("acbdddwwwqqefdefefef"));
    }
}
