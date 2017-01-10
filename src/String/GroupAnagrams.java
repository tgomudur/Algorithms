package String;

/**
 * Created by tharun on 1/8/17.
 * Problem description: https://leetcode.com/problems/anagrams/
 */

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import static org.hamcrest.CoreMatchers.*;
import java.util.Comparator;
import java.util.Collections;

class GroupAnagramsSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        char[] arr;
        String sortedStr;

        for (int i = 0; i < strs.length; i++) {
            // Sort String
            arr = strs[i].toCharArray();
            Arrays.sort(arr);
            sortedStr = new String(arr);

            if (!map.containsKey(sortedStr)) map.put(sortedStr, new ArrayList<String>());
            map.get(sortedStr).add(strs[i]);
        }

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}

class CustomComparator implements Comparator<List<String>> {
    @Override
    public int compare(List<String> l1, List<String> l2) {
        return l2.size() - l1.size();
    }
}

public class GroupAnagrams {
    public boolean checkListEquality(List<List<String>> actual, List<List<String>> expected) {
        int m = actual.size();
        int n = expected.size();

        if (m != n) return false;
        for (int i = 0; i < m; i++) {
            if (!(actual.get(i).containsAll(expected.get(i)) && expected.get(i).containsAll(actual.get(i))))
                return false;
        }
        return true;
    }

    @Test
    public void testGroupAnagrams() {
        GroupAnagramsSolution s = new GroupAnagramsSolution();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<String> tmp = Arrays.asList("ate", "eat", "tea");
        List<String> tmp1 = Arrays.asList("nat", "tan");
        List<String> tmp2 = Arrays.asList("bat");
        List<List<String>> expected = Arrays.asList(tmp, tmp1, tmp2);
        List<List<String>> actual = s.groupAnagrams(input);
        Collections.sort(actual, new CustomComparator());
//        System.out.println(expected);
//        System.out.println(actual);
//        System.out.println(checkListEquality(actual, expected));

        assertTrue(checkListEquality(actual, expected));
    }
}
