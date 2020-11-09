package BaekJun.삼성SW역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 구슬탈출2_1_13469 {
    static class Turn{
        int redY;
        int redX;
        int blueY;
        int blueX;
        int count;
        int before;
        boolean foundBlue;
        boolean foundRed;
        Turn(int ry, int rx, int by, int bx,boolean fr, boolean fb, int count, int before){
            redY = ry;
            redX = rx;
            blueY = by;
            blueX = bx;
            this.count = count;
            this.foundBlue = fb;
            this.foundRed = fr;
            this.before = before;
        }
    }
    static int ansY;
    static int ansX;

    static int N;
    static int M;
    static char[][] map;
    //static boolean[][][][] visited = new boolean[10][10][10][10];

    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int UP = 2;
    static final int DOWN = 3;

    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
         N = Integer.parseInt(input[0]);
         M = Integer.parseInt(input[1]);
        //tempMap = new char[N][M];
        map = new char[N][M];
        int redY = 0;
        int redX = 0;
        int blueY = 0;
        int blueX = 0;
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);
                if (map[i][j] == 'O') {
                    ansY = i;
                    ansX = j;
                    map[i][j] = '.';
                } else if (map[i][j] == 'R') {
                    redY = i;
                    redX = j;
                    map[i][j] = '.';
                } else if (map[i][j] == 'B') {
                    blueY = i;
                    blueX = j;
                    map[i][j] = '.';
                }
            }
        }
        //visited[redY][redX][blueY][blueX] = true;

        Queue<Turn> q = new LinkedList<>();
        q.add(new Turn(redY, redX, blueY, blueX,false,false,0,-1));
        while (!q.isEmpty()) {
            Turn t = q.poll();
            if(t.count > 10) continue;
            if (t.foundBlue) continue;
            if (t.foundRed) {
                answer = t.count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                if((t.before == LEFT && i == RIGHT) || (t.before == RIGHT && i == LEFT) || (t.before==UP && i==DOWN) || (t.before == DOWN && i== UP)) continue;
                Turn nextT = moveBubble(t, i);
                if (isChanged(t, nextT)) q.add(nextT);
            }
        }
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);

    }

    private static boolean isChanged(Turn t, Turn nt) {
       // if(visited[nt.redY][nt.redX][nt.blueY][nt.blueX]) return false;
        //visited[nt.redY][nt.redX][nt.blueY][nt.blueX] = true;
       if( ( t.redY != nt.redY) ||(t.redX != nt.redX) || (t.blueY != nt.blueY) || (t.blueX != nt.blueX)) return true;
       return false;
    }

    private static Turn moveBubble(Turn t, int dir) {
        boolean foundRed = false;
        boolean foundBlue = false;
        map[t.redY][t.redX] = 'R';
        map[t.blueY][t.blueX] = 'B';
        if(dir == UP){
            for(int i = 1 ; i <N-1; i++) {
                for(int j = 1 ; j < M-1 ; j++) {
                    boolean check = false;
                    if(map[i][j] != 'R' && map[i][j] != 'B') continue;
                    //if(map[i-1][j] =='R' || map[i-1][j] == 'B'|| map[i-1][j] == '#') continue;
                    int ny = i;
                    while(ny-1 >= 1 && map[ny-1][j]=='.') {
                        check  = true;
                        if(ny-1 == ansY && j == ansX) {
                            if(map[i][j] == 'R') foundRed  = true;
                            else foundBlue = true;
                            map[i][j] = '.';
                            ny--;
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
                        check  = true;
                        if(ny+1 == ansY && j == ansX) {
                            if(map[i][j] == 'R') foundRed  = true;
                            else foundBlue = true;
                            map[i][j] = '.';
                            ny++;
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
                        check = true;

                        if(i == ansY && nx-1 == ansX) {
                            if(map[i][j] == 'R') foundRed  = true;
                            else foundBlue = true;
                            map[i][j] = '.';
                            nx--;
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
                        check = true;
                        if(i == ansY && nx+1 == ansX) {
                            if(map[i][j] == 'R') foundRed  = true;
                            else foundBlue = true;
                            map[i][j] = '.';
                            nx++;
                            break;
                        }
                        nx++;

                    }
                    if(check) swap(map,i,j,i,nx);
                }
            }
        }
        int redY = 0;
        int redX = 0;
        int blueY = 0;
        int blueX = 0;
        if(foundBlue){
            blueY = ansY;
            blueX = ansX;
        }

        if(foundRed){
            redY = ansY;
            redX = ansX;
        }

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 'R'){
                    redY = i;
                    redX = j;
                    map[i][j] = '.';
                }
                else if(map[i][j] == 'B'){
                    blueY = i;
                    blueX = j;
                    map[i][j] = '.';
                }
            }
        }

        return new Turn(redY,redX,blueY,blueX,foundRed,foundBlue,t.count+1,dir);
    }

    private static void swap(char[][] map, int y, int x, int ny, int nx) {
        char temp = map[y][x];
        map[y][x] = map[ny][nx];
        map[ny][nx] = temp;
    }
}
