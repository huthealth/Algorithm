package BaekJun.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 탈출3055 {
    static class Fire {
        int y;
        int x;
        int time;

        Fire(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    static class Move {
        int y;
        int x;
        int fire;
        int time;

        Move(int y, int x, int fire, int time) {
            this.y = y;
            this.x = x;
            this.fire = fire;
            this.time = time;
        }
    }

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] map;
    static int N;
    static int M;
    static int escape;
    static int[][] visited;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        escape = -1;
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        visited = new int[N][M];
        map = new int[N][M];
        Queue<Move> queue = new LinkedList<>();
        Queue<Fire> fireQueue = new LinkedList<>();
        int startY = 0;
        int startX = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'S') {
                    startY = i;
                    startX = j;
                } else if (str.charAt(j) == 'X') map[i][j] = -1; //벽
                else if (str.charAt(j) == '*') {
                    fireQueue.offer(new Fire(i, j, 0));
                    map[i][j] = 4; //불
                }
                else if(str.charAt(j) == 'D') {
                    map[i][j] = 999999999;
                }
            }
        }
        while (!fireQueue.isEmpty()) {
            Fire fire = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = fire.y + dy[i];
                int nextX = fire.x + dx[i];
                if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M && map[nextY][nextX] == 0) {
                    map[nextY][nextX] = fire.time + 1 + 4;
                    fireQueue.offer(new Fire(nextY, nextX, fire.time + 1));
                }

            }
        }

        visited[startY][startX] = 1;
        queue.offer(new Move(startY, startX, 4, 0));
        while (!queue.isEmpty()) {
            boolean complete = false;
            Move m = queue.poll();
            int nowY = m.y;
            int nowX = m.x;
            int time = m.time;
            int fire = m.fire;


            for (int i = 0; i < 4; i++) {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && map[nextY][nextX] == 999999999 ) {
                    escape = time +1;
                    complete = true;
                    break;
                }


                    if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && visited[nextY][nextX] == 0) {
                    if (map[nextY][nextX] != -1 && (map[nextY][nextX] == 0 || map[nextY][nextX] > fire + 1)) {
                        visited[nextY][nextX] = 1;
                        queue.offer(new Move(nextY, nextX, fire + 1, time + 1));
                    }
                }
            }
            if (complete) break;
        }
        if (escape == -1) System.out.println("KAKTUS");
        else System.out.println(escape);
    }
}






