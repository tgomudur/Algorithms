package Trie;

/**
 * Created by tharun on 12/6/16.
 */
public class TrieMain {
    public static void main(String[] args) {
        Trie t = new Trie();

        System.out.println("\nTesting addWord function");
        t.addWord("home");
        t.addWord("hose");
        t.addWord("hello");
        t.addWord("hell");
        t.addWord("abc");

        System.out.println("\nTesting search");
        System.out.println(t.search("hello").getData());

        System.out.println("\nPrinting all words");
        t.printAllWords();

        System.out.println("\nTesting prefix search");
        if (t.isPrefix("hel"))
            System.out.println("\n YES");
        else
            System.out.println("\n NOPE");


        System.out.println("\n Num of elements: " + t.numOfWords);
        System.out.println("\n Longest Common Prefix: " + t.findLongestCommonPrefix());

    }
}
