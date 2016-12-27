package HashMap;

/**
 * Created by tharun on 12/26/16.
 */

public class Solution {
    // Using XOR
    public char findTheDifference(String s, String t) {
        int n = t.length();
        char result = t.charAt(n - 1);
        for (int i = 0; i < n - 1; i++){
            result ^= s.charAt(i)^t.charAt(i);
        }
        return result;
    }
    // Using hashmap
    public char findTheDifference2(String s, String t) {
         HashMap<Character, Integer> map = new HashMap<Character, Integer>();
         char c;
         for (int i = 0; i < s.length(); i++){
             c = s.charAt(i);
             if (!map.containsKey(c)) map.put(c, 1);
             else map.put(c, map.get(c) + 1);
         }

         for (int i = 0; i < t.length(); i++){
             c = t.charAt(i);
             if (map.containsKey(c) && map.get(c) > 0) map.put(c, map.get(c) - 1);
             else return c;
         }
         return t.charAt(0);
     }
}
public class FindDifference {

}
