package Trie;

import java.util.HashMap;
import java.lang.Character;
import java.util.Map;

/**
 * Created by tharun on 12/6/16.
 */

public class Trie {
    private TrieNode root;
    protected int numOfWords;

    Trie() {
        root = new TrieNode();
        numOfWords = 0;
    }

    public void addWord(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();
        TrieNode current = root;
        TrieNode newNode;
        // Iteratively insert each character in the word
        for (int i = 0; i < word.length(); i++) {
            char data = word.charAt(i);
            // Case 1: Doesn't contain the character,add data to children
            if (!children.containsKey(data)) {
                newNode = new TrieNode(data);
                children.put(data, newNode);
            }
            // Case 2: If character is present below, go to that node
            current = children.get(data);

            // Setting isWord if its last character
            if (i == word.length() - 1) {
                current.setIsWord(true);
                this.numOfWords += 1;
            }
            children = current.getChildren();
        }

    }

    public TrieNode search(String word) {
        //Searches for a word, returns last node of the last character in the word
        HashMap<Character, TrieNode> children = root.getChildren();
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char data = word.charAt(i);
            if (children.containsKey(data)) {
                current = children.get(data);
            } else {
                return null;
            }
            children = current.getChildren();
        }
//        if (current.getIsWord())
//            return current;
//        else
//            return null;
        return current;
    }

    public void printAllWords() {
        // Uses a util function to print all words using DFS
        if (root == null) {
            // TODO: Raise Custom Exception
            System.out.println("\nError: Trie is Empty!");
        } else {
            this.printAllWordsUtil(this.root, "");
        }
    }

    private void printAllWordsUtil(TrieNode root, String prefix) {
        // Prints all words in trie using DFS
        if (root == null)
            return;
        // Case 1: End of a word
        if (root.getIsWord())
            System.out.println(prefix);

        // Recursive through all children
        HashMap<Character, TrieNode> children = root.getChildren();
        for (Character data : children.keySet()) {
            printAllWordsUtil(children.get(data), prefix + data);
        }
    }

    public boolean isPrefix(String prefix) {
        if (root == null) {
            System.out.println("Error: Trie is Empty");
        } else {
            if (this.search(prefix) != null)
                return true;
        }
        return false;
    }

    public String findLongestCommonPrefix(){
        if (root != null) return findLongestCommonPrefix(root, "");
        return "";
    }

    private String findLongestCommonPrefix(TrieNode root, String prefix){
        if (root == null || root.getIsWord()) return prefix;
        if (root.getChildren().size() == 1){
            for (Map.Entry<Character, TrieNode> entry : root.getChildren().entrySet())
                return findLongestCommonPrefix(entry.getValue(), prefix + entry.getKey());
        }
        return prefix;
    }
}
