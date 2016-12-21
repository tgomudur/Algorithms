package String;

/**
 * Created by tharun on 12/20/16.
 * Problem description - https://leetcode.com/problems/longest-repeating-character-replacement/
 */

class LongestSubstringWithReplacement {
    public int findLongestSubStringWithReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;

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
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}

public class LongestSubstringWithReplacement {
    
}
