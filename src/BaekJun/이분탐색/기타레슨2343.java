/*

lo & hi 초기화에서 문제 발생

hi는 최대길이 * 최대 개수로 초기화해 M이 1인 경우에도 가능하게 해줬지만
lo는 0으로 초기화
이럴 경우  41번째 줄에서 문제 발생
sum + times[i] 가 최대 블루레이 크기(mid) 보다 클 경우
새로운 블루레이를 사용해야하므로 count++ 후
다음 블루레이에 times[i]를 할당하는데 이때 새 블루레이의 크기가 times[i]보다 항상 커야함
=> lo는 최대길이로 초기화해줘야한다.

 */

package BaekJun.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 기타레슨2343 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        inputs = br.readLine().split(" ");


        long[] times = new long[N];

        long hi = 0;
        for(int i = 0 ; i< N; i++) {
            times[i] = Long.parseLong(inputs[i]);
            if(times[i] > hi) hi = times[i];
        }

        long lo = hi;
        hi *= N;

        long minLen = hi;
        long mid = (lo + hi) /2;

        while(lo <= hi) {
            int count = 1;
            long sum = 0;
            for(int i = 0 ; i < N; i++){
                if(sum + times[i] <= mid) {
                    sum += times[i];
                }
                else {
                    sum = times[i];
                    count++;
                }
            }

            if(count <= M) {
                minLen = mid;
                hi = mid -1;
            }
            else {
                lo = mid + 1;
            }
            mid = (lo + hi)/2;
        }

        System.out.println(minLen);
    }
}
