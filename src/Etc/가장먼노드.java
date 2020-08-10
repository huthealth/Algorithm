package Etc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
dfs -> 시간초과

public class 가장먼노드 {
    public final int INF = 99999999;
    public int[] visited;
    public int[][] graph;
    public int N;
    public int solution(int n, int[][] edge) {
        N = n;
        visited = new int[n];
        graph = new int[n+1][n+1];
        for(int i =0;i<edge.length;i++) graph[edge[i][0]][edge[i][1]] = 1;

        int answer = 0;
        int count =0;

        for(int i =2;i<=n;i++){
            int path = getPath(1,i);
            if(path != INF && path > answer) {
                answer = path;
                count = 1;
            }
            else if(path == answer) {
                count++;
            }
        }
        return count;
    }
    public int getPath(int now, int end){
        if(now == end) return 0;

        int ret = INF;
        for(int nextNode = 2; nextNode<=N;nextNode++){
            if(now ==nextNode) continue;
            if(graph[now][nextNode] == 1 && visited[nextNode] == 0){
                visited[nextNode] = 1;
                ret = Math.min(ret,getPath(nextNode,end)+1);
                visited[nextNode] = 0;
            }
        }
        return ret;
    }
}

 */
// bfs
public class 가장먼노드 {
    public final int INF = 99999999;
    public int[] visited;
    public boolean[][] graph;
    public int N;
    public int solution(int n, int[][] edge) {
        N = n;
        visited = new int[n];
        graph = new boolean[n + 1][n + 1];
        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]][edge[i][1]] = true;
            graph[edge[i][1]][edge[i][0]] = true;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int distance = 1;
        while(!queue.isEmpty()){
            int nowNode = queue.poll();
            for(int nextNode = 2; nextNode <= n; nextNode++){
                if(graph[nowNode][nextNode] && visited[nextNode] == 0) {
                    visited[nextNode] = distance;
                    queue.add(nextNode);
                }
            }
        }

        int answer = 0;
        int count = 0;

        for(int i =2;i<visited.length;i++){
            if(visited[i] > answer) {
                answer = visited[i];
                count = 1;
            }
            else if(visited[i] == answer) count++;
        }
        return count;
    }
}
