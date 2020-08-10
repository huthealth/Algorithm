package BaekJun.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 줄세우기2252 {
    private static int[] visited;
    private static List<List<Integer>> adj;
    private static List<Integer> order = new ArrayList<>();
    private static int N;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);
        adj = new ArrayList<>(N+1);
        for(int i = 0; i <= N ; i++) {
            adj.add(new ArrayList<>());
        }
        visited = new int[N+1];
        for(int i = 0 ; i < M; i++) {
            tokens = br.readLine().split(" ");
            int student1 = Integer.parseInt(tokens[0]);
            int student2 = Integer.parseInt(tokens[1]);
            adj.get(student1).add(student2);
        }

        tSort();
        for(Integer student : order) System.out.print(student + " ");

    }

    private static void tSort() {
        for(int i = 1 ; i <= N; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                dfs(i);
            }
        }
    }

    private static void dfs(int here) {
        for(int i = 0; i < adj.get(here).size(); i++) {
            int next = adj.get(here).get(i);
            if(visited[next] == 0) {
                visited[next] = 1;
                dfs(next);
            }
        }
        order.add(0,here);
    }
}
