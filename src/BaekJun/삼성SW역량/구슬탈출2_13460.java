package BaekJun.삼성SW역량;

import sun.swing.StringUIClientPropertyKey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구슬탈출2_13460 {
    static int N;
    static int M;
    //static char[][] tempMap;
    static int minCount = Integer.MAX_VALUE;
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int UP = 2;
    static final int DOWN = 3;
    static int ansY;
    static int ansX;
    static boolean foundRed = false;
    static boolean foundBlue = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        //tempMap = new char[N][M];
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);
                if (map[i][j] == 'O') {
                    ansY = i;
                    ansX = j;
                    map[i][j] = '.';
                }
            }
        }

        bubbleGame(map, 0,-1);
        if (minCount == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minCount);

    }

    private static void bubbleGame(char[][] map, int count, int before) {
        if( count > 10 || count > minCount)return;
        /*System.out.println();
        for(int i = 0 ; i < N; i++) {
            for(int j = 0 ; j <M ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();*/
        if(foundRed && !foundBlue) {
            minCount = count;
            return;
        }
        if(foundBlue) {
            return;
        }
        char[][] tempMap = new char[N][M];
       for(int i = 0 ; i< N; i++) {
            for(int j = 0 ; j < M ; j++){
                tempMap[i][j] = map[i][j];
            }
        }
       foundBlue = false;
       foundRed = false;
        if(before != RIGHT){
            if(moveBubble(tempMap,LEFT))
         bubbleGame(tempMap,count+1,LEFT);
        }

        for(int i = 0 ; i< N; i++) {
            for(int j = 0 ; j < M ; j++){
                tempMap[i][j] = map[i][j];
            }
        }foundBlue = false;
        foundRed = false;
        if(before != LEFT) {
            if (moveBubble(tempMap, RIGHT)) bubbleGame(tempMap, count + 1,RIGHT);
        }
        for(int i = 0 ; i< N; i++) {
            for(int j = 0 ; j < M ; j++){
                tempMap[i][j] = map[i][j];
            }
        }foundBlue = false;
        foundRed = false;
        if(before != DOWN) {
            if (moveBubble(tempMap, UP)) bubbleGame(tempMap, count + 1,UP);
        }
        for(int i = 0 ; i< N; i++) {
            for(int j = 0 ; j < M ; j++){
                tempMap[i][j] = map[i][j];
            }
        }foundBlue = false;
        foundRed = false;
        if(before != UP) {
            if (moveBubble(tempMap, DOWN)) bubbleGame(tempMap, count + 1,DOWN);
        }
    }

    private static boolean moveBubble(char[][] map, int dir) {
        boolean isChanged = false;
        if(dir == UP){
            for(int i = 1 ; i <N-1; i++) {
                for(int j = 1 ; j < M-1 ; j++) {
                    boolean check = false;
                    if(map[i][j] != 'R' && map[i][j] != 'B') continue;
                    //if(map[i-1][j] =='R' || map[i-1][j] == 'B'|| map[i-1][j] == '#') continue;
                    int ny = i;
                    while(ny-1 >= 1 && map[ny-1][j]=='.') {
                        isChanged = true;
                        check  = true;

                        if(ny-1 == ansY && j == ansX) {
                            if(map[i][j] == 'R') foundRed  = true;
                            else foundBlue = true;
                            map[i][j] = '.';
                            break;
                        }
                        ny--;
                    }
                    if(check)swap(map,i,j,ny,j);
                }
            }
        }
        else if(dir == DOWN){
            for(int i = N-2; i>=1; i--) {
                for(int j = 1; j< M-1; j++){
                    boolean check = false;
                    if(map[i][j] != 'R' && map[i][j] != 'B') continue;
                    //if(map[i+1][j] =='R' || map[i+1][j] == 'B'|| map[i+1][j] == '#') continue;
                    int ny = i;
                    while(ny + 1 < N && map[ny+1][j]=='.') {
                        isChanged = true;
                        check  = true;
                        if(ny+1 == ansY && j == ansX) {
                            if(map[i][j] == 'R') foundRed  = true;
                            else foundBlue = true;
                            map[i][j] = '.';
                            break;
                        }
                        ny++;
                    }
                    if(check)swap(map,i,j,ny,j);
                }
            }
        }
        else if(dir == LEFT){
            for(int j = 1; j < M-1 ;j++){
                for(int i = 1; i < N-1; i++){
                    boolean check = false;
                    if(map[i][j] != 'R' && map[i][j] != 'B') continue;
                    //if(map[i][j-1] == '#' || map[i][j-1] == 'R' || map[i][j-1] == 'B') continue;

                    int nx = j;
                    while(nx-1 >= 1 && map[i][nx-1]=='.') {
                        isChanged = true;
                        check = true;

                        if(i == ansY && nx-1 == ansX) {
                            if(map[i][j] == 'R') foundRed  = true;
                            else foundBlue = true;
                            map[i][j] = '.';
                            break;
                        }

                        nx--;
                    }

                    if(check) swap(map,i,j,i,nx);
                }
            }
        }
        else {
            for(int j = M-2; j >= 1; j--){
                for(int i = 1; i < N-1; i++) {
                    boolean check = false;
                    if(map[i][j] != 'R' && map[i][j] != 'B') continue;
                    //if(map[i][j+1] == '#' || map[i][j+1] =='R' || map[i][j+1] == 'B') continue;
                    int nx = j;
                    while(nx + 1 < M && map[i][nx+1]=='.') {
                        isChanged = true;
                        check = true;
                        if(i == ansY && nx+1 == ansX) {
                            if(map[i][j] == 'R') foundRed  = true;
                            else foundBlue = true;
                            map[i][j] = '.';
                            break;
                        }
                        nx++;

                    }
                    if(check) swap(map,i,j,i,nx);
                }
            }
        }
        return isChanged;
    }

    private static void swap(char[][] map, int y, int x, int ny, int nx) {
        char temp = map[y][x];
        map[y][x] = map[ny][nx];
        map[ny][nx] = temp;
    }
}
