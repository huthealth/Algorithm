package BaekJun.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 랜선자르기1654 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int K = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);
        long[] lines = new long[K];


        long lo = 1;
        long hi = 0;

        for(int i = 0 ; i<K;i++) {
            lines[i] = Long.parseLong(br.readLine());
            if(hi < lines[i]) hi = lines[i];
        }

        long mid = (lo+hi) /2;
        long maxLen = 0;

        while(lo <= hi) {
            long sum = 0;
            for(int i = 0 ;i<K; i++) {
                sum += (lines[i]/mid);
            }

            if(sum >= N) {
                maxLen = mid;
                lo = mid+1;
            }
            else {
                hi = mid -1;
            }

            mid = (lo + hi) /2;
        }
        System.out.println(maxLen);

    }
}
