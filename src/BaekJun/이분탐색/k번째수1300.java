package BaekJun.이분탐색;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class k번째수1300 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long lo = 1;
        long hi = (long)N*N;
        long mid = (lo + hi) / 2;
        long kNum = 0;
        while(lo <= hi) {
            long count = 0;
            for(int i = 1 ; i<= N ; i++) {
                count += Math.min(mid/i,N);
            }
            if(count >= K) {
                kNum = mid;
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
            mid = (lo + hi) /2;
        }
        System.out.println(kNum);
    }
}
