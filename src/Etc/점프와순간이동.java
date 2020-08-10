package Etc;

import java.util.LinkedList;
import java.util.Queue;

public class 점프와순간이동 {
    private static class Location {
        int now;
        int jump;
        Location(int n, int j) {
            now = n;
            jump = j;
        }
    }
    static final int INF = Integer.MAX_VALUE;
    public int solution(int n) {
        int ans = INF;
        //int[] cache = new int[n+1];
        int[] visited = new int[n+1];
        //Arrays.fill(cache,INF);

        Queue<Location> queue = new LinkedList<>();

        queue.add(new Location(1,1));
        while(!queue.isEmpty()) {
            Location cur = queue.poll();
            System.out.println("현재 위치 : "+ cur.now);
            System.out.println("점프 횟수 : "+ cur.jump);
            if(cur.now == n && cur.jump < ans) {
                ans = cur.jump;
                continue;
            }
            if(cur.now > n || visited[cur.now] == 1) continue;
            visited[cur.now] = 1;
            queue.add(new Location(cur.now*2,cur.jump));
            queue.add(new Location(cur.now + 1, cur.jump + 1));
        }
        return ans;
    }
    public static void main(String... args) {
        점프와순간이동 j = new 점프와순간이동();
        j.solution(5);
    }
}

