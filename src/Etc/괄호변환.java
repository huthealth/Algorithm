package Etc;

import java.util.*;

public class 괄호변환 {
    public String solution(String p) {
        String answer = "";
        answer = getResult(p);
        return answer;
    }
    public String getResult(String w){
        if(w.isEmpty()) return "";
        String u,v;
        int count =0;
        int idx =0;
        while(true){
            if(w.charAt(idx) == '(') count++;
            else count--;
            idx++;
            if(count == 0) break;
        }
        u = w.substring(0,idx);
        v = w.substring(idx);
        if(isCorrect(u)) return u + getResult(v);
        String temp = "(";
        temp += getResult(v);
        temp += ")";
        u = u.substring(1,u.length()-1);
        u = reverseString(u);
        return temp + u;
    }
    public boolean isCorrect(String u){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i =0;i<u.length();i++){
            if(u.charAt(i) =='(') stack.push('(');
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return true;
    }

    public String reverseString(String u){
        String ret ="";
        for(int i =0;i<u.length();i++){
            if(u.charAt(i) == '(') ret +=")" ;
            else ret += "(";
        }
        return ret;
    }
}

