package BaekJun;

import com.sun.javafx.collections.ElementObservableListDecorator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back1753 {
    private static final int INF = Integer.MAX_VALUE;

    private static class Edge {
        private Integer to;
        private Integer cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int V = Integer.parseInt(token[0]);
        int E = Integer.parseInt(token[1]);
        int K = Integer.parseInt(br.readLine());
        Map<Integer, List<Edge>> initEdgeMap = new HashMap<>();
        boolean[] visited = new boolean[V + 1];
        Integer[] dist = new Integer[V + 1];
        for (int i = 1; i <= V; i++) {
            dist[i] = INF;
        }
        for (int i = 1; i <= V; i++) {
            visited[i] = false;
        }
        dist[K] = 0;
        for (int i = 0; i < E; i++) {
            token = br.readLine().split(" ");
            int from = Integer.parseInt(token[0]);
            int to = Integer.parseInt(token[1]);
            int cost = Integer.parseInt(token[2]);
            if (!initEdgeMap.containsKey(from)) initEdgeMap.put(from, new ArrayList<>());
            initEdgeMap.get(from).add(new Edge(to, cost));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost.compareTo(o2.cost);
            }
        });

        pq.add(new Edge(K, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.cost > dist[cur.to]) continue;

            if (!initEdgeMap.containsKey(cur.to)) continue;
            for (Edge next : initEdgeMap.get(cur.to)) {
                int nextDist = dist[cur.to] + next.cost;
                if (nextDist < dist[next.to]) {
                    dist[next.to] = nextDist;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}