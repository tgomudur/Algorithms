package String;

import java.util.Deque;
import java.util.ArrayDeque;
/**
 * Created by tharun on 12/18/16.
 * Problem description available here:
 * https://leetcode.com/problems/longest-absolute-file-path/
 */

class LongestAbsolutePathSolution{
    public int findLengthOfLongestPath(String input) {
        int maxLen = 0, currLen = 0, currLevel = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);

        for (String s : input.split("\n")){
            currLevel = s.lastIndexOf("\t") + 1;
            while (currLevel + 1 < stack.size()) stack.pop();
            currLen = stack.peek() + s.length() - currLevel + 1;
            stack.push(currLen);
            if (s.contains(".")) maxLen = Math.max(maxLen, currLen);
        }

        if (maxLen == 0) return maxLen;
        return maxLen - 1;
    }

    public int findLongestPath(String input) {
        //TODO: Add implementation
    }

}

public class LongestAbsolutePath {
    public static void main(String[] args){
        LongestAbsolutePathSolution s = new LongestAbsolutePathSolution();
        int result = s.findLengthOfLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
        System.out.println("Length of the longest path: "+result);
    }
}
