package Programmers;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        int[] answer;
        List<Integer> ans = new ArrayList<>();
        int len = arr.length;
        int before = arr[0];
        ans.add(before);
        for(int i = 1 ; i< len; i++) {
            if(before == arr[i]) continue;
            ans.add(arr[i]);
            before = arr[i];
        }

        answer = new int[ans.size()];
        for(int i = 0 ; i< ans.size(); i++){
            answer[i] = ans.get(i);
        }

        return answer;
    }
}
