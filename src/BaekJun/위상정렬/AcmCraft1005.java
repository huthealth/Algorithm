//dp로 품

package BaekJun.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AcmCraft1005 {
    private static int[][] adj;
    private static int[] visited;
    private static int N;
    private static int[] buildTime;
    private static int[] cache;
    //private static int answer = 0;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        for (int cc = 0; cc < c; cc++) {
            String[] tokens = br.readLine().split(" ");
            N = Integer.parseInt(tokens[0]);
            int k = Integer.parseInt(tokens[1]);
            adj = new int[N + 1][N + 1];
            visited = new int[N + 1];
            buildTime = new int[N + 1];
            cache = new int[N+1];
            Arrays.fill(cache,-1);
            tokens = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {
                buildTime[i] = Integer.parseInt(tokens[i - 1]);
            }
            for (int i = 0; i < k; i++) {
                tokens = br.readLine().split(" ");
                int a = Integer.parseInt(tokens[0]);
                int b = Integer.parseInt(tokens[1]);
                adj[a][b] = 1;
            }
            int dest = Integer.parseInt(br.readLine());
            //int answer = buildTime[dest];
            int answer = dfs(dest);
            System.out.println(answer);
        }
    }

    private static int dfs(int here) {
        int maxTime = 0;
        if(cache[here] != -1 ) return cache[here];
        cache[here] = 0;
        for(int next = 1; next <= N ;next++) {
            if(adj[next][here] == 1 && visited[next] == 0) {
                //visited[next] = 1;
                cache[here] = Math.max( cache[here],dfs(next));
            }
        }
        cache[here] += buildTime[here];

        return  cache[here];
    }

}
