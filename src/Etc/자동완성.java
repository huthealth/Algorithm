package Etc;

class Trie{
    private static final int ALPHABET_SIZE = 26;
    private static class TrieNode{
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        int wordCnt;
        boolean isWord;

        private TrieNode(){
            wordCnt = 0;
            isWord = false;
            for(int i =0;i<ALPHABET_SIZE;i++) children[i] = null;
        }
    }

    private TrieNode root = new TrieNode();

    public void insert(String key){
        TrieNode temp = root;
        for(int level = 0;level<key.length();level++){
            int index = key.charAt(level) - 'a';
            if(temp.children[index] == null) temp.children[index] = new TrieNode();
            temp.wordCnt++;
            temp = temp.children[index];
        }
        temp.isWord = true;
        temp.wordCnt++;
    }

    public int autoComplete(String key){
        TrieNode temp = root;
        for(int level = 0; level < key.length(); level++){
            int index = key.charAt(level) - 'a';
            if(temp.wordCnt == 1) return level;
            temp = temp.children[index];
        }
        return key.length();
    }
}

public class 자동완성 {
    public int solution(String[] words) {
        int answer = 0;
        Trie t = new Trie();
        for(String str : words) t.insert(str);
        for(String str : words) answer +=t.autoComplete(str);
        return answer;
    }
    public static void main(String... args){
        자동완성 a = new 자동완성();
        String[] s = {"go","gone","guild"};
        a.solution(s);
    }

}
