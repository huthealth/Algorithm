package Etc;

import java.io.*;

public class T1 {
    static String[] hex = {"a","b","c","d","e","f"};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String answer = "";
        for(int i =0;i<input.length();i+=16) {
            String token = input.substring(i,i+16);
            for(int j  = 0;j< token.length();j+=4) {
                String num = token.substring(j,j+4);
                String ans = to16Num(num);
                answer += ans;
            }
            answer += ":";
        }
        answer = answer.substring(0,answer.length()-1);
        System.out.println(answer);
    }
    static String to16Num(String strNum) {
        int num = 0;
        for(int i = 3;i>=0;i--) {
            if(strNum.charAt(i) == '0') continue;
            num += Math.pow(2,3-i);
        }
        if(num >= 10) return hex[num -10];
        return Integer.toString(num);
    }
}
