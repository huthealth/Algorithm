package BaekJun.투포인터_슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분합1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);
        int[] ary = new int[N];
        inputs = br.readLine().split(" ");
        for(int i = 0; i<N; i++) ary[i] = Integer.parseInt(inputs[i]);
        int total = 0;
        int minLen = Integer.MAX_VALUE;
        int lo = 0;
        int hi = 0;

        while(true) {
            if(total < S) {
                if(hi == N) break;
                total += ary[hi++];
            }
            else {
                //if(lo == N) break;
                minLen = Math.min(minLen,hi-lo);
                total -= ary[lo++];
            }
        }
        if(minLen == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(minLen);
    }
}
