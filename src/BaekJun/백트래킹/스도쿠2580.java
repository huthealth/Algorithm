package BaekJun.백트래킹;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 스도쿠2580 {
    static int[][] rowAry = new int[10][10];
    static int[][] colAry = new int[10][10];
    static int[][] smallSquare = new int[10][10];
     static int[][] getSmallSquare = {{0,0,0,0},{0,1,2,3},{0,4,5,6},{0,7,8,9}};

    static int[][] map = new int[10][10];
    static int[][] answer = new int[10][10];
    static int N;
    static ArrayList<Point> list = new ArrayList<>();

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i < 10; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 1; j < 10; j++) {
                if (inputs[j - 1].equals("0")) {
                    list.add(new Point(j, i));
                    continue;
                }
                map[i][j] = Integer.parseInt(inputs[j - 1]);
                rowAry[i][Integer.parseInt(inputs[j - 1])] = 1;
                colAry[j][Integer.parseInt(inputs[j - 1])] = 1;
                int sY = (i-1) / 3 +1;
                int sX = (j-1) / 3 + 1;
                smallSquare[getSmallSquare[sY][sX]][Integer.parseInt(inputs[j - 1])] = 1;
            }
        }
        N = list.size();
        dfs(0);
        for(int i = 1; i <10 ; i++) {
            for(int j = 1 ; j<10; j++) {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void dfs(int now) {
        if (now == N) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    answer[i][j] = map[i][j];
                }
            }
            return;
        }

        Point p = list.get(now);
        int sY = (p.y-1) / 3 +1;
        int sX = (p.x-1) / 3 + 1;
        int smallSquareNum = getSmallSquare[sY][sX];
        for(int i = 1; i<10; i++) {
            if(rowAry[p.y][i] ==0 && colAry[p.x][i] == 0 && smallSquare[smallSquareNum][i] ==0) {
                rowAry[p.y][i] = 1;
                colAry[p.x][i] = 1;
                map[p.y][p.x] = i;
                smallSquare[smallSquareNum][i] = 1;
                dfs(now + 1);
                rowAry[p.y][i] = 0;
                colAry[p.x][i] = 0;
                smallSquare[smallSquareNum][i] = 0;
            }
        }
    }
}