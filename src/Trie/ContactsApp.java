package Trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactsApp {
    public static class TrieNode {
        char letter;
        HashMap<Character, TrieNode> children;
        boolean isWord;

        public TrieNode(char letter) {
            this.letter = letter;
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
    public static class Trie {
        TrieNode start;
        int numOfWords;

        public Trie() {
            this.start = new TrieNode('/');
            this.numOfWords = 0;
        }

        public void addWord(String word) {
            int prefixCount = 0;
            TrieNode current = start;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!current.children.containsKey(c)) {
                    TrieNode newNode =  new TrieNode(c);
                    current.children.put(c, newNode);
                }

                current = current.children.get(c);

                if (i == word.length() - 1)
                    current.isWord = true;
            }
            this.numOfWords++;

        }

        // Currently times out for large inputs. Working on optimized solution.
        // Store all count of all prefixes in the node
        public int findPartial(String prefix) {
            TrieNode current = start;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (!current.children.containsKey(c)) {
                    return 0;
                } else {
                    current = current.children.get(c);
                }
            }

            return dfs(current, 0);

        }

        public int dfs(TrieNode current, int count) {
            if (current == null)
                return count;
            if (current.isWord)
                count++;

            for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
                count = dfs(entry.getValue(), count);
            }
            return count;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Trie trie = new Trie();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")) {
                trie.addWord(contact);
            } else if (op.equals("find")) {
                System.out.println(trie.findPartial(contact));
            }
        }
    }
}
