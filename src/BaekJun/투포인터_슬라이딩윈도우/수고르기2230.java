package BaekJun.투포인터_슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수고르기2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int[] ary = new int[N];
        for(int i = 0 ; i< N; i++) ary[i] = Integer.parseInt(br.readLine());
        Arrays.sort(ary);
        long minDif = Long.MAX_VALUE;
        int lo = 0;
        int hi = 0;
        long dif = 0;
        while(true) {
            if(hi == N || lo == N) break;
            dif = ary[hi] - ary[lo];
            if(dif <M) {
                hi++;
            }
            else {
                minDif = Math.min(minDif,dif);
                lo++;
            }
        }
        System.out.println(minDif);
    }
}
