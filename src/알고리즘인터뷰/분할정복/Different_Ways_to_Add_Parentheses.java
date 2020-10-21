package 알고리즘인터뷰.분할정복;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Different_Ways_to_Add_Parentheses {
    Map<String,List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> answer = new ArrayList<>();

        if(input == null || input.equals("")) return answer;

        for(int i = 0 ; i < input.length();i++){
            char now = input.charAt(i);
            if(now == '+' || now == '-' || now =='*') {
                String p1 = input.substring(0,i);
                String p2 = input.substring(i+1);
                List<Integer> part1;
                List<Integer> part2;
                if(map.containsKey(p1)) part1 = map.get(p1);
                else part1 = diffWaysToCompute(input.substring(0,i));
                 if(map.containsKey(p2)) part2 = map.get(p2);
                 else part2 =  diffWaysToCompute(input.substring(i+1));
                for(int num1 : part1){
                    for(int num2 : part2) {
                        if(now == '+') answer.add(num1 + num2);
                        else if(now == '-') answer.add(num1 - num2);
                        else answer.add(num1 * num2);
                    }
                }
                //if(answer.isEmpty()) answer.add(Integer.parseInt(input));
            }
        }
        if(answer.isEmpty()) answer.add(Integer.parseInt(input));
        map.put(input,answer);
        return answer;
    }

    public static void main(String[] args) {
        Different_Ways_to_Add_Parentheses t = new Different_Ways_to_Add_Parentheses();
        for(int i : t.diffWaysToCompute("2-1-1+5")) System.out.println(i);
    }
}
