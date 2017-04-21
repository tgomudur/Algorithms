package Backtrack;

/**
 * Created by incyphae10 on 4/20/17.
 */
public class GenerateWellFormedParanthesis {
    public List<String> generateWellFormedParanthesis(int n) {
        return generateHelperBrute(new ArrayList<>(), "", n);
    }

    // Inefficient solution. Checks all combinations.
    // Time: O(n*(2^(2n))
    public List<String> generateHelperBrute(List<String> result, String s, int n) {
        if (n == 0) {
            if (isWellFormed(s)) result.add(s);
            return result;
        }

        generateHelperBrute(result, s + ")", n - 1);
        generateHelperBrute(result, s + "(", n - 1);

        return result;
    }

    public boolean isWellFormed(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty() || stack.pop() != "(")
                    return false;
            }
        }

        return stack.isEmpty()
    }
    // Does not check the entire list of possible strings but only valid candidates
    // Time : O(2^(2n))
    public List<String> generateHelperBackTrack(List<String> result, String s, int openBraceCount, int closeBraceCount, int n) {
        if (s.length() == 2*n) {
            result.add(s);
            return result;
        }

        if (openBraceCount < n)
            generateHelperBackTrack(result, s + "(", openBraceCount + 1, closeBraceCount, n);

        if (closeBraceCount < openBraceCount)
            generateHelperBackTrack(result, s + ")", openBraceCount, closeBraceCount + 1, n);

        return result;
    }

    // Using stringbuilder to avoid string concatenation
    public List<String> generateHelperBackTrack(List<String> result, StringBuilder s, int openBraceCount, int closeBraceCount, int n) {
        if (s.length() == 2*n) {
            result.add(s.toString());
            return result;
        }

        if (openBraceCount < n) {
            generateHelperBackTrack(result, s.append("("), openBraceCount + 1, closeBraceCount, n);
            s.deleteCharAt(s.length() - 1); // or s.setLength(s.length() - 1);
        }

        if (closeBraceCount < openBraceCount) {
            generateHelperBackTrack(result, s.append(")"), openBraceCount, closeBraceCount + 1, n);
            s.deleteCharAt(s.length() - 1);
        }

        return result;
    }

}
