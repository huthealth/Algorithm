package BaekJun.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연결요소의개수11724 {
    private static int[] visited;
    private static int[][] graph;
    private static int N;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        visited = new int[N+1];
        graph = new int[N+1][N+1];
        for(int i = 0 ; i< M; i++ ) {
            inputs = br.readLine().split(" ");
            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        int answer = 0;

        for(int i = 1 ; i<= N ;i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int now){
        visited[now] = 1;
        for(int i=1; i<= N ;i++){
            if(visited[i] == 0 && graph[now][i] == 1) {
                visited[i] = 1;
                dfs(i);
            }
        }

    }
}
