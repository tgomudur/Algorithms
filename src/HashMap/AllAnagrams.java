package HashMap;

/**
 * Created by tharun on 12/27/16.
 * Problem description: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


class AllAnagramSolution {
    // Works with unlimited character space.
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> pMap = new HashMap<Character, Integer>();

        int n = s.length();
        int m = p.length();
        int left = 0, right = 0;
        char c;

        if (m > n) return result;

        for (int i = 0; i < m; i++){
            c = p.charAt(i);
            if (pMap.containsKey(c)) pMap.put(c, pMap.get(c) + 1);
            else pMap.put(c, 1);
        }

        while (left <= n - m){
            while (right - left < m){
                c = s.charAt(right);
                if (map.containsKey(c)) map.put(c, map.get(c) + 1);
                else map.put(c, 1);
                right++;
            }

            if (map.equals(pMap))
                result.add(left);

            map.put(s.charAt(left), map.get(s.charAt(left)) - 1);

            if (map.get(s.charAt(left)) == 0)
                map.remove(s.charAt(left));
            left++;

        }
        return result;
    }
}

public class AllAnagrams {
    public static void main(String[] args){
        AllAnagramSolution s = new AllAnagramSolution();
        System.out.println(s.findAnagrams("cbaebabacd", "abc"));
    }
}
