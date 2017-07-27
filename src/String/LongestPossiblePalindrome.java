package String;

import java.util.HashSet;
/**
 * Created by tharun on 12/15/16.
 *
 */
class LongestPossiblePalindromeSolution {
    public int findLongestPossiblePalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        char c;
        int count = 0;

        for (int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if (hs.contains(c)){
                hs.remove(c);
                count++;
            }else{
                hs.add(c);
            }
        }
        if (!hs.isEmpty()) return 2*count + 1;
        return 2*count;

    }
}
public class LongestPossiblePalindrome {
    public static void main(String[] args){
        LongestPossiblePalindromeSolution s = new LongestPossiblePalindromeSolution();
        System.out.println(s.findLongestPossiblePalindrome("bananassbananas"));
    }

}
