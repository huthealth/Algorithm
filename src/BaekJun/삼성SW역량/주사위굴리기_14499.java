package BaekJun.삼성SW역량;

import BaekJun.그리디.과제13904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 주사위굴리기_14499 {

    static int diceX;
    static int diceY;
    static int N;
    static int M;
    static int[][] map;
    static int[][] dice = new int[4][3];
    static int[] dy = {0,0,-1,1};
    static int[] dx = {1,-1,0,0};
    static final int EAST = 0;
    static final int WEST = 1;
    static final int NORTH = 2;
    static final int SOUTH = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
         diceX = Integer.parseInt(input[2]);
        diceY = Integer.parseInt(input[3]);
        int K = Integer.parseInt(input[4]);
        map = new int[N][M];
        for(int i = 0 ; i< N ; i++) {
            input = br.readLine().split(" ");
            for(int j = 0 ; j< M ; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        input= br.readLine().split(" ");
        for(int i = 0 ; i< K ; i++){
            rollDice(Integer.parseInt(input[i])-1);
        }

    }

    private static void rollDice(int direction) {
        int ny = diceY + dy[direction];
        int nx = diceX + dx[direction];
        if(ny <0 || nx < 0 || ny >= N || nx >= M ) return;
        diceY = ny;
        diceX = nx;
        int temp;
        if(direction == EAST){
            temp = dice[1][2];
            dice[1][2] = dice[1][1];
            dice[1][1] = dice[1][0];
            dice[1][0] = dice[3][1];
            dice[3][1] = temp;
        }
        else if( direction == WEST){
            temp = dice[1][0];
            dice[1][0] = dice[1][1];
            dice[1][1] = dice[1][2];
            dice[1][2] = dice[3][1];
            dice[3][1] = temp;
        }
        else if(direction == NORTH){
            temp = dice[0][1];
            dice[0][1] = dice[1][1];
            dice[1][1] = dice[2][1];
            dice[2][1] = dice[3][1];
            dice[3][1] = temp;
        }
        else {
            temp = dice[3][1];
            dice[3][1] = dice[2][1];
            dice[2][1] = dice[1][1];
            dice[1][1] = dice[0][1];
            dice[0][1] = temp;
        }

        if(map[ny][nx] == 0 ) {
            map[ny][nx] = dice[3][1];
        }
        else {
            dice[3][1] = map[ny][nx];
            map[ny][nx] = 0;
        }

        System.out.println(dice[1][1]);
    }
}
