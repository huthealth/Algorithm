package BaekJun.투포인터_슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        int[] coins = new int[N+1];
        int[][] dp = new int[N+1][K+1];
        for(int i = 1 ; i<= N ;i++) coins[i] = Integer.parseInt(br.readLine());

        dp[0][0] = 1;
        for(int i = 1; i<= N; i++) {
            for(int j = 0; j<= K ;j++) {
                if(j == 0) dp[i][j] = 1;
                else if(coins[i] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i][j-coins[i]] + dp[i-1][j];
            }
        }
        System.out.println(dp[N][K]);
    }
}
