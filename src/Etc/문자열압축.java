package Etc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Map;

public class 문자열압축 {
    String S;
    Integer N;
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        S =s;
        N = s.length();
        for(int i =1 ;i<=N/2;i++){
            String result = "";
            String pattern = s.substring(0,i);
            answer = Math.min(answer,getLenth(pattern,i,i,1,result));
        }
        return answer;
    }
    public int getLenth(String pattern, int now, int len, int count, String result){
        if(now >= N-len){
            String token = S.substring(now,S.length());
            if(token.equals(pattern)){
                count++;
                String num = Integer.toString(count);
                result = num + pattern + result;
                return result.length();
            }
            if(count != 1){
                String num = Integer.toString(count);
                result = num + pattern + result;
            }
            else {
                result = pattern + result;
            }
            return result.length() + token.length();
        }

        String token = S.substring(now,now+len);
        if(token.equals(pattern)){
            count++;
            return getLenth(pattern,now+len,len,count,result);
        }
        if(count != 1){
            String num = Integer.toString(count);
            result = num + pattern + result;
        }
        else {
            result = pattern + result;
        }
        return getLenth(token,now+len,len,1,result);
    }

    public static void main(String... args){

        Deque<Integer> a = new ArrayDeque<>();
        a.pop();
        //문자열압축 a = new 문자열압축();
        //String s ="a";
        //System.out.println(a.solution(s));
    }
}
