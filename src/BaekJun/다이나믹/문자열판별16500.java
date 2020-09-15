package BaekJun.다이나믹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 문자열판별16500 {
    private static String sentence;
    private static String[] words;
    private static int[] cache;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sentence = br.readLine();
        int n = Integer.parseInt(br.readLine());
        words = new String[n];
        cache = new int[sentence.length()];
        for(int i = 0 ; i< n; i++){
            words[i] = br.readLine();
        }

        Arrays.fill(cache,-1);
        System.out.println(makeSentence(0));
    }

    private static int makeSentence(int index) {
        if(index == sentence.length()) {
            return 1;
        }
        if(cache[index] != -1) {
            return cache[index];
        }

        cache[index] = 0;

        for(int i = 0 ; i < words.length; i++) {
            if(index + words[i].length() > sentence.length()) continue;

            boolean isMatch = true;

            for(int j = 0 ; j < words[i].length() ; j++) {
                if(sentence.charAt(index+j) != words[i].charAt(j)) {
                    isMatch = false;
                    break;
                }
            }

            if(isMatch) {
                cache[index] |= makeSentence(index + words[i].length());
            }
        }

        return cache[index];
    }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class test {
    static String S;
    static String[] words;
    static int[][] cache;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        int N = Integer.parseInt( br.readLine() );
        Set<String> set = new HashSet<>();
        /*
        for(int i = 0 ; i< N ; i++) {
            set.add(br.readLine());
        }
        words = new String[set.size()];
        int cnt = 0;
        for(String str : set) {
            words[cnt] = str;
            cnt++;
        }


        words = new String[N];
                for(int i = 0 ; i < N ; i++) {
        words[i] = br.readLine();
        }
        cache = new int[S.length()][words.length];
        for(int i = 0 ; i < words.length; i++) {
        dp(0,i);
        }
        System.out.println(answer);
        }

private static void dp(int start  , int index) {
        if(answer == 1 ) return;
        if(start == S.length()) {
        answer = 1;
        return;
        }

        //if(cache[start][index] != 0) return;
        //cache[start][index] = 1;

        if(words[index].length() > S.length() - start ) return;
        for(int i = start; i < start + words[index].length(); i++) {
        if( S.charAt(i) != words[index].charAt(i-start)) return;
        }

        for(int i =0  ; i< words.length; i++) {
        if(answer == 1) return;
        dp(start + words[index].length(), i);
        }
        }

        }
 */