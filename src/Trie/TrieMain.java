package Trie;

/**
 * Created by tharun on 12/6/16.
 */
public class TrieMain {
    public static void main(String[] args) {
        Trie t = new Trie();

        System.out.println("\nTesting addWord function");
        t.addWord("helm");
        t.addWord("hele");
        t.addWord("hello");
        t.addWord("hell");
        t.addWord("heo");

        System.out.println("\nTesting search");
        System.out.println(t.search("hello").getData());

        System.out.println("\nPrinting all words");
        t.printAllWords();

        System.out.println("\nTesting prefix search");
        if (t.isPrefix("hel"))
            System.out.println("\nYES");
        else
            System.out.println("\nNOPE");


        System.out.println("\nNum of elements: " + t.numOfWords);
        System.out.println("\nLongest Common Prefix: " + t.findLongestCommonPrefix());

    }
}
