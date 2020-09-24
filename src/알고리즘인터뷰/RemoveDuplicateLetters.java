package 알고리즘인터뷰;

import java.io.CharArrayReader;
import java.util.Deque;
import java.util.LinkedList;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] alphabet = new int[27];
        boolean[] visited = new boolean[27];
        char[] input = s.toCharArray();
        for(char c : input){
            alphabet[c-'a']++;
        }
        Deque<Character> deque = new LinkedList<>();
        for(char c : input) {
            alphabet[c-'a']--;
            if(visited[c-'a']) continue;
            while(!deque.isEmpty() && c <deque.peekLast() && alphabet[deque.peekLast()-'a'] != 0) {
                visited[deque.pollLast() - 'a'] = false;
            }
            visited[c-'a'] = true;
            deque.addLast(c);
        }
        StringBuilder answer = new StringBuilder();
        while(!deque.isEmpty()) {
            answer.append(deque.pollFirst());
        }
        return answer.toString();
    }
}
