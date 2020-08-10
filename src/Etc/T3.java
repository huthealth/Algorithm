package Etc;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class T3 {
    static class Block{
        int y;
        int x;
        Block(int y,int x){
            this.y= y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt( input);
        char[][] map = new char[N][N];
        for(int i = 0;i<N;i++) {
            input = br.readLine();
            for(int j = 0; j<N;j++) {
                map[i][j] = input.charAt(j);
            }
        }
        int[][] visited = new int[N][N];
        List<Integer> land = new ArrayList<>();
        int[] dy = {1,0,-1,0};
        int[] dx = {0,1,0,-1};
        for(int i = 0; i<N;i++) {
            for(int j =0;j<N;j++) {
                if(visited[i][j] == 0 && map[i][j] =='L') {
                    System.out.println(i +" "+ j);
                    int blockSize = 0;
                    visited[i][j] = 1;
                    Queue<Block> q = new LinkedList<>();
                    q.add(new Block(i,j));
                    while(!q.isEmpty()) {
                        blockSize++;
                        Block b = q.poll();
                        int y = b.y;
                        int x = b.x;
                        for(int k = 0;k<4;k++) {
                            int nY = y + dy[k];
                            int nX = x + dx[k];
                            if(nY>=0 &&nY < N && nX >=0 && nX <N  && visited[nY][nX] ==0 && map[nY][nX] == 'L') {
                                visited[nY][nX] = 1;
                                q.add(new Block(nY,nX));
                            }
                        }
                    }
                    land.add(blockSize);
                }
            }
        }
        if(land.isEmpty()) {
            System.out.printf("%d %d %.2f %d",0,0,0.00,0);
            return;
        }
        Collections.sort(land);
        int maxLand = land.get(land.size()-1);
        int size = land.size();
        for(int i = 0; i< land.size();i++) {
            if(maxLand == land.get(i)) size--;
        }
        if(size == 0) {
            System.out.printf("%d %d %.2f %d",0,0,0.00,0);
            return;
        }
        double average = 0.00;
        for(int i = 0;i<size;i++) {
            average += land.get(i);
        }
        average = average / (double)size;
        if(size %2 == 0) {
            int n1 = land.get((size-1)/2);
            int n2 = land.get((size-1)/2 + 1);
            double mid = (double)(n1+n2) / 2.0;
            System.out.printf("%d %d %.2f %.2f",land.get(size-1),land.get(0),average,mid);
            return;
        }
        int mid = land.get((size-1)/2);
        System.out.printf("%d %d %.2f %d",land.get(size-1),land.get(0),average,mid);
    }
}
