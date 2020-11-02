package 알고리즘인터뷰.트라이;

public class Implement_Magic_Dictionary {
}

class Trie {
    static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
    }

    TrieNode root;
    Trie(){
        root = new TrieNode();
    }

    void insert(String word){
        TrieNode now = root;
        for(int i = 0 ; i < word.length() ; i++) {
            int index = (int)(word.charAt(i) - 'a');
            if(now.children[index] ==null) now.children[index] = new TrieNode();
            now = now.children[index];
        }
        now.isWord = true;
    }

    boolean search(TrieNode node,String word,int wordIndex ,int count){
        if(count < 0 || wordIndex > word.length()) return false;
        if(wordIndex == word.length()) {
            return count == 0 && node.isWord;
        }
        TrieNode now = node;
        int index = word.charAt(wordIndex) - 'a';
        if(count == 0) {
            //if(wordIndex == word.length()-1 && now.children[index].isWord) return true;
            if(now.children[index] == null) return false;
            return search(node.children[index],word,wordIndex+1,count);
        }

        for(int i =0 ; i < 26; i++) {
            if(now.children[i] == null) continue;
            if(i == index) {
                if(search(now.children[i],word,wordIndex+1,count)) return true;
            }
            else {
                if(search(now.children[i],word,wordIndex+1,count-1)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("hello");
        t.insert("leetcode");
        System.out.println( t.search(t.root,"hhllo",0,1));
    }
}