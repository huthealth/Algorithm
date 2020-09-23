package BaekJun.시뮬레이션;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 아기상어16236 {
    private static class Move{
        int time;
        int y;
        int x;
        Move(int time, int y, int x){

            this.time =time;
            this.y =y;
            this.x =x;
        }
    }

    static int babySize = 2;
    static int babyeat = 0;
    static int by;
    static int bx;
    static int helpTime = 0;
    static int N;
    static int[][] map;
    static int[][] visited;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
                if(map[i][j] == 9) {
                    map[i][j] = 0;
                    by = i;
                    bx = j;
                }
            }
        }

        Queue<Move> q = new LinkedList<>();

        while(true){

            boolean found = false;
            for(int i = 0 ; i< N ;i++) Arrays.fill(visited[i],0);
            q.add(new Move(0,by,bx));
            visited[by][bx] =1;

            int minDist = 99999;
            int fy = -1;
            int fx = -1;
            while(!q.isEmpty()){
                Move m = q.poll();
                int y = m.y;
                int x = m.x;
                if(map[y][x] != 0 && map[y][x] < babySize) {
                    if (!found) {
                        found = true;
                        minDist = m.time;
                        fy = y;
                        fx = x;

                    } else {
                        if(minDist > m.time){
                            fy =y;
                            fx =x;
                        }
                        else if(minDist == m.time){
                            if(checkLocation(y,x,fy,fx)){
                                //새로들어온 y,x가 더 위왼이면 바꾸기
                                fy = y;
                                fx = x;
                            }
                        }
                    }
                    //continue;
                }
                for(int i = 0 ; i<4; i++){
                    int ny = m.y + dy[i];
                    int nx = m.x + dx[i];
                    if(ny < 0 || ny >= N ||nx < 0 || nx >= N || visited[ny][nx] ==1 || map[ny][nx] > babySize ) continue;
                    visited[ny][nx] = 1;
                    q.add(new Move(m.time+1,ny,nx));
                }
            }
            if(!found) break;
            helpTime += minDist;
            map[fy][fx] = 0;
            by = fy;
            bx = fx;
            babyeat++;
            if(babyeat == babySize) {
                babySize++;
                babyeat = 0;
            }
        }
        System.out.println(helpTime);

    }

    private static boolean checkLocation(int y, int x, int fy, int fx) {
        if(y < fy) return true;
        if( y == fy && x < fx) return true;
        return false;
    }

}
