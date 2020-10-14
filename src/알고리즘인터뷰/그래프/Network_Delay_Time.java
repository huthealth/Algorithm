package 알고리즘인터뷰.그래프;

import netscape.security.UserTarget;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Network_Delay_Time {

   static final int MAX_VAL = 999999;
    public int networkDelayTime(int[][] times, int N, int K) {
        int answer = 0;
        int[][] delayAry = new int[N + 1][N + 1];
        int[] visited = new int[N + 1];
        for (int i = 0; i <= N; i++) Arrays.fill(delayAry[i], MAX_VAL);
        for (int i = 0; i < N; i++) {
            int from = times[i][0];
            int to = times[i][1];
            int t = times[i][2];
            delayAry[from][to] = t;
        }

        int[] ary = new int[N + 1];
        Arrays.fill(ary, MAX_VAL);

        ary[K] = 0;
        PriorityQueue<Point> pq = new PriorityQueue<Point>();
        pq.add(new Point(K, 0));
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            int node = p.x;
            int time = p.y;
            if(visited[node] == 1) continue;
            visited[node] = 1;

            for (int i = 1; i <= N; i++) {
                if(i == K) continue;
                if (ary[i] > time + delayAry[node][i]) {
                    ary[i] = time + delayAry[node][i];
                    pq.add(new Point(i, time + delayAry[node][i]));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (ary[i] == MAX_VAL) return -1;
            answer = Math.max(answer, ary[i]);
        }
        return answer;
    }
}

/*
static class Delay{
    int node;
    int time;
    Delay(int node, int time){
        this.node = node;
        this.time = time;
    }
}

   public int networkDelayTime(int[][] times, int N, int K) {
        int answer = 0;
        List<List<Integer>> adj = new ArrayList<>();
        int[][] delayAry = new int[N+1][N+1];
        int[] visited = new int[N+1];
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i< N; i++){
            int from = times[i][0];
            int to = times[i][1];
            int t = times[i][2];
            delayAry[from][to] = t;
            adj.get(from).add(to);
        }

        int nodeCount = 0;
        Queue<Delay> q = new LinkedList<>();
        q.add(new Delay(K,0));
        while(!q.isEmpty()) {
            Delay now = q.poll();
            nodeCount++;
            answer += now.time;
            visited[now.node] = 1;
            for(int i = 0 ; i < adj.get(now.node).size(); i++) {
                int nextNode = adj.get(now.node).get(i);
                if(visited[nextNode] == 1) continue;
                q.add(new Delay(nextNode, delayAry[now.node][nextNode]));
            }
        }

        if(nodeCount != N) return -1;
        return answer;
    }
*/