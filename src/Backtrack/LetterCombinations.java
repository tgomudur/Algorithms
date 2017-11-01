package Backtrack;

import java.util.List;
import java.util.ArrayList;

/**
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/#/description
 */

public class LetterCombinations {
    String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0 || digits == null)
            return result;
        return findLetterCombinationsHelper(digits, result, new StringBuilder(), 0);
    }

    public List<String> findLetterCombinationsHelper(String digits, List<String> result, StringBuilder current, int start) {
        if (current.length() == digits.length()) {
            result.add(current.toString());
            return result;
        }

        String options = mapping[Character.getNumericValue(digits.charAt(start))];
        for (char option : options.toCharArray()) {
            findLetterCombinationsHelper(digits, result, current.append(option), start + 1);
            current.setLength(current.length() - 1);
        }

        return result;
    }
}
