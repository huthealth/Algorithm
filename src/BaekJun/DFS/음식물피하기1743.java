package BaekJun.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 음식물피하기1743 {
    static int[][] visited;
    static int[][] map;
    static int foodSize =0;
    static int foodMaxSize = 0;
    static int N;
    static int M;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        int k  = Integer.parseInt(inputs[2]);
        visited = new int[N][M];
        map = new int[N][M];
        for(int i = 0 ; i < k ; i++) {
            inputs = br.readLine().split(" ");
            int y = Integer.parseInt(inputs[0]);
            int x = Integer.parseInt(inputs[1]);
            map[y-1][x-1] = 1;
        }

        for(int i = 0 ; i< N ;i++) {
            for(int j = 0 ; j<M; j++) {
                if(visited[i][j] == 0 && map[i][j] == 1) {
                    visited[i][j] = 1;
                    foodSize  = 1;
                    dfs(i,j);
                    foodMaxSize = Math.max(foodMaxSize,foodSize);
                }
            }
        }
        System.out.println(foodMaxSize);
    }
    public static void dfs(int y,int x) {

        for(int i =0 ;i<4; i++) {
            int nextY = y + dy[i];
            int nextX = x  + dx[i];
            if(nextY >= 0 && nextY < N && nextX >=0 && nextX < M && map[nextY][nextX] == 1 && visited[nextY][nextX] == 0) {
                visited[nextY][nextX]  = 1;
                foodSize++;
                dfs(nextY,nextX);
            }
        }
    }
}
