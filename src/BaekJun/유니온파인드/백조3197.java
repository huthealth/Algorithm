package BaekJun.유니온파인드;

import sun.awt.image.ImageWatched;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백조3197 {
    static int[] ary;
    static int[] size;
    static int[][] map;
    static Queue<Point> q = new LinkedList<>();
    static Queue<Point> qq = new LinkedList<>();
    static Point[] birds = new Point[2];
    static int N;
    static int M;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        map = new int[N][M];
        ary = new int[N*M+1];
        size = new int[N*M+1];
        Point L1 = null,L2 = null;
        int countBird =0;
        int countArea = 0;
        for(int i = 0 ; i< N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j<M; j++) {
                if(str.charAt(j) == '.') {
                    q.add(new Point(j,i));
                    map[i][j] = countArea++;
                }
                else if(str.charAt(j) =='X') {
                    map[i][j] = -1;
                }
                else {
                    q.add(new Point(j,i));
                    if(countBird == 0) {
                        countBird++;
                        L1 = new Point(j,i);
                        map[i][j] = countArea++;
                    }
                    else {
                        L2 = new Point(j,i);
                        map[i][j] = countArea++;

                    }
                }
            }
        }
/*
        for(int i = 0 ; i<N; i++) {
            for(int j = 0 ; j<M; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

 */

        for(int i = 0 ; i<N*M; i++) {
            ary[i] = i;
            size[i] = 1;
        }

        int answer = 0;
        while(true) {
            bfs_unify();
            bfs_breakIce();

            int area1 = map[L1.y][L1.x];
            int area2 = map[L2.y][L2.x];
            //System.out.println(area1 + " " + area2);
            if(isConnected(area1,area2)) {
                System.out.println(answer);
                break;
            }
            answer++;
        }

    }

    private static int find(int p ) {
        int root = ary[p];
        while(root != ary[root]) root = ary[root];
        while(root != ary[p]) {
            int next = ary[p];
            ary[p] = root;
            p = next;
        }
        return root;
    }

    private static boolean isConnected(int area1, int area2) {
        return find(area1) == find(area2);
    }

    private static void bfs_breakIce() {
        while(!qq.isEmpty()) {
            Point p = qq.poll();
            int area = map[p.y][p.x];

            for(int i = 0 ; i<4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny >=0 && nx >= 0 && ny < N && nx < M) {
                    if(map[ny][nx] == -1) {
                        map[ny][nx] = area;
                        q.add(new Point(nx,ny));
                    }
                }
            }
        }
    }

    private static void bfs_unify() {
        while(!q.isEmpty()) {
            Point p = q.poll();
            qq.add(p);
            int area = map[p.y][p.x];

            for(int i = 0 ; i< 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny >=0 && nx >= 0 && ny < N && nx < M) {
                    if(map[ny][nx] == -1) continue;
                    int area2 = map[ny][nx];
                    if(ary[area] != ary[area2]) merge(area,area2);
                }
            }
        }
    }

    private static void merge(int p, int q) {
        if(isConnected(p,q)) return;

        int rootP = find(p);
        int rootQ = find(q);

        if(size[rootP] > size[rootQ]) {
            size[rootP] += size[rootQ];
            ary[rootQ] = rootP;
        }
        else {
            size[rootQ] += size[rootP];
            ary[rootP] = rootQ;
        }
    }

}
