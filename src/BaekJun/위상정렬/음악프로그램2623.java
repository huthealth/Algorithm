package BaekJun.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 음악프로그램2623 {
    private static int[][] adj;
    private static int[] visited;
    private static int N;
    private static List<Integer> order = new ArrayList<>();

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        adj = new int[N+1][N+1];
        visited = new int[N+1];
        for(int i = 0 ; i < M; i++) {
            inputs = br.readLine().split(" ");
            for(int j = 1; j< inputs.length-1;j++){
                int from = Integer.parseInt(inputs[j]);
                int to = Integer.parseInt(inputs[j+1]);
                adj[from][to] = 1;
            }
        }
        order = tsort();
        for(Integer i : order) System.out.println(i);
    }

    private static List<Integer> tsort() {
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                dfs(i);
            }
        }

        if (order.size() != N) {
            List<Integer> cycleOrder = new ArrayList<>();
            cycleOrder.add(0);
            return cycleOrder;
        }

        for (int i = 1; i < order.size(); i++) {
            for(int j = i-1; j>=0; j--) {
                if(adj[order.get(i)][order.get(j)] == 1){
                    List<Integer> cycleOrder = new ArrayList<>();
                    cycleOrder.add(0);
                    return cycleOrder;
                }
            }
        }

        return order;
    }

    private static void dfs(int here) {
        for(int next = 1; next <= N ; next++) {
            if(adj[here][next] == 0 || visited[next] == 1) continue;
            visited[next] = 1;
            dfs(next);
        }
        order.add(0,here);
    }

}
