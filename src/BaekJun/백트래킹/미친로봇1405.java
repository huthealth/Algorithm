package BaekJun.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 미친로봇1405 {
    private static int N;
    private static double[] EWSN = new double[4];
    private static int[] dy = {0,0,1,-1};
    private static int[] dx = {1,-1,0,-0};
    private static int[][] visited = new int[29][29];
    private static double answer = 0.0;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        for(int i = 1 ; i<= 4; i++) {
            EWSN[i-1] = Double.parseDouble(inputs[i]) / 100;
        }


        visited[14][14] = 1;
        dfs(14,14,0,1);
        System.out.format("%.9f",answer);
    }

    private static void dfs(int y, int x, int move, double percent) {
       // System.out.println(y + " " + x+" " + move);
        if(move == N) {
            answer += percent;
            return;
        }

        for(int i = 0; i< 4; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];
            if (nY < 0 || nX < 0 || nY >= 29 || nX >= 29 || visited[nY][nX] == 1) continue;
            visited[nY][nX] = 1;
            dfs(nY, nX, move + 1, percent * EWSN[i]);
            visited[nY][nX] = 0;
        }


    }
}
