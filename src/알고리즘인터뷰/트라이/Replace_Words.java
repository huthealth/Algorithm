package 알고리즘인터뷰.트라이;

public class Replace_Words {

}
/*
class Trie {
    static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode(){
            children = new TrieNode[26];
            isWord= false;
        }
    }

    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    void insert(String word){
        TrieNode now = root;
        for(int i = 0 ; i < word.length(); i++) {
            int index = (int)(word.charAt(i) -'a');
            if(now.children[index] == null) {
                now.children[index] = new TrieNode();
            }
            now = now.children[index];
        }
        now.isWord = true;
    }

    String findRoot(String word, StringBuilder sb) {
        TrieNode now  = root;
        for(int i = 0 ; i< word.length(); i++) {
            char c = word.charAt(i);
            int index = (int)(c -'a');
            if(now.children[index] == null) {
                return word;
            }
            sb.append(c);
            now = now.children[index];
            if(now.isWord) return sb.toString();
        }
        return word;
    }
}


class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        StringBuilder answer = new StringBuilder();
        for(int i = 0 ; i< dictionary.size() ; i++) {
            trie.insert(dictionary.get(i));
        }
        String[] words = sentence.split(" ");
        String[] afters = new String[words.length];

        for(int i = 0 ; i< words.length; i++) {
            afters[i] = trie.findRoot(words[i], new StringBuilder());
            answer.append(afters[i]);
            answer.append(" ");
        }
        answer.deleteCharAt(answer.length()-1);

        return answer.toString();
    }
}

 */