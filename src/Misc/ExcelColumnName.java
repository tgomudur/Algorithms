package Misc;

/**
 * Created by tharun on 4/3/17.
 * https://leetcode.com/problems/excel-sheet-column-number/#/solutions
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */

public class ExcelColumnName {
    public int titleToNumber(String s) {
        int n = s.length();
        int value = 0;
        int digit = n - 1;
        int result = 0;

        for (char c : s.toCharArray()) {
            value = c - 'A' + 1;
            result += Math.pow(26, digit--)*value;
        }
        return result;
    }

    public int titlaToNum2(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result*26 + s.charAt(i) - 'A' + 1;
        }
        return result;
    }
}
