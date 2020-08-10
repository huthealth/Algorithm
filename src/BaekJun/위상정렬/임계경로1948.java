package BaekJun.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
// dfs

public class 임계경로1948 {
    private static class Edge {
        Integer v;
        Integer cost;
        public Edge(Integer v, Integer cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    private static List<List<Edge>> adj;
    private static List<List<Edge>> visitedEdge;
    private static int[] cache;
    private static int start;
    private static int dest;
    private static int N;
    private static int M;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adj = new ArrayList<>(N+1);
        visitedEdge = new ArrayList<>(N+1);
        for(int i = 0 ; i <= N; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i <= N; i++) visitedEdge.add(new ArrayList<>());
        cache = new int[N+1];

        for(int i = 0 ; i < M; i++) {
            String[] inputs = br.readLine().split(" ");
            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            int time = Integer.parseInt(inputs[2]);
            adj.get(from).add(new Edge(to,time));
            visitedEdge.get(from).add(new Edge(to,-1));
        }
        String[] inputs = br.readLine().split(" ");
        start = Integer.parseInt(inputs[0]);
        dest =  Integer.parseInt(inputs[1]);

        int maxTime = dfs(start);
        int roads = dfs2(start,0,maxTime);
        System.out.println(maxTime);
        System.out.println(roads);
    }

    private static int dfs2(int here, int cost, int maxTime) {
        if(here == dest ) return 0;
        int ret = 0;
        for(int i = 0 ; i < adj.get(here).size(); i++) {
            Edge e1 = adj.get(here).get(i);
            Edge e2 = visitedEdge.get(here).get(i);
            int next = e1.v;
            int time = e1.cost;
            int visited = e2.cost;
            if(visited == -1 && time + cache[next] == cache[here]) {
                e2.cost = 0;
                ret += dfs2(next,0, maxTime) + 1;
            }
        }
        return ret;
    }

    private static int dfs(int here) {
        if(here == dest) return 0;
        if(cache[here] != 0 ) return cache[here];

        for(Edge edge : adj.get(here)) {
            int cost = edge.cost;
            int next = edge.v;
            cache[here] = Math.max(cache[here], dfs(next)+cost);
        }
        return cache[here];
    }
}
