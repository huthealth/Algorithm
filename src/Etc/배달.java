package Etc;//다익스트라

import java.util.*;

public class 배달 {

    private static final Integer INF = Integer.MAX_VALUE;
    private static class Edge {
        Integer to;
        Integer weight;
        Edge(Integer to, Integer weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        Integer[] dist = new Integer[N+1];
        Arrays.fill(dist,INF);
        dist[1] = 0;
        Map<Integer, List<Edge>> edgeMap  = new HashMap<>();
        for(int i = 1;i <= N ; i++) {
            edgeMap.put(i,new ArrayList<>());
        }
        for(int i = 0 ; i< road.length; i++) {
            int v1 = road[i][0];
            int v2 = road[i][1];
            int weight = road[i][2];
            edgeMap.get(v1).add(new Edge(v2,weight));
            edgeMap.get(v2).add(new Edge(v1,weight));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return dist[o1.to].compareTo(dist[o2.to]);
            }
        });

        pq.add( new Edge(1,0));
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(cur.weight > dist[cur.to]) continue;
            for(int i = 0 ; i< edgeMap.get(cur.to).size(); i++) {
                Edge next = edgeMap.get(cur.to).get(i);
                int nextDist = dist[cur.to] + next.weight;
                if(dist[next.to] > nextDist) {
                    dist[next.to] = nextDist;
                    pq.add(new Edge(next.to,dist[next.to]));
                }
            }
        }

        for(int i = 1 ; i <= N ;i++) {
            if(dist[i] <= K) {
                System.out.println(i+ " : "+dist[i]);
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
