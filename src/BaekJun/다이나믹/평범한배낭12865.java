package BaekJun.다이나믹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 평범한배낭12865 {
    static int N;
    static int K;
    static int[] W;
    static int[] V;
    static int[][] cache;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);
        cache = new int[N+1][K+1];
        W = new int[N+1];
        V = new int[N+1];
        for(int i = 1 ; i <= N ; i++) {
            inputs = br.readLine().split(" ");
            W[i] = Integer.parseInt(inputs[0]);
            V[i] = Integer.parseInt(inputs[1]);
        }

        for(int i = 0 ; i<=N ;i++) Arrays.fill(cache[i], -1);

        int answer = knapSack(1,K);
        System.out.println(answer);
    }

    private static int knapSack(int itemNum, int weight) {
        if(itemNum == N+1 || weight == 0) return 0;

        if(cache[itemNum][weight] != -1) return cache[itemNum][weight];

        if(weight - W[itemNum] >= 0 ) {
            int leftWeight = weight - W[itemNum];
            cache[itemNum][weight] = knapSack(itemNum+1,leftWeight) + V[itemNum];
        }
        cache[itemNum][weight] = Math.max(cache[itemNum][weight], knapSack(itemNum+1,weight));

        return cache[itemNum][weight];
    }
}
