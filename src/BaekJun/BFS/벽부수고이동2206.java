package BaekJun.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 벽부수고이동2206 {
    private static class Move{
        int y;
        int x;
        int time;
        int smash;
        Move(int y, int x, int time, int smash) {
            this.y = y;
            this.x = x;
            this.time = time;
            this.smash = smash;
        }
    }

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int[][] map = new int[N][M];
        int[][][] visited = new int[2][N][M];
        int[] dy = {0,1,0,-1};
        int[] dx = {1,0,-1,0};
        for(int i = 0 ; i <N; i++) {
            String str = br.readLine();
            for(int j = 0; j< M ;j++) {
                if (str.charAt(j) == '1') map[i][j] = 1;
            }
        }

        int answer = -1;
        visited[0][0][0] = 1;
        Queue<Move> q = new LinkedList<>();
        q.add(new Move(0,0,1,0));
        while(!q.isEmpty()) {
            Move m = q.poll();
            if (m.y == N - 1 && m.x == M - 1) {
                answer = m.time;
                break;
            }
            int smash = m.smash;

            for (int i = 0; i < 4; i++) {
                int nextY = m.y + dy[i];
                int nextX = m.x + dx[i];
                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                    if (smash == 0) {
                        if (map[nextY][nextX] == 0 && visited[0][nextY][nextX] == 0) {
                            visited[0][nextY][nextX] = 1;
                            q.add(new Move(nextY, nextX, m.time + 1, 0));
                        } else if (map[nextY][nextX] == 1 && visited[1][nextY][nextX] == 0) {
                            visited[1][nextY][nextX] = 1;
                            q.add(new Move(nextY, nextX, m.time + 1, 1));
                        }
                    } else {
                        if (visited[1][nextY][nextX] == 0 && map[nextY][nextX] == 0) {
                            visited[1][nextY][nextX] = 1;
                            q.add(new Move(nextY, nextX, m.time + 1, 1));
                        }

                    }
                }
            }
        }
        System.out.println(answer);
    }
}
