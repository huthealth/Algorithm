package Etc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 단체사진찍기 {
    Map<String, List<String>> pattern = new HashMap<>();
    String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    int[] visited = new int[8];
    public int solution(int n, String[] data) {
        int answer = 0;

        for(int i = 0 ; i< n; i++) {
            Character person1 = data[i].charAt(0);
            Character person2 = data[i].charAt(2);
            String friend;
            String condition;
            if(person1 > person2) friend = person2.toString() + person1.toString();
            else friend = person1.toString() + person2.toString();
            condition = data[i].substring(3);
            if (!pattern.containsKey(friend)) {

                pattern.put(friend, new ArrayList<>());
            }
            pattern.get(friend).add(condition);
        }

        for(int i = 0; i<8; i++){
            String now = friends[i];
            visited[i] = 1;
            answer += lining(now);
            visited[i] = 0;
        }
        return answer;
    }
    public int lining(String now) {
        if(now.length() == 8) {
            if(isOk(now)) return 1;
            return 0;
        }

        int ret = 0;
        if(now.length() >= 2 && !isOk(now)) return 0;
        for(int i = 0; i< 8;i++){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            ret += lining(now+friends[i]);
            visited[i] = 0;
        }
        return ret;
    }

    public boolean isOk(String line) {
        int len = line.length();
        int diff = len -2;
        int diff2 = diff;
        for(int i = 0 ; i<= diff; i++){
            Character person1 = line.charAt(i);
            Character person2 = line.charAt(len-1);
            String friend;
            if(person1 > person2) friend = person2.toString() + person1.toString();
            else friend = person1.toString() + person2.toString();

            if(pattern.containsKey(friend)) {
                List<String> conditionList = pattern.get(friend);
                for(int j = 0;j<conditionList.size();j++) {
                    if(conditionList.get(j).charAt(0) == '=' && diff2 != Integer.parseInt(conditionList.get(j).substring(1)))
                        return false;
                    if(conditionList.get(j).charAt(0) == '>' && diff2 <=Integer.parseInt(conditionList.get(j).substring(1)))
                        return false;
                    if(conditionList.get(j).charAt(0) == '<' && diff2 >=Integer.parseInt(conditionList.get(j).substring(1)))
                        return false;
                }
            }
            diff2--;
        }
        return true;
    }

    public static void main(String... args){
        단체사진찍기 d = new 단체사진찍기();
        int n = 2;
        String[] data = {"M~C<2", "C~M>1"};
        String[] data2 = {"N~F=0", "R~T>2"};
        System.out.println(  d.solution(n,data2));
    }
}
