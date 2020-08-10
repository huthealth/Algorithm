package Etc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Kakao2 {
    int[] visited;
    ArrayList<String> ary = new ArrayList<>();
    ArrayList<String> ary2 = new ArrayList<>();
    String[] delim;
    String[] rank;
    int Length;
    long answer = 0;

    public long solution(String expression) {

        String[] num = expression.split("[^0-9]");
        for(String n : num) ary.add(n);
        Set<Character> set = new HashSet<>();
        int idx = 1;
        for(int i =0;i<expression.length();i++){
            if(expression.charAt(i) == '*' ||expression.charAt(i) == '+' || expression.charAt(i) == '-'){
                set.add(expression.charAt(i));
                ary.add(idx,Character.toString(expression.charAt(i)));
                idx +=2;
            }
        }
        for(String s : ary) ary2.add(s);
        Length = set.size();
        visited = new int[Length];
        delim = new String[Length];
        rank = new String[Length];
        idx= 0;
        for(char c : set) {
            delim[idx] = Character.toString(c);
            idx++;
        }

        func(0);

        return answer;
    }
    public void func(int now){
        if(now == Length){

            for(int i =0;i<Length;i++){
                int idx = 0;
                while(true){
                    if(ary.get(idx).equals(rank[i])){
                        //if(idx ==0) continue;
                        getAns(idx);
                        idx = 0;
                    }
                    if(idx == ary.size()-1) break;
                    idx++;
                }
            }
           // System.out.println(ary.get(0));

            long temp = Math.abs(Long.parseLong(ary.get(0)));
            //System.out.println(temp);
            answer = Math.max(answer,temp);
            ary.clear();
            for(String s : ary2) ary.add(s);
        }
        for(int i=0;i<Length;i++){
            if(visited[i] == 1) continue;
            rank[now] = delim[i];
            visited[i] = 1;
            func(now+1);
            visited[i] = 0;
        }
    }

    public void getAns(int idx) {
        //씨발 병신
        //long first = Integer.parseInt(ary.get(idx - 1));
        //long second = Integer.parseInt(ary.get(idx + 1));
        long first = Long.parseLong(ary.get(idx - 1));
        long second = Long.parseLong(ary.get(idx + 1));
        long result = 0;
        if (ary.get(idx).equals("*")) result = first * second;
        if (ary.get(idx).equals("+")) result = first + second;
        if (ary.get(idx).equals("-")) result = first - second;
        ArrayList<String> newAry = new ArrayList<>();
        for (int i = 0; i < ary.size(); i++) {
            if (i == idx - 1) newAry.add(Long.toString(result));
            if (i != idx && i != idx + 1&& i != idx-1) {
                newAry.add(ary.get(i));
            }
        }
        for(String s : newAry) System.out.print(s);
        System.out.println();
        ary = newAry;
    }
    public static void main(String... args){
        Kakao2 k = new Kakao2();
        String s ="1+1+1+1+1+1*10";
        System.out.println(k.solution(s));
    }
}
