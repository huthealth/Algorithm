package BaekJun.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 단어수학1339 {
    static List<Character> list = new ArrayList<>();
    static int[] numbers = new int[10];
    static long answer = 0;
    static int N;
    static int C;
    static String[] words;
    static String[] alphabets = new String[27];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt( br.readLine());
        words = new String[N];
        Set<Character> set =new HashSet<>();
        for(int i = 0 ; i< N;i++) {
            words[i] = br.readLine();
            for(int j = 0 ; j< words[i].length();j++){
                char c = words[i].charAt(j);
                if(set.contains(c))continue;
                set.add(c);
                list.add(c);
            }
        }
        C= list.size();

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int sz) {
        if(sz == C){
            long ans = 0;
            for(int i = 0; i<N; i++) {
                StringBuilder str = new StringBuilder();
                long num = 0;
                for(int j = 0 ; j<words[i].length();j++) {
                    str.append(alphabets[words[i].charAt(j) - 'A']);
                }
                num = Long.parseLong(str.toString());
                if(num > 99999999) return;
                ans +=num;
            }
            answer = Math.max(answer,ans);
            return;
        }

        for(int i= 9 ; i >=0; i--) {
            if(numbers[i] ==1) continue;
            alphabets[list.get(sz)- 'A'] = Integer.toString(i);
            numbers[i] = 1;
            dfs(sz+1);
            numbers[i] = 0;
        }
    }

}
