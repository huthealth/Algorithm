package BaekJun.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳1987 {
    static boolean[] alphabet = new boolean[27];
    static char[][] map;
    static int[][] visited;
    static int N;
    static int M;
    static int maxCount = 0;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        map = new char[N][M];
        visited = new int[N][M];
        for(int i = 0 ; i < N; i++) {
            String str = br.readLine();
            for(int j = 0 ; j< M ; j++) {
                map[i][j] = str.charAt(j);
            }
        }


        visited[0][0] = 1;
        alphabet[map[0][0] - 'A'] = true;
        dfs(0,0,1);
        System.out.println(maxCount);
    }

    private static void dfs(int y, int x, int count) {
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M && visited[nextY][nextX] == 0 && !alphabet[map[nextY][nextX] - 'A']) {
                visited[nextY][nextX] = 1;
                alphabet[map[nextY][nextX] - 'A'] = true;
                dfs(nextY, nextX, count + 1);
                visited[nextY][nextX] = 0;
                alphabet[map[nextY][nextX] - 'A'] = false;
            }
        }
    }

}
