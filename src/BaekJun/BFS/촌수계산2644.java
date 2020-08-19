package BaekJun.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 촌수계산2644 {
    private static class Entity{
        int num;
        int count;
        public Entity(int n , int c) {
            num = n;
            count = c;
        }
    }
    private static int[] visited;
    private static int[][] map;
    private static int N;
    private static int K;
    private static int  from;
    private static int  to;
    private static int dif = -1;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        from = Integer.parseInt(inputs[0]);
        to = Integer.parseInt(inputs[1]);
        K = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new int[N+1];
        for(int i = 0; i< K ;i++) {
            inputs = br.readLine().split(" ");
            int parent = Integer.parseInt(inputs[0]);
            int child = Integer.parseInt(inputs[1]);
            map[parent][child] = 1;
            map[child][parent] = 1;
        }

        Queue<Entity> queue = new LinkedList<>();
        visited[from] = 1;
        queue.offer((new Entity(from,0)));
        while(!queue.isEmpty()) {
            Entity e = queue.poll();
            int person = e.num;
            int now = e.count;
            if(person == to) {
                dif = now;
                break;
            }

            int next = now +1 ;
            for(int i = 1; i<= N ;i++) {
                if(visited[i] == 0 && map[person][i] == 1) {
                    visited[i] = 1;
                    queue.add(new Entity(i,next));
                }
            }
        }
        System.out.println(dif);
    }
}
