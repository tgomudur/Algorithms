package String;

import java.util.HashMap;

/**
 * Created by tharun on 4/4/17.
 * https://leetcode.com/problems/roman-to-integer/#/description
 * <p>Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.</p>
 *
 */
public class RomanToInt {
    public int romanToInt(String s) {
        int result = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        char[] letters = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] values = {1, 5, 10, 50, 100, 500, 1000};
        for (int i = 0; i < letters.length; i++)
            map.put(letters[i], values[i]);

        int prevValue = 0, currentValue = 0;
        int i = s.length() - 1;
        while (i >= 0) {
            currentValue = map.get(s.charAt(i));
            if (currentValue >= prevValue) {
                result += currentValue;
            } else {
                result -= currentValue;
            }
            prevValue = currentValue;
            i--;
        }
        return result;
    }
}
