package HashMap;

/**
 * Created by incyphae10 on 1/10/17.
 */
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

class CustomComparator implements Comparator<Map.Entry<Character, Integer>> {
    @Override
    public int compare (Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
        return entry2.getValue() - entry1.getValue();
    }
}

class SortCharactersByFrequencySolution {
    public String repeatString(char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return s;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(map.size(), new CustomComparator());

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.size(); i++) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            sb.append(repeatString(entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}

public class SortCharactersByFrequency {
    @Test
    public void testfrequencySort() {
        SortCharactersByFrequencySolution s = new SortCharactersByFrequencySolution();
        assertTrue(s.frequencySort("tree").equals("eetr") || s.frequencySort("tree").equals("eert"));
    }
}
