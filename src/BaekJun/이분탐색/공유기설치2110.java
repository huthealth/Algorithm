package BaekJun.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공유기설치2110 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int C = Integer.parseInt(inputs[1]);

        int[] houses = new int[N];
        for(int i = 0 ; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);
       // int hi = houses[N-1] - houses[0];
       // int lo  = hi;

       // for(int i = 1 ; i < N ;i++) {
        //    if(houses[i] - houses[i-1] < lo) lo = houses[i] - houses[i-1];
       // }
        int maxLen = 0;
        int lo  = 1;
        int hi = 1000000000;
        int mid = (lo + hi) / 2;

        while(lo <= hi) {
            int count = 1;
            int nowPos = houses[0];
            //int minLen = Integer.MAX_VALUE;
            for(int i = 1; i < N; i++) {
                if(houses[i] - nowPos < mid) continue;
                nowPos = houses[i];
                count++;
            }
            /*
            if(houses[N-1] - nowPos >= mid) {
                count++;
            }

             */

            if(count >= C) {
                maxLen = mid;
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }

            mid = (lo + hi) / 2;

        }
        System.out.println(maxLen);
    }
}
