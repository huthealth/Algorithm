package BaekJun.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 용돈관리6236 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int[] moneys =new  int[N];
        long lo = 0;
        for(int i = 0 ; i< N; i++ ){
            moneys[i] = Integer.parseInt(br.readLine());
            if(moneys[i] > lo) lo = moneys[i];
        }
        long hi = lo * N;
        lo = 0;
        long minMoney = hi;
        long mid = (lo + hi) / 2;

        while(lo <= hi) {
            int count = 1;
            long leftMoney = mid;
            for(int i = 0 ; i < N; i++) {
                if(leftMoney - moneys[i] >= 0) {
                    leftMoney -= moneys[i];
                }
                else {
                    count++;
                    leftMoney = mid - moneys[i];
                    /*
                    while(true){
                        count++;
                        leftMoney += mid;
                        if(leftMoney - moneys[i] >= 0) {
                            leftMoney -= moneys[i];
                            break;
                        }
                    }
                     */

                }
            }

            if(count <= M) {
                minMoney = mid;
                hi = mid-1;
            }
            else {
                lo = mid +1;
            }
            mid = (lo + hi) / 2;
        }
        System.out.println(minMoney);
    }
}
