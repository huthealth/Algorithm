package BaekJun.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 퍼즐1525 {
    private static class Board{
        int zY;
        int zX;
        int[][] map;
        int count;
        Board(int y, int x, int[][] m, int c ){
            zY =y;
            zX = x;
            map = m;
            count = c;
        }
    }
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] initMap = new int[3][3];
        int zY = -1;
        int zX = -1;
        int[][] answerMap = {{1,2,3},{4,5,6},{7,8,0}};
        int[] dy = {0,1,-1,0};
        int[] dx = {1,0,0,-1};
        int answer = -1;
        for(int i = 0 ; i<3; i++) {
            String[] inputs = br.readLine().split(" ");
            for(int j = 0 ; j < 3 ;j++) {
                initMap[i][j] = Integer.parseInt(inputs[j]);
                if(initMap[i][j] == 0 ) {
                    zY =i;
                    zX = j;
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        Queue<Board> q = new LinkedList<>();
        q.add(new Board(zY,zX,initMap,0));

        int num = toNum(initMap);

        set.add(num);

        while(!q.isEmpty()){
            Board b = q.poll();
            boolean complete = true;
            for(int i = 0 ; i<3; i++) {
                for(int j = 0; j<3; j++) {
                    if(b.map[i][j] != answerMap[i][j]){
                        complete = false;
                        break;
                    }
                }
                if(!complete) break;
            }

            if(complete){
                answer = b.count;
                break;
            }

            for(int i = 0 ; i< 4; i++) {
                int nextY = b.zY + dy[i];
                int nextX = b.zX + dx[i];
                if(nextY >=0 && nextX >=0 && nextX <3 && nextY <3) {
                    int[][] newMap = new int[3][3];
                    for(int j = 0 ; j< 3; j++){
                        for(int k = 0; k<3; k++){
                            newMap[j][k] = b.map[j][k];
                        }
                    }

                    newMap[nextY][nextX] = b.map[b.zY][b.zX];
                    newMap[b.zY][b.zX] = b.map[nextY][nextX];
                    num = toNum(newMap);
                    if(set.contains(num)) continue;
                    set.add(num);
                    q.offer(new Board(nextY,nextX,newMap,b.count+1));
                }
            }
        }
        System.out.println(answer);
    }

    private static int toNum(int[][] map) {
        int cnt= 9;
        int num = 0;
        for(int i = 0 ; i<3; i++) {
            for(int j = 0; j<3; j++){
                int token = 1;
                for(int c = 1; c<cnt; c++){
                    token *= 10;
                }
                num += token*map[i][j];
                cnt--;
            }
        }
        return num;
    }
}
