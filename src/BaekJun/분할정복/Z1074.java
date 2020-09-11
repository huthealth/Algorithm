package BaekJun.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Z1074 {
    static int answer;
    static int cnt = 0;
    static boolean isComplete = false;
    static int R;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        R = Integer.parseInt(inputs[1])+1;
        C = Integer.parseInt(inputs[2])+1;

        int len = (int)Math.pow(2,n);
        dac(1,len,1,len,len);
        System.out.println(answer);
    }

    private static void dac(int rs, int re, int cs, int ce, int len) {
        //if(isComplete) return;
        if(len == 1) {
            if(rs == R && cs == C){
                answer = cnt;
                isComplete = true;
                return;
            }
            cnt++;
            return;
        }

        int nextLen =len/2;
        dac(rs,rs+nextLen-1,cs,cs+nextLen-1,nextLen);
        dac(rs,rs+nextLen-1,cs+nextLen,cs+2*nextLen-1,nextLen);
        dac(rs+nextLen,rs+2*nextLen-1,cs,cs+nextLen-1,nextLen);
        dac(rs+nextLen,rs+2*nextLen-1,cs+nextLen,cs+2*nextLen-1,nextLen);

    }

}
