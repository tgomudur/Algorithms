package String;

import java.util.Map;
import java.util.HashMap;
/**
 * Created by tharun on 12/16/16.
 */

class LongestSubStringWithoutRepetitionSolution {
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
