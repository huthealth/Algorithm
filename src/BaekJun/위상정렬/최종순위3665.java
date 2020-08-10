package BaekJun.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 최종순위3665 {
    private static int[][] adj;
    private static List<Integer> order;
    private static int[] rank;
    private static int[] visited;
    private static int N;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<C ; i++) {
            N = Integer.parseInt(br.readLine());
            rank = new int[N];
            visited = new int[N+1];
            adj = new int[N+1][N+1];
            order = new ArrayList<>();
            String[] inputs = br.readLine().split(" ");
            for(int j = 0; j< N ;j++) {
                rank[j] = Integer.parseInt(inputs[j]);
            }

            for(int j = 0 ; j < N-1; j++) {
                for (int k = j+1; k<N; k++ ) {
                    adj[rank[j]][rank[k]] = 1;
                }
            }

            int M = Integer.parseInt(br.readLine());
            for(int j = 0; j< M; j++) {
                inputs = br.readLine().split(" ");
                int team1 = Integer.parseInt(inputs[0]);
                int team2 = Integer.parseInt(inputs[1]);
                if(adj[team1][team2] == 1) {
                    adj[team1][team2] = 0;
                    adj[team2][team1] = 1;
                }
                else {
                    adj[team1][team2] = 1;
                    adj[team2][team1] = 0;
                }
            }

            order = tsort();
            if(order == null) System.out.println("IMPOSSIBLE");
            else {
                for(Integer team : order) System.out.print(team+" ");
            }
            System.out.println();
        }
    }

    private static List<Integer> tsort() {
        for(int i = 1; i<= N; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                dfs(i);
            }
        }

        for (int i = 1; i < order.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (adj[order.get(i)][order.get(j)] == 1) {
                    return null;
                }
            }
        }
        return order;
    }

    private static void dfs(int here) {
        for(int next = 1; next <= N; next++) {
            if(adj[here][next]==1 && visited[next] == 0) {
                visited[next] = 1;
                dfs(next);
            }
        }
        order.add(0,here);
    }
}
