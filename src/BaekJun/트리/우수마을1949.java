package BaekJun.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
시간복잡도가 O(2^N) 이라고 생각했는데(마을당 2번씩 방문) 동적계획법을 사용해
O(N)으로 풀 수 있다.
ex) 피보나찌 수열
 */
public class 우수마을1949 {
    static int[] villages;
    static int[] visited;
    static long[][] cache;
    static List<List<Integer>> list = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        villages = new int[N+1];
        visited = new int[N+1];
        String[] inputs = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++) {
            villages[i+1] = Integer.parseInt( inputs[i] );
        }

        for(int i  = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i< N-1; i++) {
            inputs = br.readLine().split(" ");
            int v1 = Integer.parseInt(inputs[0]);
            int v2 = Integer.parseInt(inputs[1]);
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        cache = new long[2][N+1];

        for(int i = 0 ; i<2; i++) Arrays.fill(cache[i],-1);
        visited[1] = 1;
        long ans1 = getMaxPeople(1,1);
        System.out.println();
        Arrays.fill(visited,0);
        visited[1]= 1;
       // for(int i = 0 ; i<2; i++) Arrays.fill(cache[i],-1);
        long ans2 = getMaxPeople(1,0);
        System.out.println();

        System.out.println(Math.max(ans1,ans2));

    }

    private static long getMaxPeople(int now, int check) {
        if(cache[check][now] != -1) return cache[check][now];

        cache[check][now] = 0;

        for(int i = 0 ; i< list.get(now).size(); i++) {
            long temp = 0;
            if(visited[list.get(now).get(i)] == 1) continue;
            visited[list.get(now).get(i)] = 1;
            temp +=getMaxPeople(list.get(now).get(i),0);
            if(check == 0) {
                temp = Math.max(temp, getMaxPeople(list.get(now).get(i), 1));
            }
            visited[list.get(now).get(i)] = 0;
            cache[check][now]  += temp;
        }

        if(check == 1) cache[check][now] += villages[now];
        return cache[check][now];
    }

}
