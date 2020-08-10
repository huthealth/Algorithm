package Etc;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        Set<String> dictionary = new HashSet<>();
        int[] answer = {0,0};

        int i = 1;
        Character lastChar = null;
        for( ; i <= words.length ;i++) {
            if(dictionary.contains(words[i-1]) || (lastChar != null && lastChar != words[i-1].charAt(0))) {
                answer[0] = i % n;
                answer[1] = i / n + 1;
            }
            lastChar = words[i-1].charAt(words[i-1].length()-1);
            dictionary.add(words[i-1]);
        }


        return answer;
    }
}
