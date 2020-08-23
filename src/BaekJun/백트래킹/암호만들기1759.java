package BaekJun.백트래킹;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 암호만들기1759 {
    public static int L;
    public static int C;
    public static List<String> answers = new ArrayList<>();
    public static String[] alphabets;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        L = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);
        alphabets = br.readLine().split(" ");
        Arrays.sort(alphabets);
        dfs(0,0,"");

        for(String ans : answers) System.out.println(ans);
    }

    private static void dfs(int now, int count, String pw) {
        if(count == L){
            int aeiou  = countAlphabet1(pw);
            int bcdfg = countAlphabet2(pw);
            //System.out.println(pw + " " + aeiou + " " + bcdfg);

            if(aeiou < 1 || bcdfg < 2) return;
            answers.add(pw);
            //System.out.println(now + " "+count+" "+pw + " "+ answers.size());
            return;
        }

        if(count > L || now == C) return;

        dfs(now+1,count+1,pw+alphabets[now]);
        dfs(now+1,count,pw);

    }

    private static int countAlphabet1(String pw) {
        int count = 0;
        for(int i = 0 ; i< pw.length();i++){
            if(pw.charAt(i) == 'a' || pw.charAt(i) == 'e' || pw.charAt(i) == 'i' || pw.charAt(i) == 'o' || pw.charAt(i) == 'u'){
                count++;
            }
        }
        return count;
    }
    private static int countAlphabet2(String pw) {
        int count = 0;
        for(int i = 0 ; i< pw.length();i++){
            if(pw.charAt(i) != 'a' && pw.charAt(i) != 'e' && pw.charAt(i) != 'i' && pw.charAt(i) != 'o' && pw.charAt(i) != 'u'){
                count++;
            }
        }
        return count;
    }
}
