package BaekJun.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 좋은수열2661 {
    private static int N;
    private static List<String> answers = new ArrayList<>();
    private static boolean complete = false;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i =1; i<=3; i++) dfs(1,Integer.toString(i));
        System.out.println(answers.get(0));
    }

    private static void dfs(int now, String str) {
        if(now == N){
            answers.add(str);
            complete = true;
            return;
        }

        for(int i = 1; i<=3;i++){
            int last = now;
            int start = now -1;
            String nowStr = str + Integer.toString(i);
            boolean canMake = true;
            for(int len = 1; len <= nowStr.length()/2; len++){
                String temp1 = nowStr.substring(start,last);
                String temp2 = nowStr.substring(last);
                if(temp1.equals(temp2)){
                    canMake = false;
                    break;
                }
                start -= 2;
                last -= 1;
            }
            if(canMake){
                dfs(now+1,nowStr);
                if(complete) return;
            }
        }
    }
}
