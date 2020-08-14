/*
자른 후 남은 나무 길이들의 합인 sum은 최대값이 int로는 오버플로우 날 수 있으므로
long형을 사용해야한다.
 */
package BaekJun.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 나무자르기2805 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
         inputs = br.readLine().split(" ");
        int[] trees = new int[N];
        int lo = 0;
        int hi = 0;
        int maxTreeLen = 0;
        for(int i = 0 ; i< N; i++){
            trees[i] = Integer.parseInt(inputs[i]);
            if(trees[i] > hi) hi = trees[i];
        }

        int mid = (lo+hi)/2;

        while(lo <= hi) {
            long sum = 0;
            for(int i = 0 ; i< N; i++){
                int len = trees[i] - mid;
                if(len > 0) sum += len;
            }

            if(sum >= M) {
                maxTreeLen = mid;
                lo = mid + 1 ;
            }
            else {
                hi = mid - 1;
            }
            mid = (hi + lo) / 2;
        }

        System.out.println(maxTreeLen);
    }

}
