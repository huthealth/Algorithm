package BaekJun.다이나믹;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장큰증가부분11055 {
    private static int[] cache;
    private static int[] numbers;
    private static int N;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        cache = new int[N];
        numbers = new int[N];

        Arrays.fill(cache,-1);
        for(int i = 0 ; i< N ; i++){
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        int answer = 0;
        for(int i = 0 ; i< N; i++){
            answer = Math.max(answer, findMaxSum(i));
        }
        System.out.println(answer);
    }

    private static int findMaxSum(int now) {
        if(cache[now] != -1) return cache[now];

        cache[now] = 0;

        for(int next = now+1; next < N; next++) {
            if(numbers[now] < numbers[next]) {
                cache[now] = Math.max(cache[now], findMaxSum(next));
            }
        }

        cache[now] += numbers[now];
        return cache[now];
    }

}
