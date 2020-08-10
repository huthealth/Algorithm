package Etc;

import java.util.HashMap;
import java.util.Map;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character,Integer> skillOrderMap = new HashMap<>();
        for(int i =0;i<skill.length();i++) {
            skillOrderMap.put(skill.charAt(i),i);
        }
        for(int i  =0;i < skill_trees.length; i++) {
            boolean success = true;
            Integer canLearn = 0;
            for(int j = 0; j< skill_trees[i].length() ; j++) {
                Integer wantToLearn = skillOrderMap.get(skill_trees[i].charAt(j));
                if(wantToLearn != null) {
                    if (wantToLearn.equals(canLearn)) canLearn++;
                    else {
                        success = false;
                        break;
                    }
                }
            }
            if(success) answer++;
        }
        return answer;
    }
}
