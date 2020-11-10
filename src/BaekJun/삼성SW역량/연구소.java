package BaekJun.삼성SW역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 연구소 {
    static class Point{
        int y;
        int x;
        Point(int y, int x){
            this.y = y;
            this.x =x;
        }
    }
    static int N;
    static int M;
    static int[][] map;
    static int initSpace = -3;
    static int nowSpace = 0;
    static int maxSpace = 0;
    static List<Point> zombies = new ArrayList<>();

    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        map = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            inputs =br.readLine().split(" ");
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
                if(map[i][j] == 0) initSpace++;
                else if(map[i][j] == 2) zombies.add(new Point(i,j));
            }
        }

        findTreeBlock(new ArrayList<>());
        System.out.println(maxSpace);
    }

    private static void findTreeBlock( List<Point> blocks) {
        if(blocks.size() == 3){
            getMaxSpace(blocks);
            return;
        }

        int minY = -1;
        int minX = -1;
        if(!blocks.isEmpty()){
            minY = blocks.get(blocks.size()-1).y;
            minX = blocks.get(blocks.size()-1).x;
        }
        for(int i = 0 ; i < N ;i++) {
            for(int j = 0; j < M ; j++){
                if(i < minY || (i == minY && j <= minX) ||map[i][j] == 1 || map[i][j] == 2) continue;
                blocks.add(new Point(i,j));
                findTreeBlock(blocks);
                blocks.remove(blocks.size()-1);
            }
        }
    }

    private static void getMaxSpace(List<Point> blocks) {
        nowSpace = initSpace;
        int[][] tempMap = new int[N][M];
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M ; j++) {
                tempMap[i][j] = map[i][j];
            }
        }
        for(int i = 0 ; i < 3; i++){
            Point p = blocks.get(i);
            //System.out.println(p.y+ " "+ p.x);
            tempMap[p.y][p.x] = 1;
        }
        Queue<Point> q = new LinkedList<>(zombies);
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0 ; i< 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny < 0 || ny >= N || nx <0 || nx >= M || tempMap[ny][nx] != 0) continue;
                tempMap[ny][nx] = 2;
                nowSpace--;
                q.add(new Point(ny,nx));
            }
        }
        maxSpace  = Math.max(maxSpace,nowSpace);
    }
}
