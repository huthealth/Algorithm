package BaekJun.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 게임개발1516 {
    private static class Building{
        int index;
        Integer time;
        public Building(int i , Integer t) {
            index = i;
            time = t;
        }

    }
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n+1];
        int[] time = new int[n+1];
        int[] inDegree = new int[n+1];
        int[] visited = new int[n+1];
        List<List<Integer>> adj = new ArrayList<>(n+1);
        for(int i = 0; i <=n;i++) adj.add(new ArrayList<>());
        for(int i =1; i <= n; i++) {
            String[] inputs = br.readLine().split(" ");
            time[i] = Integer.parseInt( inputs[0] );
            for(int j = 1; j< inputs.length-1 ; j++) {
                int node = Integer.parseInt(inputs[j]);
                adj.get(node).add(i);
                inDegree[i]++;
            }
        }

        PriorityQueue<Building> pq = new PriorityQueue<>(new Comparator<Building>() {
            @Override
            public int compare(Building o1, Building o2) {
                return o1.time.compareTo(o2.time);
            }
        });

        for(int i = 1; i <= n ; i++) {
            if(inDegree[i] == 0) pq.offer(new Building(i,time[i]));
        }
        while(!pq.isEmpty()) {
            Building now = pq.poll();
            if(visited[now.index] == 0) {
                answer[now.index] = now.time;
                visited[now.index] = 1;
                for(Integer next : adj.get(now.index)) {
                    inDegree[next]--;
                    if(inDegree[next] == 0) {
                        pq.add(new Building(next, now.time + time[next]));
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++) System.out.println(answer[i]);


    }
}
