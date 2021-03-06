package String;

import Trie.Trie;
/**
 * Created by incyphae10 on 12/20/16.
 */
class LongestCommonPrefixSolution {
    // Time Complexity: O(n*m)
    // where n is length of strs and m is length of the longest string in strs
    public String findLongestCommonPrefixBrute(String[] strs){
        int minLen = Integer.MAX_VALUE, minIdx = 0;
        int lcp = 0;

        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs.length; i++){
            if (strs[i].length() < minLen){
                minLen = strs[i].length();
                minIdx = i;
            }
        }

        if (minLen == 0) return "";

        for (int i = 0; i < minLen; i++){
            lcp = i;
            char c = strs[minIdx].charAt(i);
            for (int j = 0; j < strs.length; j++){
                if (strs[j].charAt(i) != c) return strs[j].substring(0, lcp);
            }
        }
        return strs[minIdx].substring(0, lcp + 1);
    }

    public String findLongestCommonPrefixUsingTrie(String[] strs){
         Trie trie = new Trie();
         for (int i = 0; i < strs.length; i++){
             if (strs[i].equals("")) return "";
             trie.addWord(strs[i]);
         }
         return trie.findLongestCommonPrefix();
    }
}
public class LongestCommonPrefix {
    public static void main (String[] args){
        LongestCommonPrefixSolution s = new LongestCommonPrefixSolution();
        String[] strs = {"hello","hell", "hel", "help", "helm"};
        System.out.println(s.findLongestCommonPrefixBrute(strs));
        System.out.println(s.findLongestCommonPrefixUsingTrie(strs));

    }
}
