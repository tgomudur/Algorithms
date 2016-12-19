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

        // Using stack to store the length of the path, as we go deeper into the directory structure
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);

        for (String s : input.split("\n")){
            // Finding level by counting tabs
            currLevel = s.lastIndexOf("\t") + 1;
            // If currentLevel is above level of path in stack, find parent
            while (currLevel + 1 < stack.size()) stack.pop();
            // Calculate length of path with current file/folder. Remove '/t' and add 1 to include '/'
            currLen = stack.peek() + s.length() - currLevel + 1;
            stack.push(currLen);
            // If file found, check if its maxLen?
            if (s.contains(".")) maxLen = Math.max(maxLen, currLen);
        }

        if (maxLen == 0) return maxLen;
        return maxLen - 1;
    }

    public String findLongestPath(String input) {
        //TODO: Add implementation
        int maxLen = 0, currLen = 0, currLevel = 0;
        String currPath = "";
        String maxPath = "";
        Deque<String> stack = new ArrayDeque<String>();
        stack.push("");

        for (String s : input.split("\n")){
            // Finding level by counting tabs
            currLevel = s.lastIndexOf("\t") + 1;
            // If currentLevel is above level of path in stack, find parent
            while (currLevel + 1 < stack.size()) stack.pop();
            // Calculate length of path with current file/folder. Remove '/t' and add 1 to include '/'
            currLen = stack.peek().length() + s.length() - currLevel + 1;
            currPath = stack.peek() + '/' + s.replace("\t", "");
            stack.push(currPath);
            // If file found, check if its maxLen?
            if (s.contains(".") && currLen > maxLen){
                maxLen = currLen;
                maxPath = currPath;
            }
        }
        return maxPath;
    }

}

public class LongestAbsolutePath {
    public static void main(String[] args){
        LongestAbsolutePathSolution s = new LongestAbsolutePathSolution();
        int result = s.findLengthOfLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
        String result1 = s.findLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");

        System.out.println("Length of the longest path: "+result);
        System.out.println("The longest path: "+result1);

    }
}
