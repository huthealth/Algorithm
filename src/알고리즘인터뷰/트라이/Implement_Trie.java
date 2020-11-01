package 알고리즘인터뷰.트라이;

import java.util.MissingFormatWidthException;

public class Implement_Trie {

}


class Trie {
    static class TrieNode {
        char value;
        boolean isWord;
        TrieNode[] children;
        TrieNode(char value){
            this.value = value;
            isWord = false;
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode pointer = root;
        for(int i = 0 ; i< word.length(); i++) {
            char alphabet = word.charAt(i);
            int index = alphabet- 'a';
            if(pointer.children[index] == null) pointer.children[index] = new TrieNode(alphabet);
            pointer = pointer.children[index];
        }
        pointer.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode pointer = root;
        for(int i = 0 ; i< word.length(); i++) {
            char alphabet = word.charAt(i);
            int index = alphabet- 'a';
            if(pointer.children[index] == null) return false;
            pointer = pointer.children[index];
        }
        return pointer.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode pointer = root;
        for(int i = 0 ; i< prefix.length(); i++) {
            char alphabet = prefix.charAt(i);
            int index = alphabet- 'a';
            if(pointer.children[index] == null) return false;
            pointer = pointer.children[index];
        }
        return true;
    }
}