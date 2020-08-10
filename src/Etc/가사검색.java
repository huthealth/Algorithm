package Etc;

import java.util.Arrays;

/*
효율성 0개
public class 가사검색 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for(int i =0;i<queries.length;i++){
            queries[i] = queries[i].replaceAll("\\?","\\.");
            for(int j = 0;j<words.length;j++){
                if(words[j].matches(queries[i])) answer[i]++;
            }
        }
        return answer;
    }
}
*/






/*
효율성 1개 맞음


class Trie2{
    private static final int ALPHABET_SIZE = 26;

    private static class TrieNode{
        private TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        private boolean isWord;
        private int wordCnt;

        public TrieNode(){
            Arrays.fill(children, null);
            isWord = false;
            wordCnt = 0;
        }
    }

    private TrieNode root = new TrieNode();

    public void insert(String key){
        TrieNode temp = root;

        for(int level = 0; level<key.length();level++){
            int index = key.charAt(level) - 'a';
            if(temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
            temp.wordCnt++;
        }
        temp.isWord = true;
    }

    public int query(String key){
        TrieNode temp = root;

        for(int level = 0; level<key.length(); level++){
            if(key.charAt(level) == '?'){
                String specialWord = key.substring(level);
                return query2(temp,specialWord);
            }
            int index = key.charAt(level) - 'a';
            if(temp.children[index] == null) return 0;
            temp = temp.children[index];
        }
        return 0;
    }

    private int query2(TrieNode from,String specialWord){
        if(specialWord.length() == 0) {
            if (from.isWord) {
                System.out.println("found");
                return 1;
            }
            return 0;
        }

        int ret = 0;
        for(int i =0;i<ALPHABET_SIZE;i++){
            if(from.children[i] != null){

                System.out.println(specialWord + "   "+ i);
                ret += query2(from.children[i],specialWord.substring(1));
            }
        }
        return ret;
    }
}

public class 가사검색 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie2 wordTrie = new Trie2();
        Trie2 backWordTrie = new Trie2();

        for(int i =0;i<words.length;i++){
            String backWord = new StringBuffer(words[i]).reverse().toString();
            wordTrie.insert(words[i]);
            backWordTrie.insert(backWord);
        }

        for(int i=0; i<queries.length;i++){
            if(queries[i].charAt(0) == '?'){
                String backQuery = new StringBuffer(queries[i]).reverse().toString();
                answer[i] = backWordTrie.query(backQuery);
            }
            else {
                answer[i] = wordTrie.query(queries[i]);
            }
        }
        return answer;
    }

    public static void main(String... args){

    String[] w  =  {"frodo", "front", "frost", "frozen", "frame", "kakao"};
    String[] q = {"fro??", "????o", "fr???", "fro???", "pro?"};
    가사검색 a = new 가사검색();
    System.out.println(Arrays.toString(a.solution(w, q)));
    }
}

 */

class Trie2{
    private static final int ALPHABET_SIZE = 26;

    private static class TrieNode{
        private TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        private boolean isWord;
        private int wordCnt;

        public TrieNode(){
            Arrays.fill(children, null);
            isWord = false;
            wordCnt = 0;
        }
    }

    private TrieNode root = new TrieNode();

    public void insert(String key){
        TrieNode temp = root;

        for(int level = 0; level<key.length();level++){
            int index = key.charAt(level) - 'a';
            if(temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
            temp.wordCnt++;
        }
        temp.isWord = true;
    }

    public int query(String key){
        TrieNode temp = root;

        for(int level = 0; level<key.length(); level++){
            if(key.charAt(level) == '?'){
                return temp.wordCnt;
            }
            int index = key.charAt(level) - 'a';
            if(temp.children[index] == null) return 0;
            temp = temp.children[index];
        }
        return 100000;
    }

}

public class 가사검색 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie2[] wordTrie = new Trie2[10001];
        Trie2[] backWordTrie = new Trie2[10001];

        for(int i =0;i<words.length;i++){
            int wordLen = words[i].length();
            String backWord = new StringBuffer(words[i]).reverse().toString();
            if(wordTrie[wordLen] == null) wordTrie[wordLen] = new Trie2();
            if(backWordTrie[wordLen] == null) backWordTrie[wordLen] = new Trie2();
            wordTrie[wordLen].insert(words[i]);
            backWordTrie[wordLen].insert(backWord);
        }

        for(int i=0; i<queries.length;i++){
            int wordLen = queries[i].length();
            if(queries[i].charAt(0) == '?'){
                String backQuery = new StringBuffer(queries[i]).reverse().toString();
                if(backWordTrie[wordLen] == null) answer[i] = 0;
                else answer[i] = backWordTrie[wordLen].query(backQuery);
            }
            else {
                if(wordTrie[wordLen] == null) answer[i] = 0;
                else answer[i] = wordTrie[wordLen].query(queries[i]);
            }
        }
        return answer;
    }

    public static void main(String... args){

        String[] w  =  {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] q = {"fro??", "????o", "fr???", "fro???", "pro?"};
        가사검색 a = new 가사검색();
        System.out.println(Arrays.toString(a.solution(w, q)));
    }
}