package String;

import java.util.*;
/**
 * Created by tharun on 1/5/17.
 */

class FirstNonRepeatingWordSolution {
    public String findFirstNonRepeatingWord(final char[] input) {
        List<Integer> value;
        HashMap<String, List<Integer>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String result = "";
        char c;
        for (int i = 0; i < input.length; i++) {
            c = input[i];
            if (c == ' ' || c == '.') {
                String word = sb.toString().toLowerCase();
                if (!map.containsKey(word)) {
                    map.put(word, Arrays.asList(i, 1));
                } else {
                    value = map.get(word);
                    value.set(1, value.get(1) + 1);
                    map.put(word, value);
                }
//                value.add(Math.min(map.getOrDefault(word, Integer.MAX_VALUE), i));
//                value.add()
//                map.put(sb.toString(), );
//                System.out.println(result);
//                if (map.containsKey(word)) {
//                    if (result.equals(word)) result = "";
//                } else {
//                    map.put(word, 1);
//                    if (result.equals("")) result = word;
//                }

                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        int minValue = Integer.MAX_VALUE;
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            value = entry.getValue();
            if (value.get(1) == 1) {
                if (value.get(0) < minValue) {
                    minValue = value.get(0);
                    result = entry.getKey();
                }
            }
        }
        System.out.println(map);
        return result;
    }
}
public class FirstNonRepeatingWord {
    public static void main (String[] args) {
        char[] stream = "The angry dog was red. And the cat was also angry.".toCharArray();
        FirstNonRepeatingWordSolution s = new FirstNonRepeatingWordSolution();
        System.out.println(s.findFirstNonRepeatingWord(stream));
    }
}
