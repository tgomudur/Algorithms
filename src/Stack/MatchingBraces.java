package Stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/ctci-balanced-brackets/submissions/code/41969946
 */
public class MatchingBraces {
    public static boolean matchBraces(char c1, char c2) {
        String openBraces = "{[(";
        String closeBraces = "}])";
        String s1 = "" + c1;
        String s2 = "" + c2;
        if (openBraces.indexOf(s1) == closeBraces.indexOf(s2))
            return true;
        return false;
    }
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();


        for (char c : expression.toCharArray()) {
            if (c == '{' || c == '[' || c == '(')
                stack.push(c);
            else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty() || !matchBraces(stack.peek(), c)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}