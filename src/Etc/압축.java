package Etc;

import java.util.*;

public class 압축 {
    public int[] solution(String msg) {

        List<Integer> ans = new ArrayList<>();
        int count = 1;
        Map<String,Integer> dictionary = new HashMap<>();
        for(int i ='A';i<='Z';i++){
            char alpa = (char)i;
            dictionary.put(Character.toString(alpa),count++);
        }
        for(int i =0;i<msg.length();i++){
            String st = Character.toString(msg.charAt(i));
            String st2 = st;
            for(int j =i+1;j<msg.length();j++){
                st2 += msg.charAt(j);
                if(dictionary.containsKey(st2)) st = st2;
                else{
                    dictionary.put(st2,count++);
                    break;
                }
            }
            ans.add(dictionary.get(st));
        }
        int[] answer = new int[ans.size()];
        for(int i =0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }

        return answer;
    }
}
