package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek13971534 {
    static long cache[] = new long[101];

    static long getLength(int now) {
        if(now <4) return 1;
        if(cache[now] != -1) return cache[now];
        return cache[now] = getLength(now-3)+getLength(now-2);
    }

    public static void main(String... args) throws IOException {
        for(int i =0;i<101;i++) cache[i] = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i =0;i<N;i++){
            int now = Integer.parseInt(br.readLine());
            if(now <4) System.out.println(1);
            else System.out.println(getLength(now));
        }
    }
}
