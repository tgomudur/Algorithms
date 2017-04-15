package String;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <a href=https://leetcode.com/problems/valid-palindrome/#/description>More Info</a>
 */
public class ValidPalindrome {
    public boolean isAlphaNumeric(char ch) {
        if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57))
            return true;
        return false;
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        char leftChar, rightChar;
        while (left < right) {
            leftChar = s.charAt(left);
            rightChar = s.charAt(right);
            // Use Character.isLetterOrDigit(leftChar) instead.
            if (!isAlphaNumeric(leftChar)) {
                left++;
            } else if (!isAlphaNumeric(rightChar)) {
                right--;
            } else {
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar))
                    return false;
                left++;
                right--;
            }
        }
        return true;
    }
}
