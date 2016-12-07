package Trie;

import java.util.HashMap;
import java.lang.Character;

/**
 * Created by tharun on 12/6/16.
 */
public class TrieNode {
    private char data;
    private boolean isLeaf;
    private boolean isWord;
    private TrieNode parent;
    private HashMap<Character, TrieNode> children;

    TrieNode() {
        this.isLeaf = false;
        this.isWord = false;
        this.parent = null;
        this.children = new HashMap<Character, TrieNode>();
    }

    TrieNode(char data) {
        this();
        this.data = data;
    }

    public char getData() {
        return this.data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }

    public TrieNode getParent() {
        return this.parent;
    }

    public void setParent(TrieNode parent) {
        this.parent = parent;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return this.children;
    }

    public boolean getIsLeaf() {
        return this.isLeaf;
    }

    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public boolean getIsWord() {
        return this.isWord;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }

}
