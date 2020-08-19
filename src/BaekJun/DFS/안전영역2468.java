package BaekJun.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 안전영역2468 {
    static int maxCountOfArea = 0;
    static int countOfArea = 0;
    static int[][] map;
    static int[][] visited;
    static int N;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new int[N][N];

        for(int i = 0 ; i<N;i++){
            String[] inputs = br.readLine().split(" ");
            for(int j = 0; j<N;j++){
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for(int rain = 0; rain <= 100; rain++){
            countOfArea = 0;
            for(int i = 0 ; i < N; i++) Arrays.fill(visited[i],0);

            for(int i = 0 ; i< N; i++) {
                for(int j = 0 ; j< N ;j++){
                    if(map[i][j] <= rain && visited[i][j] == 0) {
                        visited[i][j] = 1;
                        dfs(i,j,rain);
                    }
                }
            }

            for(int i = 0 ; i< N; i++) {
                for(int j = 0 ; j< N ;j++){
                    if( visited[i][j] == 0) {
                        visited[i][j] = 1;
                        countOfArea++;
                        dfs2(i,j);
                    }
                }
            }

            maxCountOfArea = Math.max(maxCountOfArea,countOfArea);
        }
        System.out.println(maxCountOfArea);
    }

    private static void dfs(int y, int x, int rain) {
        for(int i = 0; i< 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(nextX >= 0 && nextX < N  && nextY >=0 && nextY < N && visited[nextY][nextX] ==0 && map[nextY][nextX] <= rain) {
                visited[nextY][nextX] = 1;
                dfs(nextY,nextX,rain);
            }
        }
    }

    private static void dfs2(int y, int x) {
        for(int i = 0; i< 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(nextX >= 0 && nextX < N  && nextY >=0 && nextY < N && visited[nextY][nextX] == 0) {
                visited[nextY][nextX] = 1;
                dfs2(nextY,nextX);
            }
        }
    }
}
