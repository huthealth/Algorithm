package BaekJun.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 인구이동16234 {
    static int[][] map;
    static int[][] visited;
    static int[] unionTotal;
    static int[] unionCnt;
    static int[] unionPeople;
    static int N;
    static int L,R;
    static int answer = 0;
    static boolean canMove;
    static int[] dy = {0,0,-1,1};
    static int[] dx ={-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        L = Integer.parseInt(inputs[1]);
        R = Integer.parseInt(inputs[2]);
        map = new int[N][N];
        visited = new int[N][N];
        unionCnt = new int[N*N+1];
        unionTotal = new int[N*N+1];
        unionPeople = new int[N*N+1];

        for(int i = 0 ; i < N ;i++){
            inputs = br.readLine().split(" ");
            for(int j = 0 ; j< N ; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        while(true){
            canMove = false;
            int unionNum = 0;
            for(int i = 0 ; i< N; i++) {
                for(int j = 0 ; j < N ;j++) {
                    if(visited[i][j] == 0 ) {
                        visited[i][j] = ++unionNum;
                        dfs(i,j,unionNum);
                    }
                }
            }
            if(!canMove) break;

            for(int i = 0 ; i< N ; i++) {
                for(int j = 0 ; j <  N ; j++) {
                    if(visited[i][j] == 0) continue;
                    unionCnt[visited[i][j]]++;
                    unionTotal[visited[i][j]] += map[i][j];
                }
            }

            for(int i = 1 ; i<= N*N ; i++) {
                if(unionCnt[i] ==0) continue;
                unionPeople[i] = unionTotal[i] / unionCnt[i];
            }

            for(int i = 0 ; i< N ; i++) {
                for(int j = 0 ; j <  N ; j++) {
                    if(visited[i][j] == 0) continue;
                    map[i][j] = unionPeople[visited[i][j]];
                }
            }

            for(int i = 0 ; i< N ; i++) {
                Arrays.fill(visited[i],0);
            }
            Arrays.fill(unionCnt,0);
            Arrays.fill(unionTotal,0);
            Arrays.fill(unionPeople,0);
            answer++;
        }

        System.out.println(answer);
    }

    private static void dfs(int y, int x, int unionNum) {
        int now = map[y][x];
        for(int i = 0 ; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny <0 || ny >= N  || nx < 0 || nx >= N  || visited[ny][nx] != 0) continue;
            int dif = Math.abs(now - map[ny][nx]);
            if( dif < L ||  dif > R) continue;
            canMove = true;
            visited[ny][nx] = unionNum;
            dfs(ny,nx,unionNum);
        }
    }
}
